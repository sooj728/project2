package com.shop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.biz.OrderBasketDAO;
import com.shop.model.OrderBasketVO;

@WebServlet("/AddOrderBasketCtrl")
public class AddOrderBasketCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		int throwerid = Integer.parseInt(request.getParameter("throwerid"));
		String oitemid = request.getParameter("oitemid");
		
		OrderBasketVO vo = new OrderBasketVO();
		vo.setThrowerid(throwerid);
		vo.setOitemid(oitemid);
		vo.setCnt(1);
		vo.setValidity(1);
		
		OrderBasketDAO dao = new OrderBasketDAO();
		int cnt = dao.addOrderBasket(vo);
		
		if(cnt > 0) {
			response.sendRedirect("GetUserBasketListCtrl?u_id="+throwerid+"&prolistid="+oitemid);
		} else {
			response.sendRedirect("GetUserBasketListCtrl?u_id="+throwerid);
		} 
	}

}
