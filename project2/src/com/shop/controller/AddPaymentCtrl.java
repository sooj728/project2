package com.shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.biz.BuyDAO;
import com.shop.model.BuyVO;

@WebServlet("/AddPaymentCtrl")
public class AddPaymentCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		BuyVO vo = new BuyVO();
		vo.setBuyer(request.getParameter("u_id"));
		vo.setCnt(Integer.parseInt(request.getParameter("cnt")));
		vo.setBitem(request.getParameter("pname"));
		vo.setAmount(Integer.parseInt(request.getParameter("sum1")));
		BuyDAO dao = new BuyDAO();
		int cnt = dao.addBuy(vo);
		
		if(cnt > 0) {
			response.sendRedirect("GetProductListCtrl");
		} else {
			response.sendRedirect("GetProductCtrl?prolistid="+"prolistid");
		}
	}

}
