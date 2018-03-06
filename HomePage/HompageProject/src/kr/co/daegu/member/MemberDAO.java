package kr.co.daegu.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.co.daegu.board.BoardDTO;

public class MemberDAO {
	public DataSource dataFactory;
	   private Connection conn;
	   private String sql;
	   private PreparedStatement pstmt;
	   private ResultSet rs;
	   private ArrayList<MemberDTO> memberList;
	   private int cnt;
	   
	   public MemberDAO() {
		   try {
				Context ctx = new InitialContext();
				dataFactory = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
				conn = dataFactory.getConnection();
			} catch (NamingException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
	   }
	   public void memberClose() {
		   try {
			   conn.close();
			   rs.close();
			   pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	   }
	   public int memberInsert(MemberDTO memberDTO) {//회원가입
		   try {
			sql = "insert into member(id,pw,pwch,irum,nickname,email,emailcheck,smscheck) values(?,?,?,?,?,?,?,?)";
			   pstmt = conn.prepareStatement(sql);
			   pstmt.setString(1, memberDTO.getId());
			   pstmt.setString(2, memberDTO.getPw());
			   pstmt.setString(3, memberDTO.getPwch());
			   pstmt.setString(4, memberDTO.getIrum());
			   pstmt.setString(5, memberDTO.getNickname());
			   pstmt.setString(6, memberDTO.getEmail());
			   pstmt.setString(7, memberDTO.getEmailcheck());
			   pstmt.setString(8, memberDTO.getSmscheck());
			   cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	   }//회원가입
	   public boolean memberIdCheck(MemberDTO memberDTO) {//아이디중복가능여부
		   boolean idcheck=false;
		   try {
			sql = "select id from member where id=?";
			   pstmt = conn.prepareStatement(sql);
			   pstmt.setString(1, memberDTO.getId());
			   rs=pstmt.executeQuery();
			   while(rs.next()) {
				   idcheck=true;
			   }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		   return idcheck;		   				   
	   }//아이디중복가능여부
	   public String memberIdSearch(MemberDTO memberDTO) {//아이디찾기
		   String id=null;
		   try {
			sql = "select id from member where irum=? and email=?";
			   pstmt = conn.prepareStatement(sql);
			   pstmt.setString(1, memberDTO.getIrum());
			   pstmt.setString(2, memberDTO.getEmail());
			   rs=pstmt.executeQuery();
			   while(rs.next()) {
				   id=rs.getString("id");
			   }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		   return id;
	   }//아이디찾기
	   public String memberPwSearch(MemberDTO memberDTO) {//비밀번호찾기
		   String pw=null;
		   try {
			sql = "select pw from member where id=? and irum=? and email=?";
			   pstmt = conn.prepareStatement(sql);
			   pstmt.setString(1, memberDTO.getId());
			   pstmt.setString(2, memberDTO.getIrum());
			   pstmt.setString(3, memberDTO.getEmail());
			   rs=pstmt.executeQuery();
			   while(rs.next()) {
				   pw = rs.getString("pw");
			   }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		   return pw;
	   }//비밀번호찾기
	   public ArrayList<MemberDTO> memberList(MemberDTO memberDTO){//회원전체출력
		   sql = "select id,irum from member";
		   try {
			pstmt = conn.prepareStatement(sql);
			   rs=pstmt.executeQuery();
			   memberList = new ArrayList<MemberDTO>();
			   while(rs.next()) {
				   memberDTO = new MemberDTO();
				   String id=rs.getString("id");
				   String irum=rs.getString("irum");
				   memberDTO.setId(id);
				   memberDTO.setIrum(irum);
				   memberList.add(memberDTO);
			   }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		   return memberList;
	   }//회원전체출력
	   public boolean memberLogin(MemberDTO memberDTO) {//로그인
		   boolean login=false;
		   sql = "select id,pw from member where id=? and pw=?";
		   try {
			pstmt = conn.prepareStatement(sql);
			   pstmt.setString(1, memberDTO.getId());
			   pstmt.setString(2, memberDTO.getPw());
			   rs=pstmt.executeQuery();
			   while(rs.next()) {
				   login=true;
			   }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		   return login;		   
	   }//로그인
	   public MemberDTO memberUpdateView(MemberDTO memberDTO) {//멤버VIEW
		   sql = "select id,pw,pwch,irum,nickname,email from member where id=?";
		   try {
			pstmt = conn.prepareStatement(sql);
			   pstmt.setString(1, memberDTO.getId());
			   rs=pstmt.executeQuery();
			   while(rs.next()) {
				   String id=rs.getString("id");
				   String pw=rs.getString("pw");
				   String pwch=rs.getString("pwch");
				   String irum=rs.getString("irum");
				   String nickname=rs.getString("nickname");
				   String email=rs.getString("email");
				   memberDTO.setId(id);
				   memberDTO.setPw(pw);
				   memberDTO.setPwch(pwch);
				   memberDTO.setIrum(irum);
				   memberDTO.setNickname(nickname);
				   memberDTO.setEmail(email);			   
			   }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		   return memberDTO;
	   }//멤버VIEW
	   public void memberUpdate(MemberDTO memberDTO) {//멤버수정
		   sql = "update member set pw=?,pwch=?,irum=?,nickname=?,email=? where id=?";
		   try {
			pstmt = conn.prepareStatement(sql);
			   pstmt.setString(1, memberDTO.getPw());
			   pstmt.setString(2, memberDTO.getPwch());
			   pstmt.setString(3, memberDTO.getIrum());
			   pstmt.setString(4, memberDTO.getNickname());
			   pstmt.setString(5, memberDTO.getEmail());
			   pstmt.setString(6, memberDTO.getId());
			   cnt=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}		  
	   }//멤버수정
	   public void memberLeave(MemberDTO memberDTO) {//회원탈퇴
		   try {
			sql = "delete from member where id=?";
			   pstmt = conn.prepareStatement(sql);
			   pstmt.setString(1, memberDTO.getId());
			   cnt=pstmt.executeUpdate();
		} catch (SQLException e) {			
			e.printStackTrace();
		}		   
	   }//회원탈퇴
}

