package ex01.parsing;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class BoxOfficeOpenApi {
    public static final String KEY = "4298055d882fbc5c120b654c1fa42815";
    public static final String WEEKLY_BOXOFFICE_XML_URL = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.xml";
    public static final String WEEKLY_BOXOFFICE_JSON_URL = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.json";

    public static void main(String[] args) {
//        parseWeeklyBoxOfficeByXML("20240713");
        parseWeeklyBoxOfficeByJson("20240713");

    }

    // https://www.delftstack.com/ko/howto/java/java-read-xml/
    public static void parseWeeklyBoxOfficeByXML(String targetDt) {
        try {
            // 1. URL 가공 코드
            StringBuilder sb = new StringBuilder(WEEKLY_BOXOFFICE_XML_URL);
            sb.append("?" + "key=" + KEY);
            sb.append("&" + "targetDt=" + targetDt);
            sb.append("&" + "weekGb=" + 1); // 주말만 보는 옵션
            System.out.println(sb);

            // URLEncoder.encode : 특정 char-set으로 인코딩 하는 함수, 주로 UTF-8을 사용, UTF-8일 경우 영문은 안해도 무관!
            //                     한글일 경우는 반드시 UTF-8 포멧팅하는 것을 권장
//			urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); // 과한 인코딩 예시
//			urlBuilder.append("&" + "name"+ "=" + URLEncoder.encode("홍길동", "UTF-8"));
            
            // 2. URL을 통해 HTML을 요청하는 코드를 작성
            URL url = new URL(sb.toString()); // url 객체 생성
            HttpURLConnection conn = (HttpURLConnection) url.openConnection(); // URL을 통해 HTTP 요청
            conn.setRequestMethod("GET"); // 요청 방식을 GET으로 정하는 코드

            // API마다 요청에 대한 property 셋팅이 달라지는 코드
            // 아래 4가지 중에서 골라서 선택을 해야하는데, 안될수도 있으니 정확한 방법은 API 예제 코드를 참고하거나 문서 참고
//	        conn.setRequestProperty("Content-type", "application/json");
//	        conn.setRequestProperty("Content-type", "application/xml");
            conn.setRequestProperty("Accept", "application/xml");
//	        conn.setRequestProperty("Accept", "application/json");
            System.out.println("Response code : " + conn.getResponseCode()); // 실제 url로 부터 페이징을 요청하는 단계

            // 3. Response code 식별해서 성공하면 파싱을 시작하는 코드
            if(conn.getResponseCode() < 200 || conn.getResponseCode() > 299) {
                System.out.println("페이지 요청에 실패하였습니다.");
                return;
            }

            // 4. XML 파싱 시작, DocumentBuilderFactory 활용 (1.8부터 가능!)
            //Document : 문서, 태그(트리) 상태의 객체, xml 파일!
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(conn.getInputStream()); // 연결스트림을 가져와서 xml 파싱을 준비하는 과정
            doc.normalizeDocument(); // xml을 다시 표준형태로 만들어주는 코드, 없어도 되는데 웬만하면 하자
            // 셋팅부 끝!

            // 본격적인 파싱부
            System.out.println("Root element(tag) : " + doc.getDocumentElement().getNodeName());
            System.out.println("----------------------------------------------");

            // 자식 node 접근하는 방법 -> 트리 순회하는 방법으로 접근 필요
            // -> 추천하지 않음!!
            System.out.println(doc.getDocumentElement().getChildNodes().item(0).getTextContent());
            System.out.println(doc.getDocumentElement().getChildNodes().item(1).getTextContent());
            System.out.println(doc.getDocumentElement().getChildNodes().item(2).getTextContent());

            // getElementsByTagName를 통해 순회하는 것을 추천 ★★★★★
            // ※ 주의 : 파싱 대상이 되는 문자열은 대소문자 구별됨, 반드시 올바른 대소문자 사용할것
            // getElementsByTagName : 태그 이름으로부터 node 가져오는 기능, node안에 node 있을수 있는 구조, Tree구조
            //                        장점 : 자식 부모 상관 없이 tag 이름을 통해서 node 가져올수 있음.
            //                        s가 붙는 경우 list로 반환됨
//	        <tag-name>content</tag-name>

            System.out.println("boxofficeType : " + doc.getElementsByTagName("boxofficeType").item(0).getTextContent());
            System.out.println("showRange : " + doc.getElementsByTagName("showRange").item(0).getTextContent());
            System.out.println("yearWeekTime : " + doc.getElementsByTagName("yearWeekTime").item(0).getTextContent());

            NodeList nodeList = doc.getElementsByTagName("weeklyBoxOffice");
            for(int i = 0; i < nodeList.getLength(); i++){
                Node node = nodeList.item(i);
                System.out.println("\nCurrent node : " + node.getNodeName());
                if(node.getNodeType() == Node.ELEMENT_NODE){ // ELEMENT_NODE : 배열이 아닌 데이터 노드일때
                    Element e = (Element) node;
                    System.out.println("rank : " + e.getElementsByTagName("rank").item(0).getTextContent());
                    System.out.println("movieNm : " + e.getElementsByTagName("movieNm").item(0).getTextContent());
                    System.out.println("openDt : " + e.getElementsByTagName("openDt").item(0).getTextContent());
                    System.out.println("audiCnt : " + e.getElementsByTagName("audiCnt").item(0).getTextContent());

                    // 가끔 누락된 데이터값이 있을때 에러처리 예시
                    // -> 누락된 컬럼마다 skip 할수 있도록 try-catch문으로 감싼다.

                    try {
                        System.out.println("error : " + e.getElementsByTagName("error").item(0).getTextContent());
                    } catch (Exception e2) {}

                    // 위와 같이 모든 컬럼에 try-catch문을 감싸서 도배되는 것을 방지하기 위해
                    // 메소드로 빼서 정리해서 만들어준다.
                    String str = getString(e, "error");
                    System.out.println("error : " + str);
                    System.out.println();
                }
            }

        } catch (Exception e) {
            System.out.println("에러 발생!!!!");
            e.printStackTrace();
        }
    }

    private static String getString(Element e, String name) {
        try {
            return e.getElementsByTagName(name).item(0).getTextContent();
        } catch (Exception ex) {}
        return null;
    }

    // https://codechacha.com/ko/java-parse-json/
    public static void parseWeeklyBoxOfficeByJson(String targetDt) {
        try {
            // 1. URL 가공 코드 시작
            StringBuilder urlBuilder = new StringBuilder(WEEKLY_BOXOFFICE_JSON_URL);
            urlBuilder.append("?" + "key" + "="+KEY);
            urlBuilder.append("&" + "targetDt" + "=" + targetDt);
            urlBuilder.append("&" + "weekGb"+ "=" + 1); // 주말만보는 옵션
            System.out.println(urlBuilder);

            // 국문 키워드가 섞인 경우에는 아래와 같이 URLEncoder.encode 사용이 필수, 단 영어+숫자만 있으면 사용 안해도 무관
//			urlBuilder.append("?" + "serviceKey" + "=서비스키"); /*Service Key*/
//	        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
//	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("1000", "UTF-8")); /*한 페이지 결과 수*/

            // 1. URL 가공 코드 끝

            // 2. URL을 HTTP 객체를 통해 요청하는 코드 시작
            URL url = new URL(urlBuilder.toString()); // URL 객체 생성
            HttpURLConnection conn = (HttpURLConnection) url.openConnection(); // URL을 HTTP를 요청할 객체를 다시 생성
            conn.setRequestMethod("GET"); // get 방식으로 요청하는 코드

            // API 마다 요청하는 방법 이달라짐 대략적으로 아래 2개 방식을 선택하면 보통 호출 가능
//	        conn.setRequestProperty("Content-type", "application/json");
//	        conn.setRequestProperty("Content-type", "application/xml");
//            conn.setRequestProperty("Accept", "application/xml");
	        conn.setRequestProperty("Accept", "application/json");

            System.out.println("Response code: " + conn.getResponseCode()); // 실제 HTTP로 호출을 시도하는 코드
            // 2. URL을 HTTP 객체를 통해 요청하는 코드 끝

            // 3. Response code를 통해 성공 여부를 판단하고 파싱을 시작하는 코드
            //    성공은 200번 대
            if(conn.getResponseCode() < 200 || conn.getResponseCode() >= 300) {
                System.out.println("페이지가 잘못되었습니다.");
                return;
            }

            // 4. Json 파싱부 시작
            // JSONObject : Key-value로 구성된 JS객체를 의미
            // JSONArray : Json배열로 구성된 객체를 의미
            InputStream is = conn.getInputStream();
            InputStreamReader isr = new InputStreamReader(is, "UTF-8");
            BufferedReader br = new BufferedReader(isr);

            // JSONParser : 트리 구조로 순회해야한다.
            JSONParser jsonParser = new JSONParser();
            JSONObject rootObj = (JSONObject) jsonParser.parse(br); // root라 데이터도 없는 곳
            JSONObject childObj = (JSONObject) rootObj.get("boxOfficeResult"); // 데이터가 존재하는 곳

            // get : key값으로 value를 가져오는 메소드
            // Root의 자식 출력
            System.out.println("boxofficeType : " + childObj.get("boxofficeType"));
            System.out.println("showRange : " + childObj.get("showRange"));
            System.out.println("yearWeekTime : " + childObj.get("yearWeekTime"));
            System.out.println("weeklyBoxOfficeList : " + childObj.get("weeklyBoxOfficeList"));
            System.out.println("weeklyBoxOfficeList : " + childObj.get("weeklyBoxOfficeList").getClass().getName());
            System.out.println("--------------------------------------------------------------");

            // weeklyBoxOfficeList 반복문으로 순회하는 방법
            JSONArray array =  (JSONArray) childObj.get("weeklyBoxOfficeList");

            for(int i = 0; i < array.size(); i++){
                JSONObject obj = (JSONObject) array.get(i);
                System.out.println("rank : " + obj.get("rank"));
                System.out.println("movieNm : " + obj.get("movieNm"));
                System.out.println("openDt : " + obj.get("openDt"));
                System.out.println("audiAcc : " + obj.get("audiAcc"));
                System.out.println("error : " + obj.get("error")); // 없을 경우 null을 반환!
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
