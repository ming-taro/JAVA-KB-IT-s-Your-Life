package ex02.crawling;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class JsoupExam {

    // https://offbyone.tistory.com/116
    public static void main(String[] args) throws Exception {
        // 다음 뉴스 페이지 크롤링
        String URL = "http://media.daum.net/digital/";

//         <li>
//            <strong class="tit_g">
//                <span class="info_cp">KBS</span>
//                <a href="https://v.daum.net/v/20240718081124648" class="link_txt">[KBS-NASA 인터뷰] “우주 좀 아는데…” 부국장님의 한국을 위한 조언은?</a>
//            </strong>
//        </li>
//        <li>
//            <strong class="tit_g">
//                <span class="info_cp">조선비즈</span>
//                <a href="https://v.daum.net/v/20240718060140550" class="link_txt">[올림픽도 과학이다] 파리올림픽에 첫 선 보이는 ‘브레이킹’…물리학을 극복하라</a>
//            </strong>
//        </li>
        Connection conn = Jsoup.connect(URL);
        Document doc = conn.get(); // Document : html 문서를 의미

        //	Elements : 태그 List로 구성된 객체
        //	Element : 태그 하나만 의미

        // getElementsByTag : 태그 기준으로 클롤링 하는 방법
        Elements elements =  doc.getElementsByTag("a");
        for(Element element : elements){
            Elements elements2 = element.getElementsByClass("link_txt");
            if(!elements2.isEmpty() && !elements2.toString().contains("#direct_")){
                System.out.println(elements2.toString());
                System.out.println("제목 : " + element.text());
                System.out.println("링크 : " + element.attribute("href").getValue());
            }
        }
        System.out.println("--------------------------------------------------");

        // Class + 부모자식으로 검색하는 방법
        Element newsmajorElement = doc.getElementsByClass("list_newsmajor").get(0);
        System.out.println(newsmajorElement);
        Elements newListElements = newsmajorElement.getElementsByTag("strong");
        for(Element element : newListElements){
//            Element spanElement = element.getElementsByTag("span").get(0);
//            Element aElement = element.getElementsByTag("a").get(0);
            Element spanElement = element.child(0); // 자식으로 접근하는 방법
            Element aElement = element.child(1);
//            System.out.println("spanElement : " + spanElement);
//            System.out.println("aElement : " + aElement);
            System.out.println("제목 : " +  aElement.text() );
            System.out.println("링크 : " +  aElement.attr("href") );
            System.out.println("제공자 : " +  spanElement.text() );
            System.out.println();
        }
        System.out.println("-----------------------------------------------");


        // css query를 통해 접근하는 방법 (class를 통해 접근하는 방법)
//		Elements newListElements2 = doc.select(".list_newsmajor .tit_g");
        Elements newListElements2 = doc.select(".list_newsmajor strong"); // class : list_newsmajor strong태그 검색법
        for(int i = 0; i < newListElements2.size(); i++) {
            Element spanTag = newListElements.get(i).getElementsByTag("span").get(0);
            Element aTag = newListElements.get(i).getElementsByTag("a").get(0);
            System.out.println("제목 :  " + aTag.text());
            System.out.println("링크 :  " + aTag.attr("href"));
            System.out.println("작성자 : " + spanTag.text());
            System.out.println();
        }

        System.out.println("---------------------------------------------------");
        System.out.println("벅스 100");
        URL = "https://music.bugs.co.kr/chart";
        conn = Jsoup.connect(URL);
        doc = conn.get();
        Elements titles = doc.select(".title > a");
        Elements artists = doc.select(".artist > a");
        for(int i = 0; i < titles.size(); i++) {
            System.out.print(i+1+"위 : ");
            System.out.print(titles.get(i).text().strip() +" - ");
            System.out.print(artists.get(i).text().strip());
            System.out.println();
        }

    }
}
