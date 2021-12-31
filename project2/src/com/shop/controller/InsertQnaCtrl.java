package com.shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.biz.QnaDAO;
import com.shop.model.QnaVO;

@WebServlet("/InsertQnaCtrl")
public class InsertQnaCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String author = request.getParameter("author");
		String tit = request.getParameter("tit");
		String con = request.getParameter("con");
		int pw = Integer.parseInt(request.getParameter("pw"));
		
		QnaVO vo = new QnaVO();
		vo.setAuthor(author);
		vo.setTit(tit);
		vo.setCon(con);
		vo.setPw(pw);
		
		QnaDAO dao = new QnaDAO();
		int r = dao.insertQna(vo);
		
		if(r != 0) {
			response.sendRedirect("GetInformListCtrl");
		} else {
			response.sendRedirect("/inform/addInform.jsp");
		} 
	}

}
