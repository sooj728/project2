package com.shop.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.biz.ProlistDAO;
import com.shop.model.ProlistVO;


@WebServlet("/GetProlistCtrl")
public class GetProlistCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int prolistid = Integer.parseInt(request.getParameter("prolistid"));
		
		ProlistVO vo = new ProlistVO();
		vo.setProlistid(prolistid);
		
		ProlistDAO dao = new ProlistDAO();
		ProlistVO prolist = dao.getProlist(vo);
		
		if(prolist != null) {
			request.setAttribute("prolist", prolist);
			RequestDispatcher view = request.getRequestDispatcher("/prolist/getProlist.jsp");
			view.forward(request, response);
		} else {
			response.sendRedirect("GetProlistListCtrl");
		}
	}

}
