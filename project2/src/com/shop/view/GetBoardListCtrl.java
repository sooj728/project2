package com.shop.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.biz.BoardDAO;
import com.shop.model.BoardVO;

@WebServlet("/GetBoardListCtrl")
public class GetBoardListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		int sPage = 1;
		String page = request.getParameter("page");
		
		if(page != null) sPage = Integer.parseInt(page);
		
		String opt = request.getParameter("opt");
		String condition = request.getParameter("condition");
		
		HashMap<String, Object> listOpt = new HashMap<String, Object>();
		listOpt.put("opt", opt);
		listOpt.put("condition", condition);
		listOpt.put("start", sPage*10-9);
		
		BoardDAO dao = new BoardDAO();
		int listCount = dao.getBoardListCount(listOpt);
		ArrayList<BoardVO> boardList = dao.getBoardList(listOpt);
		
		int maxPage = (int) (listCount/10.0 + 0.9);
		int startPage = (int) (sPage/5.0 + 0.8) * 5 -4;
		int endPage = (sPage + 4);
		if(endPage > maxPage) endPage = maxPage;
		
		request.setAttribute("sPage", sPage);
		request.setAttribute("maxPage", maxPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		request.setAttribute("boardList", boardList);
		RequestDispatcher view = request.getRequestDispatcher("/board/getBoardList.jsp");
		view.forward(request, response);
	}

}
