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


@WebServlet("/GetFindIdCtrl")
public class GetFindIdCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String email = request.getParameter("email");
		String uname = request.getParameter("uname");
		
		UsertbVO vo = new UsertbVO();
		vo.setEmail(email);
		vo.setUname(uname);
		
		UsertbDAO dao = new UsertbDAO();
		UsertbVO usertb = dao.getFindId(vo);
		
		if(usertb != null) {
			request.setAttribute("usertb", usertb);
			RequestDispatcher view = request.getRequestDispatcher("./find/getFindId.jsp");
			view.forward(request, response);
		} else {
			response.sendRedirect("./find/findId.jsp");
		}
	}

}

