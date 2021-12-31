package com.shop.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.biz.QnaDAO;
import com.shop.model.QnaVO;


@WebServlet("/GetQnaCtrl")
public class GetQnaCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int qnaid = Integer.parseInt(request.getParameter("qnaid"));
		
		QnaVO vo = new QnaVO();
		vo.setQnaid(qnaid);
		
		QnaDAO dao = new QnaDAO();
		QnaVO qna = dao.getQna(vo);
		
		if(qna != null) {
			request.setAttribute("qna", qna);
			RequestDispatcher view = request.getRequestDispatcher("/qna/getQna.jsp");
			view.forward(request, response);
		} else {
			response.sendRedirect("GetQnaListCtrl");
		}
	}

}
