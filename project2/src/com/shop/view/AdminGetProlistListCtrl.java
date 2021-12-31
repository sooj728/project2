package com.shop.view;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.biz.ProlistDAO;
import com.shop.model.ProlistVO;

@WebServlet("/AdminGetProlistListCtrl")
public class AdminGetProlistListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		ProlistDAO dao = new ProlistDAO();
		ArrayList<ProlistVO> prolistList = dao.getProlistList();
		
		request.setAttribute("prolistList", prolistList);
		RequestDispatcher view = request.getRequestDispatcher("/prolist/adminGetProlistList.jsp");
		view.forward(request, response);
	}

}
