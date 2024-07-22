package ex03.csv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 전라남도 메뉴정보
// https://www.data.go.kr/data/15076624/fileData.do

// 전라남도 식당 정보
// https://www.data.go.kr/data/15076621/fileData.do

// 1. 식당과 모든 메뉴를 탐색할수 있는 기능 
// 2. 식당을 찾으면 메뉴까지 보여주는 기능  
// 3. 메뉴의 키워드를 조회하면 식당 정보가 같이 나올수 있는 기능 

public class RunMain {
	public static void main(String[] args) {
		List<LineInfo> menuList = CSVParser.makeCSVList("30_ParsingCrawlingCsv/전라남도_메뉴정보_20210120.csv", "UTF-8");
		System.out.println("메뉴정보 출력");
//		menuList.forEach((v) -> System.out.println(v));
		System.out.println("--------------------------------------------");
		
		List<LineInfo> restaurantList = CSVParser.makeCSVList("30_ParsingCrawlingCsv/전라남도_식당정보_20201229.csv", "EUC-KR");
		System.out.println("식당 정보 출력");
//		restaurantList.forEach((v) -> System.out.println(v));
		System.out.println("--------------------------------------------");
		
		System.out.println("menuList size : " + menuList.size());
		System.out.println("restaurantList size : " + restaurantList.size());
		
		
		// 1. 식당과 모든 메뉴를 탐색할수 있는 기능 
		// 1.1 ) 무지성 접근 -> 결론 느리다!
//		for(LineInfo info : restaurantList) {
//			String rId = info.getData("식당ID");
//			for(LineInfo minfo : menuList) {
//				if(minfo.getData("식당ID").equals(rId)) {
//					System.out.println(minfo);
//				}
//			}
//			System.out.println("------------------------------------------------------");
////			System.out.println(rId);
//		}
		
		// 1.2 빠른 접근 방법
		// -> map으로 자료구조 구성 필요!
		
		// 식당ID - 식당 Line 정보
		Map<String, LineInfo> restaurantIDToLineInfoMap 
										= new HashMap<String, LineInfo>();
		// 식당ID - 메뉴 리스트
		Map<String, List<LineInfo>> restaurantIDToMenuListMap 
										= new HashMap<String, List<LineInfo>>();
		
		// 초기화 코드!
		// 순서 존재, 식당-식당 List를 먼저 구성하고 메뉴 리스트를 구성해야함
		for(LineInfo info : restaurantList) {
			restaurantIDToLineInfoMap.put(info.getData("식당ID"), info);
		}
		
		for(LineInfo info : menuList) {
			String rId = info.getData("식당ID");
			List<LineInfo> list = restaurantIDToMenuListMap.get(rId);
			if(list == null) {
				list = new ArrayList<>();
				restaurantIDToMenuListMap.put(rId, list);
			}
			list.add(info);
		}
//		restaurantIDToLineInfoMap.forEach((k,v) -> System.out.println(k+" : "+v));
//		restaurantIDToMenuListMap.forEach((k,v) -> System.out.println(k+" : "+v));
		
		// 출력부
		for(LineInfo info : restaurantList) {
			String rid = info.getData("식당ID");
			System.out.println(info);
			List<LineInfo> list = restaurantIDToMenuListMap.get(rid);
			for(LineInfo info2 : list) {
				System.out.println(info2);
			}
			System.out.println("-------------------------------------------");
		}
		System.out.println("------------------------------------------------------------");
		
		
//		2. 식당을 찾으면 메뉴까지 보여주는 기능
		String keyword = "오리";
		for(LineInfo info : restaurantList) {
			if(info.getData("식당명").contains(keyword)) {
				System.out.println("==========================================================");
				System.out.println(info);
				String rid = info.getData("식당ID");
				List<LineInfo> list = restaurantIDToMenuListMap.get(rid);
				for(LineInfo info2 : list) {
					System.out.println(info2);
				}
				System.out.println("==========================================================");
			}
		}
		System.out.println("------------------------------------------------------------");
		
//		3. 메뉴의 키워드를 조회하면 식당 정보가 같이 나올수 있는 기능
		String keyword2 = "닭갈비";
		for(LineInfo info : menuList) {
			if(info.getData("메뉴명").contains(keyword2)) {
				System.out.println("*********************************************************");
				System.out.println(info);
				String rid = info.getData("식당ID");
				LineInfo info2 = restaurantIDToLineInfoMap.get(rid);
				System.out.println(info2);
				System.out.println("*********************************************************");
			}
		}
	}
}








