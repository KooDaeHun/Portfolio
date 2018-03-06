package kr.co.daegu.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xml.internal.serialize.Printer;

@WebServlet("*.boa")
public class BoradFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardDAO boardDAO;
	private BoardDTO boardDTO;
	private ArrayList<BoardDTO> boardList;
	
	public BoradFrontController() {
		boardDAO = new BoardDAO();
		boardDTO = new BoardDTO();
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
		
//		게시판 전체출력
		if(command.equals("/boardList.boa")) {
			boardList=boardDAO.boardList(boardDTO);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp?page=board");
			request.setAttribute("boardList", boardList);
			dispatcher.include(request, response);
//		글쓰기
		} else if(command.equals("/boardWrite.boa")) { 
			String title=request.getParameter("title");
			String author=request.getParameter("author");
			String content=request.getParameter("content");
			String nal=request.getParameter("nal");
			String icon=request.getParameter("icon");
			
			boardDTO.setTitle(title);
			boardDTO.setContent(content);
			boardDTO.setAuthor(author);
			boardDTO.setIcon(icon);
			boardDTO.setNal(nal);
			boardDTO.setReadcount(0);
			
			boardDAO.boardWrite(boardDTO);
			boardList = boardDAO.boardList(boardDTO);
//			주소
			response.sendRedirect("list.boa");

//		검색
		} else if(command.equals("/boardSearch.boa")) {
			String title = request.getParameter("title");
			boardDTO.setTitle(title);
			boardList = boardDAO.boardSearch(boardDTO);
			RequestDispatcher dispatchaer = request.getRequestDispatcher("index.jsp?page=listPage");
			request.setAttribute("list", boardList);
			dispatchaer.include(request, response);
			
			
//		삭제
		} else if(command.equals("/boardDelete.boa")) {
			String no = request.getParameter("no");
			boardDTO.setNo(Integer.parseInt(no));
			boardDAO.boardDelete(boardDTO);
			response.sendRedirect("list.boa");
//		수정
		} else if(command.equals("/boardUpdate.boa")) {
			String no = request.getParameter("no");
			String title = request.getParameter("title");
			String author = request.getParameter("author");
			String content = request.getParameter("content");
			
			boardDTO.setNo(Integer.parseInt(no));
			boardDTO.setTitle(title);
			boardDTO.setAuthor(author);
			boardDTO.setContent(content);
			boardDAO.boardUpdate(boardDTO);
			response.sendRedirect("list.boa");
//			boardList.boa를 대체하는 목록(업그레이드 버전, 페이지 분할 기술)
		} else if (command.equals("/list.boa")) {// 목록

//			 ArrayList<BoardDTO> boardList = new ArrayList();
//			 boardList = boardDAO.boardList(boardDTO);
//			
//			 RequestDispatcher dis = request.getRequestDispatcher("/board/listPage.jsp");
//			 request.setAttribute("boardList", boardList);
//			 dis.forward(request, response);

			int curPage = 1;// 기본페이지
			if (request.getParameter("curPage") != null) {
				curPage = Integer.parseInt(request.getParameter("curPage"));
			}
			PageTo list = boardDAO.page(curPage);
			RequestDispatcher dis = request.getRequestDispatcher("index.jsp?page=listPage");
			request.setAttribute("page", list);
			// listPage.jsp에서 목록 리스트 데이터 저장
			request.setAttribute("list", list.getList());
			// page.jsp에서 페이징 처리 데이터 저장
			dis.forward(request, response);

		} // 목록
		else if(command.equals("/getlist.boa")) {
			String paraNo = request.getParameter("no");
			int no = Integer.parseInt(paraNo);
			boardDTO.setNo(no);
			boardList = boardDAO.boardContent(boardDTO);
			RequestDispatcher dis = request.getRequestDispatcher("index.jsp?page=boardContent2");
			request.setAttribute("getlist", boardList);
			dis.include(request, response);
		}

		
	}

}
