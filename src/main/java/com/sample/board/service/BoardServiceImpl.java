package com.sample.board.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sample.board.mappers.BoardMapper;
import com.sample.board.vo.Board;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public void addNewBoard(Board board) {
		boardMapper.addBoard(board);
	}

	@Override
	public List<Board> getAllBoards() {
		return boardMapper.getBoards();
	}

	@Override
	public Board getBoardInfo(int no) {
		return boardMapper.getBoard(no);
	}
}
