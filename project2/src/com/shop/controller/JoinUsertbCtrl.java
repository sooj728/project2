package com.shop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.biz.UsertbDAO;
import com.shop.model.UsertbVO;


@WebServlet("/JoinUsertbCtrl")
public class JoinUsertbCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String u_id = request.getParameter("u_id");
		String pw = request.getParameter("pw");
		String uname = request.getParameter("uname");
		String email = request.getParameter("email");
		String q = request.getParameter("q");
		String a = request.getParameter("a");
		String add1 = request.getParameter("add1");
		String add2 = request.getParameter("add2");
		
		UsertbVO vo = new UsertbVO();
		vo.setU_id(u_id);
		vo.setPw(pw);
		vo.setUname(uname);
		vo.setEmail(email);
		vo.setQ(q);
		vo.setA(a);
		vo.setAdd1(add1);
		vo.setAdd2(add2);
		
		UsertbDAO dao = new UsertbDAO();
		UsertbVO usertb = new UsertbVO();
		//받을객체 = DAO객체명.메서드명(vo)
		int cnt = dao.insertUsertb(vo);
		HttpSession session = request.getSession();
		
		if(cnt>0) {
			response.sendRedirect("login.jsp");
		}  else {
			response.sendRedirect("join.jsp");
		}
	}
	
}
