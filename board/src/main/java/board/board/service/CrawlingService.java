package board.board.service;

import board.board.dto.CompanyDto;

public interface CrawlingService {
	CompanyDto crawlData(String company);
	
}
