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

public class ManagerDAO {
	public DataSource dataFactory;
	private ArrayList<ManagerDTO> managerList;
	private Connection conn;
	private PreparedStatement pstmt;
	private String sql;
	private int cnt;
	private ResultSet rs;
	private int bun;
	
	public ManagerDAO() {
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

	public int managerInsertSQL(ManagerDTO managerDTO) {
		sql = "INSERT INTO manager(no, age, irum, part) "
			+ "VALUES(?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, managerDTO.getBunho());
			pstmt.setString(2, managerDTO.getAge());
			pstmt.setString(3, managerDTO.getIrum());
			pstmt.setString(4, managerDTO.getPart());
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}
	public void managerNoMaxSql() {
		sql="select max(no)as no from manager";
	}
	public void managerBunho() {
		try {
			managerNoMaxSql();
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
	public ResultSet managerSearchSql(String irum) {
		sql = "SELECT no, age, irum, part FROM manager WHERE irum=?";
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
	public int managerDeleteSql(String irum) {
		sql = "delete from manager where irum=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, irum);
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}
	public int managerUpdateSql(int no, String age, String irum, String part) {
		sql = "UPDATE manager SET age = ?, irum = ?, part = ? WHERE no = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, age);
			pstmt.setString(2, irum);
			pstmt.setString(3, part);
			pstmt.setInt(4, no);
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}
    public void managerSqlList() {
    	sql = "select no,age,irum,part from manager order by no asc";
    }
    public ResultSet managerExecute() {
    	try {
    		pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return rs;
    }
	
}
