package com.sample.board.web;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.sample.board.service.BoardService;
import com.sample.board.vo.Board;
import com.sample.board.vo.BoardForm;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value= {"/home.do", "/list.do"})
	public String list(Model model) {
		
		List<Board> boards = boardService.getAllBoards();
		model.addAttribute("boards", boards);
		
		return "/WEB-INF/views/list.jsp";
	}
	@RequestMapping("/form.do")
	public String form() {
		
		return "/WEB-INF/views/form.jsp";
	}
	@RequestMapping("/add.do")
	// 임의의 객체를 넣어주면 form의 입력값을 받는 객체라고 판단
	// request.getParameter("")를 실행해서 이름이 같은 변수에 값을 입력
	// 따라서 객체 호출하면 그 입력 값이 출력됨
	public String submit(BoardForm boardForm) {
		//System.out.println(boardForm);
		
		Board board = new Board();
		// boardForm -> board으로 변수명이 같은 것들끼리 값을 옮겨줌
		// 단, 변수의 이름과 타입이 같아야 함
		BeanUtils.copyProperties(boardForm, board);
		//System.out.println(board);
		
		boardService.addNewBoard(board);
		
		return "redirect:/home.do";
	}
	@RequestMapping("/detail.do")
	// no=?를 안 적을 경우, no=1이 되게 한다.
	//public String detail(@RequestParam(value="no", required=false, defaultValue="1") int no) {
	public String detail(int no, Model model) {
		//System.out.println(no);
		
		Board board = boardService.getBoardInfo(no);
		model.addAttribute("board", board);
		
		return "/WEB-INF/views/detail.jsp";
	}
}
