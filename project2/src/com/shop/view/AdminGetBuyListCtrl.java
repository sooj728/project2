package com.shop.view;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.biz.BuyDAO;
import com.shop.model.BuyVO;

@WebServlet("/GetAdminGetBuyListCtrl")
public class AdminGetBuyListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		BuyDAO dao = new BuyDAO();
		ArrayList<BuyVO> adminGetBuyList = dao.adminGetBuyList();
		
		request.setAttribute("adminGetBuyList", adminGetBuyList);
		RequestDispatcher view = request.getRequestDispatcher("/buy/adminGetBuyList.jsp");
		view.forward(request, response);
	}

}
