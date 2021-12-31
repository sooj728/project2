package com.shop.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.biz.UsertbDAO;
import com.shop.model.UsertbVO;

@WebServlet("/MyPageCtrl")
public class MyPageCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String u_id = request.getParameter("u_id");
		
		UsertbVO vo = new UsertbVO();
		vo.setU_id(u_id);
		
		UsertbDAO dao = new UsertbDAO();
		//받을객체 = DAO객체명.메서드명(vo)
		UsertbVO usertb = new UsertbVO();
		usertb = dao.myPage(vo);
		System.out.println("처리된 아이디 : "+usertb.getU_id());		
		if(usertb.getU_id() == null) {
			response.sendRedirect("login.jsp");
		} else {
			request.setAttribute("usertb", usertb);
			RequestDispatcher view = request.getRequestDispatcher("mypage.jsp");
			view.forward(request, response);
		}
	}

}
