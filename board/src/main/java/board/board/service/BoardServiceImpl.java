package board.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.board.dto.BoardDto;
import board.board.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;
	
	
	
	@Override
	public List<BoardDto> selectBoardList() throws Exception {
		return boardMapper.selectBoardList();
	}



	@Override
	public void insertBoard(BoardDto board) {
		boardMapper.insertBoard(board);
	}



	@Override
	public BoardDto selectBoardDetail(int boardIdx) {
		/**
		 * 여기서는 두가지 로직이 처리된다. 
		 * 글 번호(pk)를 가지고 해당 글의 컬럼들을 다 가져오는 로직1 
		 * 해당 글의 조회수를 증가시키는 로직 2
		 */
		boardMapper.updateHitCount(boardIdx);
		BoardDto board=boardMapper.selectBoardDetail(boardIdx);
		return board;
	}



	@Override
	public void updateBoard(BoardDto board) {
		boardMapper.updateBoard(board);
	}



	@Override
	public void deleteBoard(int boardIdx) {
		boardMapper.deleteBoard(boardIdx);
	}

}
