package kr.co.daegu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ProfessorDAO {
	public DataSource dataFactory;
	private Connection conn;
	private PreparedStatement pstmt;
	private String sql;
	private int cnt;
	private ResultSet rs;
	private ArrayList<ProfessorDTO> professorList;
	private int bun;
	
	public ProfessorDAO() {
		try {
			Context ctx = new InitialContext();
			dataFactory = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = dataFactory.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public int professorInsertSQL(ProfessorDTO professorDTO) {
		sql = "INSERT INTO professor(no, age, irum, subject) "
			+ "VALUES(?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, professorDTO.getBunho());
			pstmt.setString(2, professorDTO.getAge());
			pstmt.setString(3, professorDTO.getIrum());
			pstmt.setString(4, professorDTO.getSubject());
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}
	public void professorNoMaxSql() {
		sql="select max(no)as no from professor";
	}
	public void professorBunho() {
		try {
			professorNoMaxSql();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				bun = rs.getInt("no");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public int getBunho() {
		bun++;
		return bun;
	}
	public ResultSet professorSearchSql(String irum) {
		sql = "SELECT no, age, irum, subject FROM professor WHERE irum=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, irum);
			rs=pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public int professorDeleteSql(String irum) {
		sql = "delete from professor where irum=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, irum);
			cnt=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}
	public int professorUpdateSql(int no, String age, String irum, String subject) {
		sql = "UPDATE professor SET age = ?, irum = ?, subject = ? WHERE no =?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, age);
			pstmt.setString(2, irum);
			pstmt.setString(3, subject);
			pstmt.setInt(4, no);
			cnt=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}
    public void professorSqlList() {
    	sql = "select no,age,irum,subject from professor order by no asc";
    }
    public ResultSet professorExecute() {
    	try {
    		pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return rs;
    }
}
