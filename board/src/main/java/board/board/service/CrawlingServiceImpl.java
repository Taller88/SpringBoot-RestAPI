package board.board.service;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import board.board.dto.CompanyDto;

@Service
public class CrawlingServiceImpl implements CrawlingService{

	@Override
	public CompanyDto crawlData(String company) {
		String URL="https://finance.naver.com/item/main.nhn?code=053580";
		Document doc=null;
		try {
			doc = Jsoup.connect(URL).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Elements ele=doc.select("div.today");
		String[] arr=ele.text().split(" ");
		CompanyDto dto=new CompanyDto();
		dto.setStockPrice(Integer.parseInt(arr[0].replace(",", "")));
		dto.setCurrentPrice(Integer.parseInt(arr[1].replace(",", "")));
		
		if(arr[3].equals("하락")) {
			dto.setPlusMinus(Integer.parseInt(arr[4].replace(",", ""))*-1);
		}else{
			dto.setPlusMinus(Integer.parseInt(arr[4].replace(",", "")));
		}
		return dto;
	}

}
