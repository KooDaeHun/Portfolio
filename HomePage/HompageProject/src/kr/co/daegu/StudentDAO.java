package kr.co.daegu;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import java.sql.PreparedStatement;

public class StudentDAO {
	public DataSource dataFactory;
	private Connection conn;
	private PreparedStatement pstmt;
	private String sql;
	private int cnt;
	private ResultSet rs;
	private int bun;
	private ArrayList<StudentDTO> studentList;

	public StudentDAO() {
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
	public int studentInsertSQL(StudentDTO studentDTO) {
		sql = "INSERT INTO student(no, age, irum, hakbun) "
			+ "VALUES(?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, studentDTO.getBunho());
			pstmt.setString(2, studentDTO.getAge());
			pstmt.setString(3, studentDTO.getIrum());
			pstmt.setString(4, studentDTO.getHakbun());
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}
	public void studentNoMaxSql() {
		sql="select max(no)as no from student";
	}
	public void studentBunho() {
		try {
			studentNoMaxSql();
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
	public ResultSet studentSearchSql(String irum) {
		sql = "SELECT no, age, irum, hakbun FROM student WHERE irum=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, irum);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public int studentDeleteSql(String irum) {
		sql = "DELETE FROM student WHERE irum=?";
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
	public int studentUpdateSql(int no, String age, String irum, String hakbun) {
		sql = "update student set age=?,irum=?,hakbun=? where no=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, age);
			pstmt.setString(2, irum);
			pstmt.setString(3, hakbun);
			pstmt.setInt(4, no);
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}
    public void studentSqlList() {
    	sql = "select no,age,irum,hakbun from student order by no asc";
    }
    public ResultSet studentExecute() {
    	try {
    		pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return rs;
    }
}
