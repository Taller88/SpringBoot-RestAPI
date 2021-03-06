package board.board.service;

import java.util.List;

import board.board.dto.BoardDto;
import board.board.dto.CompanyDto;

public interface BoardService {

	List<BoardDto> selectBoardList() throws Exception;

	void insertBoard(BoardDto board);

	BoardDto selectBoardDetail(int boardIdx);

	void updateBoard(BoardDto board);

	void deleteBoard(int boardIdx);

	
	
}
