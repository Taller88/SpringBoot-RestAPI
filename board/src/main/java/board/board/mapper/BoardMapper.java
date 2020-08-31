package board.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import board.board.dto.BoardDto;

@Mapper
public interface BoardMapper {

	List<BoardDto> selectBoardList() throws Exception;

	void insertBoard(BoardDto board);

	BoardDto selectBoardDetail(int boardIdx);

	void updateHitCount(int boardIdx);

	void updateBoard(BoardDto board);

	void deleteBoard(int boardIdx);
	
}
