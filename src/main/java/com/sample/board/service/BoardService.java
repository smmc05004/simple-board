package com.sample.board.service;

import java.util.List;
import com.sample.board.vo.Board;

public interface BoardService {

	void addNewBoard(Board board);
	List<Board> getAllBoards();
	Board getBoardInfo(int no);
}
