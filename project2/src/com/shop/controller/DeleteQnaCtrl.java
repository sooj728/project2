package com.shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.biz.QnaDAO;
import com.shop.model.QnaVO;


@WebServlet("/DeleteQnaCtrl")
public class DeleteQnaCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		int qnaid = Integer.parseInt(request.getParameter("qnaid"));
		int cnt =0;
		QnaVO vo = new QnaVO();
		vo.setQnaid(qnaid);
		
		QnaDAO dao = new QnaDAO();
		cnt = dao.deleteQna(vo);
		if(cnt>0) {
			response.sendRedirect("GetQnaListCtrl");
		}
	}

}
