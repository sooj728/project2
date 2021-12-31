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

@WebServlet("/GetFindPwCtrl")
public class GetFindPwCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		int usertbid = Integer.parseInt(request.getParameter("usertbid"));
		String q = request.getParameter("q");
		String a = request.getParameter("a");
		
		UsertbVO vo = new UsertbVO();
		vo.setUsertbid(usertbid);
		vo.setA(a);
		vo.setQ(q);
		
		UsertbDAO dao = new UsertbDAO();
		UsertbVO usertb = dao.getFindPw(vo);
		
		if(usertb != null) {
			request.setAttribute("usertb", usertb);
			RequestDispatcher view = request.getRequestDispatcher("./find/getFindPw.jsp");
			view.forward(request, response);
		} else {
			response.sendRedirect("./find/getFindQ.jsp");
		}
	}

}
