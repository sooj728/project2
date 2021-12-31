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

@WebServlet("/GetOrderBasketListCtrl")
public class GetOrderBasketListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		int prolistid = Integer.parseInt(request.getParameter("prolistid"));
		int usertbid = Integer.parseInt(request.getParameter("usertbid"));
		
		OrderBasketVO vo = new OrderBasketVO();
		vo.setThrowerid(usertbid);
		
		OrderBasketDAO dao = new OrderBasketDAO();
		ArrayList<OrderBasketVO> getOrderBasketList = dao.getOrderBasketList(vo);
		
		if(getOrderBasketList !=null) {
			request.setAttribute("getOrderBasketList", getOrderBasketList);
			RequestDispatcher view = request.getRequestDispatcher("/orderbasket/adminGetOrderBasketList.jsp");
			view.forward(request, response);
		} else {
			response.sendRedirect("GetOrderBasketListCtrl?throwerid="+usertbid);
		}
	}

}
