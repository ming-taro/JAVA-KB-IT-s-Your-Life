package com.boxoffice.api;

import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.boxoffice.model.vo.Boxoffice;

public class OpenApiManagerForXML {
	public static final String KEY = "be34f20d99e875855b6997ecb0c02f27";
	public static final String WEEKLY_BOXOFFICE_XML_URL = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.xml";
	public static final String WEEKLY_BOXOFFICE_JSON_URL = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.json";

	public static List<Boxoffice> parse(LocalDate searchDate) {
		String dateStr = searchDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
		List<Boxoffice> list = new ArrayList<>();

		StringBuffer urlBuffer = new StringBuffer();
		urlBuffer.append(WEEKLY_BOXOFFICE_XML_URL);
		urlBuffer.append("?" + "key=" + KEY); // 첫 번째만 물음표로 설정
		urlBuffer.append("&" + "targetDt=" + dateStr);
		urlBuffer.append("&" + "weekGb=" + "0");

		System.out.println(urlBuffer);

		try {
			URL url = new URL(urlBuffer.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/xml");
			int code = conn.getResponseCode(); // 실제 호출하는 부
			System.out.println("ResponseCode : " + code);

			if (code < 200 || code > 300) {
				System.out.println("페이지가 잘못되었습니다.");
				return null;
			}

			// 3. 페이지 Parsing(해석)
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();

			Document doc = db.parse(conn.getInputStream()); // xml 부를 파싱하여 객체화

			doc.getDocumentElement().normalize();

			System.out.println("Root Element : " + doc.getDocumentElement().getNodeName());
			System.out.println("======================================================");

			String boxofficeType = doc.getElementsByTagName("boxofficeType").item(0).getTextContent();
			String showRange = doc.getElementsByTagName("showRange").item(0).getTextContent();
			String yearWeekTime = doc.getElementsByTagName("yearWeekTime").item(0).getTextContent();

			NodeList nList = doc.getElementsByTagName("weeklyBoxOffice");
			for (int i = 0; i < nList.getLength(); i++) {
				Node node = nList.item(i);
				System.out.println("\nCurrent Element : " + node.getNodeName());
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					try {
						Element eElement = (Element) node;
						System.out.println("rank    : " + getStrData(eElement, "rank"));
						System.out.println("movieNm : " + getStrData(eElement, "movieNm"));
						System.out.println("openDt  : " + getStrData(eElement, "openDt"));
						System.out.println("audiAcc : " + getStrData(eElement, "audiAcc"));

						int rnum = getIntData(eElement, "rnum");
						int rank = getIntData(eElement, "rank");
						int rankInten = getIntData(eElement, "rankInten");
						String rankOldAndNew = getStrData(eElement, "rankOldAndNew");
						String moviecd = getStrData(eElement, "movieCd");
						String movienm = getStrData(eElement, "movieNm");
						Date opendt = getDateData(eElement, "openDt");
						long salesamt = getLongData(eElement, "salesAmt");
						double salesshare = getDoubleData(eElement, "salesShare");
						long salesinten = getLongData(eElement, "salesInten");
						double saleschange = getDoubleData(eElement, "salesChange");
						long salesacc = getLongData(eElement, "salesAcc");
						long audicnt = getLongData(eElement, "audiCnt");
						long audiinten = getLongData(eElement, "audiInten");
						double audichange = getDoubleData(eElement, "audiChange");
						long audiacc = getLongData(eElement, "audiAcc");
						long scrncnt = getLongData(eElement, "scrnCnt");
						long showcnt = getLongData(eElement, "showCnt");
						Boxoffice box = new Boxoffice(0, rnum, rank, rankInten, rankOldAndNew, moviecd, movienm, opendt,
								salesamt, salesshare, salesinten, saleschange, salesacc, audicnt, audiinten, audichange,
								audiacc, scrncnt, showcnt, boxofficeType, showRange, yearWeekTime);
						list.add(box);
					} catch (Exception e) {
						System.out.println("데이터가 잘못되었습니다!");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	private static String getStrData(Element eElement, String tagName) {
		try {
			return eElement.getElementsByTagName(tagName).item(0).getTextContent();
		} catch (Exception e) {
			return "-";
		}
	}

	private static int getIntData(Element eElement, String tagName) {
		try {
			return Integer.parseInt(eElement.getElementsByTagName(tagName).item(0).getTextContent());
		} catch (Exception e) {
			return 0;
		}
	}

	private static long getLongData(Element eElement, String tagName) {
		try {
			return Long.parseLong(eElement.getElementsByTagName(tagName).item(0).getTextContent());
		} catch (Exception e) {
			return 0;
		}
	}

	private static double getDoubleData(Element eElement, String tagName) {
		try {
			return Double.parseDouble(eElement.getElementsByTagName(tagName).item(0).getTextContent());
		} catch (Exception e) {
			return 0.0;
		}
	}


	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private static Date getDateData(Element eElement, String tagName) {
		try {
			String str =eElement.getElementsByTagName(tagName).item(0).getTextContent();
			return sdf.parse(str);
		} catch (Exception e) {
			return null;
		}
	}

}
