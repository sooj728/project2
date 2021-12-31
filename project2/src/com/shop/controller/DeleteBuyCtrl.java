package com.shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.biz.BuyDAO;
import com.shop.model.BuyVO;


@WebServlet("/DeleteBuyCtrl")
public class DeleteBuyCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		int buyid = Integer.parseInt(request.getParameter("buyid"));
		int cnt =0;
		BuyVO vo = new BuyVO();
		vo.setBuyid(buyid);
		
		BuyDAO dao = new BuyDAO();
		cnt = dao.deleteBuy(vo);
		if(cnt>0) {
			response.sendRedirect("GetBuyListCtrl");
		}
	}

}
