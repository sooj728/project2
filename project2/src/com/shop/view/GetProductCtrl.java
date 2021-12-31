package com.shop.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.biz.ProlistDAO;
import com.shop.model.ProlistVO;


@WebServlet("/GetProductCtrl")
public class GetProductCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		int prolistid = Integer.parseInt(request.getParameter("prolistid"));
		
		ProlistVO vo = new ProlistVO();
		vo.setProlistid(prolistid);
		
		ProlistDAO dao = new ProlistDAO();
		ProlistVO pro = dao.getProlist(vo);
		
		ServletContext application = getServletConfig().getServletContext(); 
		if(pro != null) {
			application.setAttribute("pro", pro);
			request.setAttribute("pro", pro);
			//request.setAttribute("impressList", impressList);
			RequestDispatcher view = request.getRequestDispatcher("getProduct.jsp");
			view.forward(request, response);
		} else {
			response.sendRedirect("GetProductListCtrl");
		}
	}

}
