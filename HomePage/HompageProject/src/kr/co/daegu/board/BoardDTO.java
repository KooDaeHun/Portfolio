package kr.co.daegu.board;

import java.io.Serializable;

public class BoardDTO implements Serializable {
	private int no;
	private String title;
	private String icon;
	private String author;
	private String nal;
	private int readcount;
	private String content;
	
	public BoardDTO() {
		
	}
	
	public BoardDTO(int no, String title, String icon, String author, String nal, int readcount, String content) {
		super();
		this.no = no;
		this.title = title;
		this.icon = icon;
		this.author = author;
		this.nal = nal;
		this.readcount = readcount;
		this.content = content;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getNal() {
		return nal;
	}
	public void setNal(String nal) {
		this.nal = nal;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "BoardDTO [no=" + no + ", title=" + title + ", icon=" + icon + ", author=" + author + ", nal=" + nal
				+ ", readcount=" + readcount + ", content=" + content + "]";
	}
	
	
}
