package board.board.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import board.board.dto.BoardDto;
import board.board.dto.CompanyDto;
import board.board.service.BoardService;
import board.board.service.CrawlingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

@Api(description="Crawling REST API")
@RestController
public class RestCrawlingApiController {
	private Logger log=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CrawlingService crawlingService;
	
	
	@ApiOperation(value="웹 케시 데이터 크롤링")
	@RequestMapping(value="/api/crawling/{company}", method=RequestMethod.GET)
	public CompanyDto crawlData(@PathVariable("company") String company) throws Exception{
		log.debug("크롤링 회사명: "+company);
		return crawlingService.crawlData(company);
	}
	
	
	
}