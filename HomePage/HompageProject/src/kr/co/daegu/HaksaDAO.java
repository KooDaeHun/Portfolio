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

public class HaksaDAO {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private String sql;
    public DataSource dataFactory;

	public HaksaDAO() {
		try {
			Context ctx = new InitialContext();
			dataFactory = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = dataFactory.getConnection();
		} catch (SQLException e) {
				e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	public void haksaSqlList() {
		sql ="select s.no as sno,s.age as sage,s.irum as sirum,s.hakbun as shakbun,p.age as page,p.irum as pirum,p.subject as psubject,m.age as mage,m.irum as mirum,m.part as mpart from (student s left join professor p on s.no=p.no) left join manager m on s.no=m.no order by s.no asc";
	}
    public ResultSet haksaExecute() {
    	try {
    		pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return rs;
    }
}
