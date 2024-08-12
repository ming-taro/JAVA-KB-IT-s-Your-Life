package com.boxoffice.api;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.boxoffice.model.vo.Boxoffice;

public class OpenAPIManagerForJson {
	public static final String KEY = "be34f20d99e875855b6997ecb0c02f27";
	public static final String WEEKLY_BOXOFFICE_JSON_URL = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.json";

	public static void main(String[] args) {
		List<Boxoffice> list = parse("20231201");
		for(Boxoffice b : list) {
			System.out.println(b.toString());
		}
	}
	
	public static List<Boxoffice> parse(String targetDt) {
		List<Boxoffice> list = new ArrayList<>();
		try {
			StringBuilder urlBuilder = new StringBuilder(WEEKLY_BOXOFFICE_JSON_URL);
			urlBuilder.append("?" + "key=" + KEY);
			urlBuilder.append("&" + "targetDt=" + targetDt);
			urlBuilder.append("&" + "weekGb=" + "0");
			System.out.println(urlBuilder.toString());
			
			URL url = new URL(urlBuilder.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");

			int code = conn.getResponseCode(); // 실제 page를 요청하는 코드부
			System.out.println("ResponseCode : " + code);
			if (code < 200 || code >= 300) {
				System.out.println("페이지가 잘못되었습니다.");
				return list;
			}
			
			InputStreamReader isr = new InputStreamReader(conn.getInputStream(), "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			
			JSONParser jsonParser = new JSONParser(); 
			JSONObject rootObj = (JSONObject) jsonParser.parse(br);
			JSONObject childObj = (JSONObject) rootObj.get("boxOfficeResult");
			JSONArray array = (JSONArray) childObj.get("weeklyBoxOfficeList");
			for(int i = 0; i< array.size(); i++) {
				JSONObject obj = (JSONObject) array.get(i);
				int bNo = 0;
				int rnum = getIntData(obj, "rnum");
				int rank = getIntData(obj, "rank");
				int rankInten = getIntData(obj, "rankInten");
				String rankOldAndNew = getStrData(obj, "rankOldAndNew");
				String movieCd = getStrData(obj, "movieCd");
				String movieNm = getStrData(obj, "movieNm");
				Date openDt = getDateData(obj, "openDt");
				long salesAmt = getLongData(obj, "salesAmt");
				double salesShare = getDoubleData(obj, "salesShare");
				long salesInten = getLongData(obj, "salesInten");
				double salesChange = getDoubleData(obj, "salesChange");
				long salesAcc = getLongData(obj, "salesAcc");
				long audiCnt = getLongData(obj, "audiCnt");
				long audiInten = getLongData(obj, "audiInten");
				double audiChange = getDoubleData(obj, "audiChange");
				long audiAcc = getLongData(obj, "audiAcc");
				long scrnCnt = getLongData(obj, "scrnCnt");
				long showCnt = getLongData(obj, "showCnt");
				Boxoffice office = new Boxoffice(bNo, rnum, rank, rankInten, rankOldAndNew, movieCd, movieNm, openDt, salesAmt, salesShare, salesInten, salesChange, salesAcc, audiCnt, audiInten, audiChange, audiAcc, scrnCnt, showCnt, rankOldAndNew, movieCd, movieNm);
				list.add(office);
			}                                                             
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	private static String getStrData(JSONObject obj , String key){
		String str = (String) obj.get(key);
		if(str == null) {
			return "-";
		}else {
			return str;
		}
	}
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private static Date getDateData(JSONObject obj , String key){
		String str = (String) obj.get(key);
		Date date = null;
		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	private static long getLongData(JSONObject obj , String key){
		String str = (String) obj.get(key);
		if(str != null) {
			try {
				return Long.parseLong(str);
			} catch (Exception e) {}
		}
		return 0;
	}
	
	private static int getIntData(JSONObject obj , String key){
		String str = (String) obj.get(key);
		if(str != null) {
			try {
				return Integer.parseInt(str);
			} catch (Exception e) {}
		}
		return 0;
	}
	
	private static double getDoubleData(JSONObject obj , String key){
		String str = (String) obj.get(key);
		if(str != null) {
			try {
				return Double.parseDouble(str);
			} catch (Exception e) {}
		}
		return 0;
	}
	
}
