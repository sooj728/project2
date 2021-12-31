package com.shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.biz.OrderBasketDAO;
import com.shop.model.OrderBasketVO;


@WebServlet("/DeleteOrderBasketCtrl")
public class DeleteOrderBasketCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		int orderbasketid = Integer.parseInt(request.getParameter("orderbasketid"));
		int cnt =0;
		OrderBasketVO vo = new OrderBasketVO();
		vo.setOrderbasketid(orderbasketid);
		
		OrderBasketDAO dao = new OrderBasketDAO();
		cnt = dao.deleteOrderbasket(vo);
		if(cnt>0) {
			response.sendRedirect("GetOrderBasketListCtrl");
		}
	}

}
