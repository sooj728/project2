package com.shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.biz.BuyDAO;
import com.shop.model.BuyVO;

@WebServlet("/AddBuyCtrl")
public class AddBuyCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		BuyVO vo = new BuyVO();
		vo.setBuyer(request.getParameter("u_id"));
		vo.setEmail(request.getParameter("email"));
		vo.setTel(request.getParameter("tel"));
		vo.setAdd1(request.getParameter("add1"));
		vo.setAdd2(request.getParameter("add2"));
		vo.setAdd3(request.getParameter("add3"));
		vo.setNote(request.getParameter("note"));
		vo.setBitem(request.getParameter("pname"));
		vo.setBitemid(Integer.parseInt(request.getParameter("prolistid")));
		vo.setCnt(Integer.parseInt(request.getParameter("cnt")));
		vo.setAmount(Integer.parseInt(request.getParameter("sum1")));
		vo.setCpuse(request.getParameter("cpuse"));
		vo.setPaytype(request.getParameter("paytype"));
		vo.setPayprop(request.getParameter("payprop"));
		BuyDAO dao = new BuyDAO();
		int cnt = dao.addBuy(vo);
		
		if(cnt > 0) {
			response.sendRedirect("GetProductListCtrl");
		} else {
			response.sendRedirect("GetProductCtrl?prolistid="+"prolistid");
		}
	}

}
