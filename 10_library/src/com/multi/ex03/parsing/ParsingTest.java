package com.multi.ex03.parsing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://www.kobis.or.kr/kobisopenapi/homepg/apiservice/searchServiceInfo.do
// http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20120101

// Parsing : 해석하다, IT용어로 외부에 있는 특정 Form(html, xml, json, csv)를 데이터(객체)화 하는 과정
// 요구사항 : json 파일 양식을 읽어 1 ~ 10위 까지의 영화 이름, 누적 관객수를 출력 

//---------------------------------------
//1위, 미션임파서블, 누적 관객수 : 5328435
//2위, 마이 웨이, 누적 관객수 : 1739543
//3위, 셜록홈즈, 누적 관객수 : 1442861
//4위, 퍼펙트 게임, 누적 관객수 : 895416
//5위, 프렌즈, 누적 관객수 : 202909
//6위, 라이온 킹, 누적 관객수 : 171285
//7위, 오싹한 연애, 누적 관객수 : 2823060
//8위, 극장판 포켓몬스터 베스트 위시「비크티니와 백의 영웅 레시라무」, 누적 관객수 : 285959
//9위, 앨빈과 슈퍼밴드3, 누적 관객수 : 516289
//10위, 극장판 포켓몬스터 베스트 위시 「비크티니와 흑의 영웅 제크로무」, 누적 관객수 : 235070
//---------------------------------------

