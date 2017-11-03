package com.sample.board.mappers;

import java.util.List;
import com.sample.board.vo.Board;

public interface BoardMapper {

	void addBoard(Board board);
	List<Board> getBoards();
	Board getBoard(int no);
}
