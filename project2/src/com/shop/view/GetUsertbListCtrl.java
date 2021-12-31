package com.shop.view;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.biz.UsertbDAO;
import com.shop.model.UsertbVO;

@WebServlet("/GetusertbListCtrl")
public class GetUsertbListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		UsertbDAO dao = new UsertbDAO();
		ArrayList<UsertbVO> usertbList = dao.getUsertbList();
		
		request.setAttribute("usertbList", usertbList);
		RequestDispatcher view = request.getRequestDispatcher("/usertb/getUsertbList.jsp");
		view.forward(request, response);
	}

}
