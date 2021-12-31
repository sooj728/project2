package com.shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.biz.OrderBasketDAO;
import com.shop.model.OrderBasketVO;

@WebServlet("/InsertBasketCtrl")
public class InsertOrderBasketCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int prolistid = Integer.parseInt(request.getParameter("prolistid"));
		String usertbid = request.getParameter("usertbid");
		String pname = request.getParameter("pname");
		int cnt = Integer.parseInt(request.getParameter("cnt"));
		
		OrderBasketVO vo = new OrderBasketVO();
		vo.setOitem(pname);
		vo.setOitemid(prolistid);
		vo.setThrowerid(Integer.parseInt(usertbid));
		vo.setCnt(cnt);
		vo.setValidity(1);
		
		OrderBasketDAO dao = new OrderBasketDAO();
		int r = dao.insertOrderBasket(vo);
		
		if (r>0) {
			response.sendRedirect("getBasketListCtrl?throwerid="+usertbid+"&oitem="+prolistid);
		} else {
			response.sendRedirect("GetBasketListCtrl?throwerid="+usertbid);
		}
	}

}
