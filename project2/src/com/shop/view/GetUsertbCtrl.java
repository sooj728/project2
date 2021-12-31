package com.shop.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.biz.UsertbDAO;
import com.shop.model.UsertbVO;


@WebServlet("/GetUsertbCtrl")
public class GetUsertbCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int usertbid = Integer.parseInt(request.getParameter("usertbid"));
		
		UsertbVO vo = new UsertbVO();
		vo.setUsertbid(usertbid);
		
		UsertbDAO dao = new UsertbDAO();
		UsertbVO usertb = dao.getUsertb(vo);
		//UsertbDAO에서 getUsertb 메서드를 만든다.
		if(usertb != null) {
			request.setAttribute("usertb", usertb);
			RequestDispatcher view = request.getRequestDispatcher("/usertb/getUsertb.jsp");
			view.forward(request, response);
		} else {
			response.sendRedirect("GetUsertbListCtrl");
		}
	}

}
