package board.board.controller;

import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.board.dto.BoardDto;
import board.board.service.BoardService;

@Controller
public class BoardController {

	Logger log=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/board/openBoardDetail.do")
	public ModelAndView openBoardDetail(@RequestParam int boardIdx) throws Exception{
		ModelAndView mv=new ModelAndView("/board/boardDetail");
		BoardDto dto=boardService.selectBoardDetail(boardIdx);
		mv.addObject("board", dto);
		log.debug("openBoardDetail: 디테일 오픈 ");
		
		return mv;
	}
	
	@RequestMapping("/board/openBoardList.do")
	public ModelAndView openBoardList() throws Exception{
		ModelAndView mv=new ModelAndView("/board/boardList");
		List<BoardDto> list=boardService.selectBoardList();
		mv.addObject("list", list);
		log.debug("openBoardList: list 오픈");
		
		return mv;
	}
	@RequestMapping("/board/openBoardWrite.do")
	public String openBoardWrite() throws Exception{
		log.debug("openBoardWrite");
		return "/board/boardWrite";
	}
	
	@RequestMapping("/board/insertBoard.do")
	public String insertBoard(BoardDto board) throws Exception{
		boardService.insertBoard(board);
		log.debug("insertBoard");
		return "redirect:/board/openBoardList.do";
	}
	
	@RequestMapping("/board/updateBoard.do")
	public String updateBoard(BoardDto board) throws Exception{
		boardService.updateBoard(board);
		log.debug("updateBoard");
		return "redirect:/board/openBoardList.do";
	}
	
	
	@RequestMapping("/board/deleteBoard.do")
	public String deleteBoard(int boardIdx) throws Exception{
		boardService.deleteBoard(boardIdx);
		log.debug("deleteBoard");
		
		return "redirect:/board/openBoardList.do";
	}
	
	@RequestMapping("/data/crawling.do")
	public void crawlingDate() throws Exception{
		log.debug("정진우");
		
	}
}
