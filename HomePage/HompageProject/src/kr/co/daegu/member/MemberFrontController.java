package kr.co.daegu.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import javafx.scene.control.Alert;


@WebServlet("*.member")
public class MemberFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberDTO memberDTO;
	private MemberDAO memberDAO;
	private ArrayList<MemberDTO> memberList;
	public MemberFrontController() {
		memberDTO = new MemberDTO();
		memberDAO = new MemberDAO();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if(command.equals("/login.member")) {//회원가입
			String id=request.getParameter("id");
			String pw=request.getParameter("pw");
			String pwch=request.getParameter("pwch");
			String irum=request.getParameter("irum");
			String nickname=request.getParameter("nickName");
			String email=request.getParameter("email");
			String emailcheck=request.getParameter("emailcheck");
			String smscheck=request.getParameter("smscheck");
			memberDTO.setId(id);
			memberDTO.setPw(pw);
			memberDTO.setPwch(pwch);
			memberDTO.setIrum(irum);
			memberDTO.setNickname(nickname);
			memberDTO.setEmail(email);
			memberDTO.setEmailcheck(emailcheck);
			memberDTO.setSmscheck(smscheck);
			int cnt = memberDAO.memberInsert(memberDTO);
			if(cnt == 1) {
				out.print("회원가입이 등록되었습니다.<br>");
			} else {
				out.print("회원가입에 실패했습니다.<br>");
			}
			out.print("<a href='index.jsp'>메인으로</a>");
		}//회원가입
		else if(command.equals("/idcheck.member")) {//id중복여부
			String id=request.getParameter("id");
			memberDTO.setId(id);
			boolean idcheck=memberDAO.memberIdCheck(memberDTO);
			if(idcheck==true) {
				out.print("아이디가 이미 사용중입니다.");
			}else {
				out.print("아이디가 사용가능합니다.");
			}
			out.print("<input type='button' value='종료' onClick='self.close()'>");
		}//id중복여부
		else if(command.equals("/idsearch.member")) {//아이디찾기
			String irum = request.getParameter("irum");
			String email = request.getParameter("email");
			memberDTO.setIrum(irum);
			memberDTO.setEmail(email);
			String id=memberDAO.memberIdSearch(memberDTO);
			if(id==null) {
				out.print("이름이나 이메일이 잘못되었습니다.");
			}else {
				out.print("찾으시는 아이디는="+id);
			}
			out.print("<input type='button' value='종료' onclick='self.close()'>");
		}//아이디찾기
		else if(command.equals("/pwsearch.member")) {//비밀번호찾기
			String id = request.getParameter("id");
			String irum = request.getParameter("irum");
			String email = request.getParameter("email");
			memberDTO.setId(id);
			memberDTO.setIrum(irum);
			memberDTO.setEmail(email);
			String pw=memberDAO.memberPwSearch(memberDTO);
			if(pw==null) {
				out.print("아이디나이름이나이메일이 잘못되었습니다.");
			}else {
				out.print("찾으시는 비밀번호는="+pw);
			}
			out.print("<input type='button' value='종료' onclick='self.close()'>");
		}//비밀번호찾기
		else if(command.equals("/loginform.member")) {//로그인정보
			HttpSession session = request.getSession(); 
			String id=request.getParameter("id");
			String pw=request.getParameter("pw");
			memberDTO.setId(id);
			memberDTO.setPw(pw);
			boolean login=memberDAO.memberLogin(memberDTO);
			if(login==true) {
				session.setAttribute("id", id);
				response.sendRedirect("index.jsp");
			}else {
				response.sendRedirect("index.jsp?page=loginform");
			}
		}//로그인정보
		else if(command.equals("/logout.member")) {//로그아웃
			HttpSession session = request.getSession(false);
			session.removeAttribute("id");
			response.sendRedirect("index.jsp?page=logout");
		}//로그아웃
		else if(command.equals("/update.member")) {//멤버수정
			String id=request.getParameter("id");
			String pw=request.getParameter("pw");
			String pwch=request.getParameter("pwch");
			String irum=request.getParameter("irum");
			String nickname=request.getParameter("nickname");
			String email=request.getParameter("email");
			memberDTO.setId(id);
			memberDTO.setPw(pwch);
			memberDTO.setPwch(pwch);
			memberDTO.setIrum(irum);
			memberDTO.setNickname(nickname);
			memberDTO.setEmail(email);
			memberDAO.memberUpdate(memberDTO);
			out.print("회원정보가 수정되었습니다.");
			out.print("<a href='index.jsp'>메인으로</a>");
		}//멤버수정
		else if(command.equals("/leave.member")) {//회원탈퇴
			HttpSession session = request.getSession(false);
			String id=(String)session.getAttribute("id");
			memberDTO.setId(id);
			memberDAO.memberLeave(memberDTO);
			session.removeAttribute("id");
			out.print("회원탈퇴 안녕히가세요");
			out.print("<a href='index.jsp'>메인으로</a>");			
		}//회원탈퇴
		else if(command.equals("/updateconfirm.member")) {//멤버수정view
			HttpSession session = request.getSession(false);
			String id = (String) session.getAttribute("id");
			memberDTO.setId(id);
			memberDTO=memberDAO.memberUpdateView(memberDTO);
			RequestDispatcher dis = request.getRequestDispatcher("index.jsp?page=memberupdate");
			request.setAttribute("memberDTO", memberDTO);
			dis.forward(request, response);
		}//멤버수정view
		else if(command.equals("/list.member")) {//멤버리스트
			 memberList=memberDAO.memberList(memberDTO);
			 RequestDispatcher dis = request.getRequestDispatcher("index.jsp?page=memberlist");
			 request.setAttribute("memberList", memberList);
			 dis.forward(request, response);
		}//멤버리스트
	}

}
