package com.shop.view;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.biz.OrderBasketDAO;
import com.shop.model.OrderBasketVO;

@WebServlet("/AdminGetOrderBasketListCtrl")
public class AdminGetOrderBasketListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		OrderBasketDAO dao = new OrderBasketDAO();
		ArrayList<OrderBasketVO> adminGetOrderBasketList = dao.adminGetOrderBasketList();
		
		request.setAttribute("adminGetOrderBasketList", adminGetOrderBasketList);
		RequestDispatcher view = request.getRequestDispatcher("/orderbasket/adminGetOrderBasketList.jsp");
		view.forward(request, response);
	}

}
