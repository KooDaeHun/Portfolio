package kr.co.daegu;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class HaksaFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDTO studentDTO;
	private StudentDAO studentDAO;
	private ProfessorDTO professorDTO;
	private ProfessorDAO professorDAO;
	private ManagerDTO managerDTO;
	private ManagerDAO managerDAO;
	private HaksaDAO haksaDAO;
	private ResultSet rs;
	
	public HaksaFrontController() {
		studentDTO = new StudentDTO();
		studentDAO = new StudentDAO();
		professorDTO = new ProfessorDTO();
		professorDAO = new ProfessorDAO();
		managerDTO = new ManagerDTO();
		managerDAO = new ManagerDAO();
		haksaDAO = new HaksaDAO();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//		Day20180219/studentInsert.do
		String requestURI = request.getRequestURI();
		//		Day20180219
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		if(command.equals("/studentInsert.do")) {
			String bunho = request.getParameter("bunho");
			int number = Integer.parseInt(bunho);
			if(number == 0) {
				number = 1;
			}
			
			String age = request.getParameter("age");
			String irum = request.getParameter("irum");
			String hakbun = request.getParameter("hakbun");
			
			studentDAO.studentBunho();
			int bun = studentDAO.getBunho();
			
			studentDTO.setBunho(bun);
			studentDTO.setAge(age);
			studentDTO.setIrum(irum);
			studentDTO.setHakbun(hakbun);
			
			int cnt = studentDAO.studentInsertSQL(studentDTO);
			
			if(cnt > 0) {
				out.print("µî·Ï¼º°ø");
				out.print("<br>");
			} else {
				out.print("µî·Ï½ÇÆĞ");
				out.print("<br>");
			}
			out.print("<!Doctype html>");
			out.print("<html>");
			out.print("<head>");
			out.print("<meta charset=utf-8>");
			out.print("</head>");
			out.print("<body>");
			out.print("<a href='index.jsp'>¸ŞÀÎÀ¸·Î</a>");
			out.print("</body>");
			out.print("</html>");
		} else if(command.equals("/studentSearch.do")) {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			boolean result = false;
			
			String irum = request.getParameter("irum");
			
			out.print("<!Doctype html>");
			out.print("<html>");
			out.print("<head>");
			out.print("<meta charset=utf-8>");
			out.print("</head>");
			out.print("<body>");
			rs = studentDAO.studentSearchSql(irum);
			try {
				while(rs.next()) {
					int bunho = rs.getInt("no");
					String age = rs.getString("age");
					String name = rs.getString("irum");
					String hakbun = rs.getString("hakbun");
					
					out.print("¹øÈ£ : "+bunho+"<br>");
					out.print("³ªÀÌ : "+age+"<br>");
					out.print("ÀÌ¸§ : "+name+"<br>");
					out.print("ÇĞ¹ø : "+hakbun+"<br>");
					result = true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(result == true) {
				out.print("<h1>"+irum+"ÇĞ»ı´ÔÀÌ °Ë»öµÇ¾ú½À´Ï´Ù.</h1>");
				result = false;
			} else {
				out.print("<h1>"+irum+"ÇĞ»ı´ÔÀ» Ã£À» ¼ö ¾ø½À´Ï´Ù.</h1>");
			}
			out.print("<a href='index.jsp'>¸ŞÀÎÀ¸·Î</a>");
			out.print("</body>");
			out.print("</html>");
		} else if(command.equals("/studentDelete.do")) {
			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("utf-8");
			
			String irum = request.getParameter("irum");
			out.print("<!Doctype html>");
			out.print("<html>");
			out.print("<head>");
			out.print("<meta charset=utf-8>");
			out.print("</head>");
			out.print("<body>");
			out.print("ÀÌ¸§:" + irum + "<br>");
			
			int cnt = studentDAO.studentDeleteSql(irum);
			
			out.print("<h1>" + cnt + "°Ç ÇĞ»ıÀÌ »èÁ¦µÇ¾ú½À´Ï´Ù.</h1>");
			out.print("<a href='index.jsp'>¸ŞÀÎÀ¸·Î</a>");
			out.print("</body>");
			out.print("</html>");
		} else if(command.equals("/studentUpdate.do")) {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			String no=request.getParameter("no");
			String age=request.getParameter("age");
			String irum=request.getParameter("irum");
			String hakbun=request.getParameter("hakbun");
			int num = Integer.parseInt(no);
			
			int cnt = studentDAO.studentUpdateSql(num, age, irum, hakbun);
			
			out.print("<!Doctype html>");
			out.print("<html>");
			out.print("<head>");
			out.print("<meta charset='utf-8'>");
			out.print("</head>");
			out.print("<body>");
			out.print(cnt+"°Ç ÇĞ»ıÀÌ ¼öÁ¤µÇ¾ú½À´Ï´Ù.<br>");
			out.print("<a href='index.jsp'>¸ŞÀÎÀ¸·Î</a>");
			out.print("</body>");
			out.print("</html>");			
		} else if(command.equals("/professorInsert.do")) {
			String bunho = request.getParameter("bunho");
			int number = Integer.parseInt(bunho);
			if(number == 0) {
				number = 1;
			}
			
			String age = request.getParameter("age");
			String irum = request.getParameter("irum");
			String subject = request.getParameter("subject");
			
			professorDAO.professorBunho();
			int bun = professorDAO.getBunho();
			
			professorDTO.setBunho(bun);
			professorDTO.setAge(age);
			professorDTO.setIrum(irum);
			professorDTO.setSubject(subject);
			
			int cnt = professorDAO.professorInsertSQL(professorDTO);
			
			if(cnt > 0) {
				out.print("µî·Ï¼º°ø");
				out.print("<br>");
			} else {
				out.print("µî·Ï½ÇÆĞ");
				out.print("<br>");
			}
			out.print("<!Doctype html>");
			out.print("<html>");
			out.print("<head>");
			out.print("<meta charset=utf-8>");
			out.print("</head>");
			out.print("<body>");
			out.print("<a href='index.jsp'>¸ŞÀÎÀ¸·Î</a>");
			out.print("</body>");
			out.print("</html>");
		} else if (command.equals("/professorSearch.do")) {
			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("utf-8");
			boolean result = false;
			String irum = request.getParameter("irum");
			out.print("<!Doctype html>");
			out.print("<html>");
			out.print("<head>");
			out.print("<meta charset=utf-8>");
			out.print("</head>");
			out.print("<body>");
			
			rs = professorDAO.professorSearchSql(irum);
			
			try {
				while(rs.next()) {
					int bunho = rs.getInt("no");		
					String age = rs.getString("age");
					String name = rs.getString("irum");
					String subject = rs.getString("subject");
					
					out.print("¹øÈ£ : "+bunho+"<br>");
					out.print("³ªÀÌ : "+age+"<br>");
					out.print("ÀÌ¸§ : "+name+"<br>");
					out.print("°ú¸ñ : "+subject+"<br>");
					result = true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(result == true) {
				out.println("<h1>"+irum+"±³¼ö´ÔÀÌ °Ë»öµÇ¾ú½À´Ï´Ù.</h1>");
				result = false;
			} else {
				out.println("<h1>"+irum+"±³¼ö´ÔÀ» Ã£À» ¼ö ¾ø½À´Ï´Ù.</h1>");
			}
			out.print("<a href='index.jsp'>¸ŞÀÎÀ¸·Î</a>");
			out.print("</body>");
			out.print("</html>");
		} else if(command.equals("/professorDelete.do")) {
			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("utf-8");
			
			String irum = request.getParameter("irum");
			out.print("<!Doctype html>");
			out.print("<html>");
			out.print("<head>");
			out.print("<meta charset=utf-8>");
			out.print("</head>");
			out.print("<body>");
			out.print("ÀÌ¸§:"+irum+"<br>");
			
			
			int cnt = professorDAO.professorDeleteSql(irum);
			
			out.print("<h1>"+cnt+"°Ç ±³¼ö´ÔÀÌ »èÁ¦µÇ¾ú½À´Ï´Ù.</h1>");
			out.print("<a href='index.jsp'>¸ŞÀÎÀ¸·Î</a>");
			out.print("</body>");
			out.print("</html>");
		} else if(command.equals("/professorUpdate.do")) {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			
			String no = request.getParameter("no");
			String age = request.getParameter("age");
			String irum = request.getParameter("irum");
			String subject = request.getParameter("subject");
			int num = Integer.parseInt(no);
			
			int cnt = professorDAO.professorUpdateSql(num, age, irum, subject);
			
			out.print("<!Doctype html>");
			out.print("<html>");
			out.print("<head>");
			out.print("<meta charset='utf-8'>");
			out.print("</head>");
			out.print("<body>");
			out.print(cnt+"°Ç ±³¼ö´ÔÀÌ ¼öÁ¤µÇ¾ú½À´Ï´Ù.<br>");
			out.print("<a href='index.jsp'>¸ŞÀÎÀ¸·Î</a>");
			out.print("</body>");
			out.print("</html>");	
		} else if(command.equals("/managerInsert.do")) { 
			String bunho = request.getParameter("bunho");
			int number = Integer.parseInt(bunho);
			if(number == 0) {
				number = 1;
			}
			
			String age = request.getParameter("age");
			String irum = request.getParameter("irum");
			String part = request.getParameter("part");
			
			managerDAO.managerBunho();
			int bun = managerDAO.getBunho();
			
			managerDTO.setBunho(bun);
			managerDTO.setAge(age);
			managerDTO.setIrum(irum);
			managerDTO.setPart(part);
			
			int cnt = managerDAO.managerInsertSQL(managerDTO);
			
			if(cnt > 0) {
				out.print("µî·Ï¼º°ø");
				out.print("<br>");
			} else {
				out.print("µî·Ï½ÇÆĞ");
				out.print("<br>");
			}
			out.print("<!Doctype html>");
			out.print("<html>");
			out.print("<head>");
			out.print("<meta charset=utf-8>");
			out.print("</head>");
			out.print("<body>");
			out.print("<a href='index.jsp'>¸ŞÀÎÀ¸·Î</a>");
			out.print("</body>");
			out.print("</html>");
		} else if(command.equals("/managerSearch.do")) {
			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("utf-8");
			boolean result = false;
			String irum = request.getParameter("irum");
			out.print("<!Doctype html>");
			out.print("<html>");
			out.print("<head>");
			out.print("<meta charset=utf-8>");
			out.print("</head>");
			out.print("<body>");
			
			rs = managerDAO.managerSearchSql(irum);
			
			try {
				while(rs.next()) {
					int bunho = rs.getInt("no");
					String age = rs.getString("age");
					String name = rs.getString("irum");
					String part = rs.getString("part");
				
					out.print("¹øÈ£ : "+bunho+"<br>");
					out.print("³ªÀÌ : "+age+"<br>");
					out.print("ÀÌ¸§ : "+name+"<br>");
					out.print("ºÎ¼­ : "+part+"<br>");
					result = true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(result == true) {
				out.println("<h1>"+irum+"°ü¸®ÀÚ´ÔÀÌ °Ë»öµÇ¾ú½À´Ï´Ù..</h1>");
			} else {
				out.println("<h1>"+irum+"°ü¸®ÀÚ´ÔÀ» ¯À» ¼ö ¾ø½À´Ï´Ù..</h1>");
			}
			out.print("<a href='index.jsp'>¸ŞÀÎÀ¸·Î</a>");
			out.print("</body>");
			out.print("</html>");
		} else if(command.equals("/managerDelete.do")) {
			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("utf-8");
			String irum = request.getParameter("irum");
			out.print("<!Doctype html>");
			out.print("<html>");
			out.print("<head>");
			out.print("<meta charset=utf-8>");
			out.print("</head>");
			out.print("<body>");
			out.print("ÀÌ¸§:" + irum + "<br>");
			
			int cnt = managerDAO.managerDeleteSql(irum);
			
			out.print("<h1>" + cnt + "°Ç°ü¸®ÀÚ´ÔÀÌ »èÁ¦µÇ¾ú½À´Ï´Ù.</h1>");
			out.print("<a href='index.jsp'>¸ŞÀÎÀ¸·Î</a>");
			out.print("</body>");
			out.print("</html>");
		} else if(command.equals("/managerUpdate.do")) {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			
			String no = request.getParameter("no");
			String age = request.getParameter("age");
			String irum = request.getParameter("irum");
			String part = request.getParameter("part");
			int num = Integer.parseInt(no);
			
			int cnt = managerDAO.managerUpdateSql(num, age, irum, part);
			
			out.print("<!Doctype html>");
			out.print("<html>");
			out.print("<head>");
			out.print("<meta charset='utf-8'>");
			out.print("</head>");
			out.print("<body>");
			out.print(cnt+"°Ç °ü¸®ÀÚ´ÔÀÌ ¼öÁ¤µÇ¾ú½À´Ï´Ù.<br>");
			out.print("<a href='index.jsp'>¸ŞÀÎÀ¸·Î</a>");
			out.print("</body>");
			out.print("</html>");	
		} else if (command.equals("/studentList.do")) {
			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("utf-8");
			out.print("<!Doctype html>");
			out.print("<html>");
			out.print("<head>");
			out.print("<meta charset=utf-8>");
			out.print("</head>");
			out.print("<body>");
			studentDAO.studentSqlList();
			rs = studentDAO.studentExecute();
			out.print("<table border='1' cellspacing='0' cellpadding='0' width='300px'>");
			out.print("<tr align='center'>");
			out.print("<td>¹øÈ£</td><td>³ªÀÌ</td><td>ÀÌ¸§</td><td>ÇĞ¹ø</td>");
			out.print("</tr>");
			try {
				while(rs.next()) {
					int bunho = rs.getInt("no");
					String age = rs.getString("age");
					String irum = rs.getString("irum");
					String hakbun = rs.getString("hakbun");
					out.print("<tr align='center'>");
					out.print("<td>"+bunho+"</td><td>"+age+"</td><td>"+irum+"</td><td>"+hakbun+"</td>");
					out.print("</tr>");
				}
				out.print("</table>");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			out.print("<a href='index.jsp'>¸ŞÀÎÀ¸·Î</a>");
			out.print("</body>");
			out.print("</html>");
		} else if (command.equals("/professorList.do")) {
			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("utf-8");
			out.print("<!Doctype html>");
			out.print("<html>");
			out.print("<head>");
			out.print("<meta charset=utf-8>");
			out.print("</head>");
			out.print("<body>");
			professorDAO.professorSqlList();
			rs = professorDAO.professorExecute();
			    out.print("<table border='1' cellspacing='0' cellpadding='0' width='300px'>");
			    out.print("<tr align='center'>");
			    out.print("<td>¹øÈ£</td><td>³ªÀÌ</td><td>ÀÌ¸§</td><td>°ú¸ñ</td>");
			    out.print("</tr>");
			try {
				while(rs.next()) {
					int bunho = rs.getInt("no");
					String age = rs.getString("age");
					String irum = rs.getString("irum");
					String subject = rs.getString("subject");
					out.print("<tr align='center'>");
					out.print("<td>"+bunho+"</td><td>"+age+"</td><td>"+irum+"</td><td>"+subject+"</td>");
					out.print("</tr>");
				}
				out.print("</table>");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			out.print("<a href='index.jsp'>¸ŞÀÎÀ¸·Î</a>");
			out.print("</body>");
			out.print("</html>");
		} else if (command.equals("/managerList.do")) {
			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("utf-8");
			out.print("<!Doctype html>");
			out.print("<html>");
			out.print("<head>");
			out.print("<meta charset=utf-8>");
			out.print("</head>");
			out.print("<body>");
			managerDAO.managerSqlList();
			rs = managerDAO.managerExecute();
			
			out.print("<table border='1' cellspacing='0' cellpadding='0' width='300px'>");
		    out.print("<tr align='center'>");
		    out.print("<td>¹øÈ£</td><td>³ªÀÌ</td><td>ÀÌ¸§</td><td>ºÎ¼­</td>");
		    out.print("</tr>");
		    
		    try {
				while(rs.next()) {
					int bunho = rs.getInt("no");
					String age = rs.getString("age");
					String irum = rs.getString("irum");
					String part = rs.getString("part");
					out.print("<td>"+bunho+"</td><td>"+age+"</td><td>"+irum+"</td><td>"+part+"</td>");
					out.print("</tr>");
				}
				out.print("</table>");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    out.print("<a href='index.jsp'>¸ŞÀÎÀ¸·Î</a>");
			out.print("</body>");
			out.print("</html>");
		} else if (command.equals("/haksaList.do")) {
			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("utf-8");
			out.print("<!Doctype html>");
			out.print("<html>");
			out.print("<head>");
			out.print("<meta charset=utf-8>");
			out.print("<style>");
			out.print("#student{background-color:lightblue;}");
			out.print("#professor{background-color:lightyellow;}");
			out.print("#manager{background-color:lightgreen;}");
			out.print("#no{background-color:lightgray;}");
			out.print("</style>");
			out.print("</head>");
			out.print("<body>");
			haksaDAO.haksaSqlList();
			rs = haksaDAO.haksaExecute();
			out.print("<table style='border:1; cellspacing:0; cellpadding:0; width:900px; text-align:center;'>");
			try {
				while(rs.next()) {
					int bunho = rs.getInt("sno");
					String sage = rs.getString("sage");
					String sirum = rs.getString("sirum");
					String shakbun = rs.getString("shakbun");
					String page = rs.getString("page");
					String pirum = rs.getString("pirum");
					String psubject = rs.getString("psubject");
					String mage = rs.getString("mage");
					String mirum = rs.getString("mirum");
					String mpart = rs.getString("mpart");
					out.print("<tr>");
					out.print("<td id=no>No</td><td id=student>S³ªÀÌ</td><td id=student>SÀÌ¸§</td><td id=student>SÇĞ¹ø</td>"
							+ "<td id=professor>P³ªÀÌ</td><td id=professor>PÀÌ¸§</td><td id=professor>P°ú¸ñ</td>"
							+ "<td id=manager>M³ªÀÌ</td><td id=manager>MÀÌ¸§</td><td id=manager>MºÎ¼­</td>");
					out.print("</tr>");
					out.print("<tr>");
				    out.print("<td>"+bunho+"</td><td>"+sage+"</td><td>"+sirum+"</td><td>"+shakbun+"</td>"
				    		+ "<td>"+page+"</td><td>"+pirum+"</td><td>"+psubject+"</td>"
				    		+ "<td>"+mage+"</td><td>"+mirum+"</td><td>"+mpart+"</td>");
				    out.print("</tr>");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			out.print("</table>");
			out.print("<a href='index.jsp'>¸ŞÀÎÀ¸·Î</a>");
			out.print("</body>");
			out.print("</html>");
		} 
	}

}
