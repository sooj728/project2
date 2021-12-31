package com.shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.biz.QnaDAO;
import com.shop.model.QnaVO;


@WebServlet("/UpdateQnaCtrl")
public class UpdateQnaCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		int qnaid = Integer.parseInt(request.getParameter("qnaid"));
		String tit = request.getParameter("tit");
		String con = request.getParameter("con");
		
		QnaVO vo = new QnaVO();
		vo.setQnaid(qnaid);
		vo.setTit(tit);
		vo.setCon(con);
		
		QnaDAO dao = new QnaDAO();
		int r = dao.updateQna(vo);
		if(r>0) {
			response.sendRedirect("getInformListCtrl");
		}
	}

}
