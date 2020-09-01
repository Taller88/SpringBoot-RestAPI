package board;

import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import board.board.dto.CompanyDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardApplicationTests {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Test
	public void contextLoads() {
	}

	@Test
	public void testSqlSession() throws Exception{
		System.out.println(sqlSession.toString());
	}
	
	@Test
	public void testCrawling() throws Exception{
		String URL="https://finance.naver.com/item/main.nhn?code=053580";
//		String URL="https://www.naver.com/";
		Document doc=Jsoup.connect(URL).get();
		Elements ele=doc.select("div.today");
//		Elements ele=doc.select("a.title");
		System.out.println(ele.text());
		System.out.println(ele.size());
		String[] arr=ele.text().split(" ");
		CompanyDto dto=new CompanyDto();
		dto.setStockPrice(Integer.parseInt(arr[0].replace(",", "")));
		dto.setCurrentPrice(Integer.parseInt(arr[1].replace(",", "")));
		
		if(arr[3].equals("하락")) {
			dto.setPlusMinus(Integer.parseInt(arr[4].replace(",", ""))*-1);
		}else{
			dto.setPlusMinus(Integer.parseInt(arr[4].replace(",", "")));
		}
//		System.out.println(dto.getCurrentPrice()+" "+dto.getStockPrice()+" "+dto.getPlusMinus());
		Iterator<Element> ie1 = ele.select("p.no_today").iterator();
//		Iterator<Element> ie1 = ele.select("strong").iterator();

		while (ie1.hasNext()) {
			System.out.println("iterator: "+ie1.next().text().split(" ")[0].replace(",",""));
//			System.out.println("iterator: "+ie1.next().text());
		}
	}
	
}
