package kr.co.daegu.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BoardDAO {
	public DataSource dataFactory;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private ArrayList<BoardDTO> boardList;
	private int cnt;
	private String sql;
	
	public BoardDAO() {
		try {
			Context ctx = new InitialContext();
			dataFactory = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = dataFactory.getConnection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void boardClose() {
		try {
			conn.close();
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	게시판 전체 출력
	public ArrayList<BoardDTO> boardList(BoardDTO boardDTO){
		try {
			sql = "SELECT no,title,icon,author,nal,readcount FROM board ORDER BY no ASC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			boardList = new ArrayList<BoardDTO>();
			while(rs.next()) {
				boardDTO = new BoardDTO();
				boardDTO.setNo(rs.getInt("no"));
				boardDTO.setTitle(rs.getString("title"));
				boardDTO.setIcon(rs.getString("icon"));
				boardDTO.setAuthor(rs.getString("author"));
				boardDTO.setNal(rs.getString("nal"));
				boardDTO.setReadcount(rs.getInt("readcount"));
			    boardList.add(boardDTO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return boardList;
	}
	
	public void boardSqlInsert() {
		sql = "SELECT MAX(no) AS NO FROM board";
	}
//	게시판 번호
	public void boardBunho() {
		try {
			boardSqlInsert();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				cnt = rs.getInt("no");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	글쓰기
	public void boardWrite(BoardDTO boardDTO) {
		try {
			boardBunho();
			boardDTO.setNo(cnt + 1);
			sql = "INSERT INTO board(no, title, content, icon, author, nal, readcount) VALUES(?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardDTO.getNo());
			pstmt.setString(2, boardDTO.getTitle());
			pstmt.setString(3, boardDTO.getContent());
			pstmt.setString(4, boardDTO.getIcon());
			pstmt.setString(5, boardDTO.getAuthor());
			pstmt.setString(6, boardDTO.getNal());
			pstmt.setInt(7, boardDTO.getReadcount());
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	게시글 검색
	public ArrayList<BoardDTO> boardSearch(BoardDTO boardDTO) {
		try {
			sql = "SELECT no,title,icon,author,nal,readcount FROM board WHERE title like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,"%"+boardDTO.getTitle()+"%");
			rs = pstmt.executeQuery();
			boardList = new ArrayList<BoardDTO>();
			while (rs.next()) {
				boardDTO = new BoardDTO();
				boardDTO.setNo(rs.getInt("no"));
				boardDTO.setTitle(rs.getString("title"));
				boardDTO.setIcon(rs.getString("icon"));
				boardDTO.setAuthor(rs.getString("author"));
				boardDTO.setNal(rs.getString("nal"));
				boardDTO.setReadcount(rs.getInt("readcount"));
				boardList.add(boardDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardList;
	}
//	삭제 게시글 전내용
	public ArrayList<BoardDTO> boardContent(BoardDTO boardDTO) {// 삭제게시글전내용
		try {
			sql = "select no,title,content,icon,author,nal,readcount from board where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardDTO.getNo());
			rs = pstmt.executeQuery();
			boardList = new ArrayList<BoardDTO>();
			while (rs.next()) {
				boardDTO = new BoardDTO();
				boardDTO.setNo(rs.getInt("no"));
				boardDTO.setTitle(rs.getString("title"));
				boardDTO.setContent(rs.getString("content"));
				boardDTO.setIcon(rs.getString("icon"));
				boardDTO.setAuthor(rs.getString("author"));
				boardDTO.setNal(rs.getString("nal"));
				boardDTO.setReadcount(rs.getInt("readcount"));
				boardList.add(boardDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardList;
	}
//	게시글 삭제
	public void boardDelete(BoardDTO boardDTO) {
		try {
			sql = "DELETE FROM board WHERE no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardDTO.getNo());
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
//	게시글 수정
	public void boardUpdate(BoardDTO boardDTO) {
		try {
			sql = "UPDATE board SET content=?,title=?,author=? WHERE no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardDTO.getContent());
			pstmt.setString(2, boardDTO.getTitle());
			pstmt.setString(3, boardDTO.getAuthor());
			pstmt.setInt(4, boardDTO.getNo());
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
//	조회수 증가
	public void boardReadCount(BoardDTO boardDTO) {
		try {
			sql = "UPDATE board SET readcount=? WHERE no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardDTO.getReadcount() + 1);
			pstmt.setInt(2, boardDTO.getNo());
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int totalCount() {// 페이징처리: 전체레코드 개수 구하기
		int count = 0;
		try {
			sql = "select count(*) from board";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}// 페이징처리: 전체레코드 개수 구하기

	public PageTo page(int curPage) {// 페이지구현
		PageTo pageTo = new PageTo();
		int totalCount = totalCount();
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		
		try {
			conn=pstmt.getConnection();
			sql = "select no,title,author,content,nal,readcount from board";
			pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			// TYPE_SCROLL_INSENSITIVE:scroll은 가능하나, 변경된 사항은 적용되지 않음
			// 양방향, 스크롤 시 업데이트 반영안함
			// CONCUR_READ_ONLY :커서의 위치에서 정보 업데이트 불가,ResultSet의 변경이 불가능
			rs = pstmt.executeQuery();
			int perPage = pageTo.getPerPage();// 5
			int skip = (curPage - 1) * perPage;
			if (skip > 0) {
				rs.absolute(skip);
			}
			// ResultSet의 absolute메소드를 이용하여 해당 페이지의 Cursor 의 위치로 이동...
			for (int i = 0; i < perPage && rs.next(); i++) {
				int no = rs.getInt("no");
				String author = rs.getString("author");
				String title = rs.getString("title");
				String content = rs.getString("content");
				int readCount = rs.getInt("readcount");

				BoardDTO data = new BoardDTO();
				data.setNo(no);
				data.setAuthor(author);
				data.setTitle(title);
				data.setContent(content);
				data.setReadcount(readCount);
				list.add(data);
			}
			pageTo.setList(list);// ArrayList 저장
			pageTo.setTotalCount(totalCount);// 전체레코드개수
			pageTo.setCurPage(curPage);// 현재페이지
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pageTo;
	}// 페이지구현
}
