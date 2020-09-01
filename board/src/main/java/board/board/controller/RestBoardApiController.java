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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

@Api(description="게시판 REST API")
@RestController
public class RestBoardApiController {
	private Logger log=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BoardService boardService;
	
	@ApiOperation(value="게시글 목록 조회")
	@RequestMapping(value="/api/board", method=RequestMethod.GET)
	public List<BoardDto> openBoardList() throws Exception{
		 return boardService.selectBoardList();
	}
	
	@ApiOperation(value="게시글 작성")
	@RequestMapping(value="/api/board/write", method=RequestMethod.POST)
	public void insertBoard(@RequestBody BoardDto board) throws Exception{
		boardService.insertBoard(board);
	}
	@ApiOperation(value="게시글 상세 내용 조회")
	@RequestMapping(value="/api/board/{boardIdx}", method=RequestMethod.GET)
	public BoardDto openBoardDetail(@PathVariable("boardIdx") int boardIdx) throws Exception{
		return boardService.selectBoardDetail(boardIdx);
	}
	@ApiOperation(value="게시글 상세 내용 수정")
	@RequestMapping(value="/api/board/{boardIdx}", method=RequestMethod.PUT)
	public String updateBoard(@RequestBody BoardDto board) throws Exception{
		boardService.updateBoard(board);
		return "redirect:/board";
	}
	@ApiOperation(value="게시글 삭제")
	@RequestMapping(value="/api/board/{boardIdx}", method=RequestMethod.DELETE)
	public String deleteBoard(@PathVariable("boardIdx") int boardIdx) throws Exception{
		boardService.deleteBoard(boardIdx);
		return "redirect:/board";
	}
	
	
	
	
}