public class ParsingTest {
	public static String text = "{\"boxOfficeResult\":{\"boxofficeType\":\"일별 박스오피스\",\"showRange\":\"20120101~20120101\",\"dailyBoxOfficeList\":[{\"rnum\":\"1\",\"rank\":\"1\",\"rankInten\":\"0\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20112207\",\"movieNm\":\"미션임파서블:고스트프로토콜\",\"openDt\":\"2011-12-15\",\"salesAmt\":\"2776060500\",\"salesShare\":\"36.3\",\"salesInten\":\"-415699000\",\"salesChange\":\"-13\",\"salesAcc\":\"40541108500\",\"audiCnt\":\"353274\",\"audiInten\":\"-60106\",\"audiChange\":\"-14.5\",\"audiAcc\":\"5328435\",\"scrnCnt\":\"697\",\"showCnt\":\"3223\"},{\"rnum\":\"2\",\"rank\":\"2\",\"rankInten\":\"1\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20110295\",\"movieNm\":\"마이 웨이\",\"openDt\":\"2011-12-21\",\"salesAmt\":\"1189058500\",\"salesShare\":\"15.6\",\"salesInten\":\"-105894500\",\"salesChange\":\"-8.2\",\"salesAcc\":\"13002897500\",\"audiCnt\":\"153501\",\"audiInten\":\"-16465\",\"audiChange\":\"-9.7\",\"audiAcc\":\"1739543\",\"scrnCnt\":\"588\",\"showCnt\":\"2321\"},{\"rnum\":\"3\",\"rank\":\"3\",\"rankInten\":\"-1\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20112621\",\"movieNm\":\"셜록홈즈 : 그림자 게임\",\"openDt\":\"2011-12-21\",\"salesAmt\":\"1176022500\",\"salesShare\":\"15.4\",\"salesInten\":\"-210328500\",\"salesChange\":\"-15.2\",\"salesAcc\":\"10678327500\",\"audiCnt\":\"153004\",\"audiInten\":\"-31283\",\"audiChange\":\"-17\",\"audiAcc\":\"1442861\",\"scrnCnt\":\"360\",\"showCnt\":\"1832\"},{\"rnum\":\"4\",\"rank\":\"4\",\"rankInten\":\"0\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20113260\",\"movieNm\":\"퍼펙트 게임\",\"openDt\":\"2011-12-21\",\"salesAmt\":\"644532000\",\"salesShare\":\"8.4\",\"salesInten\":\"-75116500\",\"salesChange\":\"-10.4\",\"salesAcc\":\"6640940000\",\"audiCnt\":\"83644\",\"audiInten\":\"-12225\",\"audiChange\":\"-12.8\",\"audiAcc\":\"895416\",\"scrnCnt\":\"396\",\"showCnt\":\"1364\"},{\"rnum\":\"5\",\"rank\":\"5\",\"rankInten\":\"0\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20113271\",\"movieNm\":\"프렌즈: 몬스터섬의비밀 \",\"openDt\":\"2011-12-29\",\"salesAmt\":\"436753500\",\"salesShare\":\"5.7\",\"salesInten\":\"-89051000\",\"salesChange\":\"-16.9\",\"salesAcc\":\"1523037000\",\"audiCnt\":\"55092\",\"audiInten\":\"-15568\",\"audiChange\":\"-22\",\"audiAcc\":\"202909\",\"scrnCnt\":\"290\",\"showCnt\":\"838\"},{\"rnum\":\"6\",\"rank\":\"6\",\"rankInten\":\"1\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"19940256\",\"movieNm\":\"라이온 킹\",\"openDt\":\"1994-07-02\",\"salesAmt\":\"507115500\",\"salesShare\":\"6.6\",\"salesInten\":\"-114593500\",\"salesChange\":\"-18.4\",\"salesAcc\":\"1841625000\",\"audiCnt\":\"45750\",\"audiInten\":\"-11699\",\"audiChange\":\"-20.4\",\"audiAcc\":\"171285\",\"scrnCnt\":\"244\",\"showCnt\":\"895\"},{\"rnum\":\"7\",\"rank\":\"7\",\"rankInten\":\"-1\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20113381\",\"movieNm\":\"오싹한 연애\",\"openDt\":\"2011-12-01\",\"salesAmt\":\"344871000\",\"salesShare\":\"4.5\",\"salesInten\":\"-107005500\",\"salesChange\":\"-23.7\",\"salesAcc\":\"20634684500\",\"audiCnt\":\"45062\",\"audiInten\":\"-15926\",\"audiChange\":\"-26.1\",\"audiAcc\":\"2823060\",\"scrnCnt\":\"243\",\"showCnt\":\"839\"},{\"rnum\":\"8\",\"rank\":\"8\",\"rankInten\":\"0\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20112709\",\"movieNm\":\"극장판 포켓몬스터 베스트 위시「비크티니와 백의 영웅 레시라무」\",\"openDt\":\"2011-12-22\",\"salesAmt\":\"167809500\",\"salesShare\":\"2.2\",\"salesInten\":\"-45900500\",\"salesChange\":\"-21.5\",\"salesAcc\":\"1897120000\",\"audiCnt\":\"24202\",\"audiInten\":\"-7756\",\"audiChange\":\"-24.3\",\"audiAcc\":\"285959\",\"scrnCnt\":\"186\",\"showCnt\":\"348\"},{\"rnum\":\"9\",\"rank\":\"9\",\"rankInten\":\"0\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20113311\",\"movieNm\":\"앨빈과 슈퍼밴드3\",\"openDt\":\"2011-12-15\",\"salesAmt\":\"137030000\",\"salesShare\":\"1.8\",\"salesInten\":\"-35408000\",\"salesChange\":\"-20.5\",\"salesAcc\":\"3416675000\",\"audiCnt\":\"19729\",\"audiInten\":\"-6461\",\"audiChange\":\"-24.7\",\"audiAcc\":\"516289\",\"scrnCnt\":\"169\",\"showCnt\":\"359\"},{\"rnum\":\"10\",\"rank\":\"10\",\"rankInten\":\"0\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20112708\",\"movieNm\":\"극장판 포켓몬스터 베스트 위시 「비크티니와 흑의 영웅 제크로무」\",\"openDt\":\"2011-12-22\",\"salesAmt\":\"125535500\",\"salesShare\":\"1.6\",\"salesInten\":\"-40756000\",\"salesChange\":\"-24.5\",\"salesAcc\":\"1595695000\",\"audiCnt\":\"17817\",\"audiInten\":\"-6554\",\"audiChange\":\"-26.9\",\"audiAcc\":\"235070\",\"scrnCnt\":\"175\",\"showCnt\":\"291\"}]}}";
	public static void main(String[] args) {
		String[] array1 = text.split("\\["); // [는 특수문자로 '\'를 붙여줘야한다.
		System.out.println(array1.length);
		for(String str : array1) {
			System.out.println(str);
		}
		text = text.split("\\[")[1];
		System.out.println("Header 분리 완료");
		System.out.println(text);
		
		String[] array2 = text.split("\\]");
		System.out.println(array2.length);
		for(String str : array2) {
			System.out.println(str);
		}
		text = text.split("]")[0];
		System.out.println("Tail 분리 완료");
		System.out.println(text);
		
		System.out.println("body를 가져오는 방법");
		String[] array3 = text.split("},");
		for(String str : array3) {
			System.out.println(str);
		}
		System.out.println("--------------------------------------------");
		// 정보 단위에서 쓰레기 문자열 제거
		for(int i = 0; i < array3.length; i++) {
			array3[i] = array3[i].replace("{", "").replace("}", "").strip();
			System.out.println(array3[i]);
		}
		System.out.println("쓰레기 문자열 제거 완료!!!");
		System.out.println("--------------------------------------------");

		// 컬렉션으로 Key-Value 형태로 데이터를 분리하는 과정
		List<Map<String, String>> list = new ArrayList<>();
		for(String str : array3) {
			String[] tempArray = str.split(",");
//			System.out.println(Arrays.toString(tempArray));
			Map<String, String> map = new HashMap<>();
			for(String str2 : tempArray) {
				String name = str2.split(":")[0].replace("\"", "").strip();
				String value = str2.split(":")[1].replace("\"", "").strip();
//				System.out.println(name +" : " + value);
				map.put(name, value);
			}
			System.out.println(map);
			list.add(map); // 맵 객체를 배열로 담는 과정
		}
		// 컬렉션 객체화 완료!!
		System.out.println("컬렉션화 완료!!!");
		
		System.out.println("---------------------------------------");
		for(Map<String, String> map : list) {
			String print = "";
			print += map.get("rank") +"위, ";
			print += map.get("movieNm");
			print += ", 누적 관객수 : " + map.get("audiAcc");
			System.out.println(print);
		}
		System.out.println("---------------------------------------");
	}
	//	※ 파싱이 필요할 경우 손으로 짜면 안되고 외부 라이브러리를 통해 정확한 파싱이 가능하다.
	//     -> 나중에 활용할 예정!!
}