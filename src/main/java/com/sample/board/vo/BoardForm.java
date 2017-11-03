package com.sample.board.vo;

public class BoardForm {

	// commend 객체의 변수 -> input box의 name값과 똑같이 만듦
	// -> 입력 폼(not table)과 연관있는 객체 
	// 생성 목적 -> 유효성 check
	private String title;
	private String writer;
	private String contents;

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	@Override
	public String toString() {
		return "BoardForm [title=" + title + ", writer=" + writer + ", contents=" + contents + "]";
	}
}
