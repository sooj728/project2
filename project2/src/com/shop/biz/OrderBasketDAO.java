package com.shop.biz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shop.model.DBConn;
import com.shop.model.OrderBasketVO;

public class OrderBasketDAO {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	//장바구니 조회 (관리자)
	public ArrayList<OrderBasketVO> adminGetOrderBasketList() {
		ArrayList<OrderBasketVO> orderbasketList = null;
		try {
			conn=DBConn.getConnection();
			String sql = "select * from orderbasket order by orderbasketid";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			orderbasketList = new ArrayList<OrderBasketVO>();
			while(rs.next()) {
				int orderbasketid = rs.getInt("orderbasketid");
				String ocode = rs.getString("ocode");
				int throwerid = rs.getInt("throwerid");
				String oitem = rs.getString("oitem");
				int oitemid = rs.getInt("oitemid");
				int cnt = rs.getInt("cnt");
				int validity = rs.getInt("validity");
				OrderBasketVO orderBasket = new OrderBasketVO();
				orderBasket.setOrderbasketid(orderbasketid);
				orderBasket.setOcode(ocode);
				orderBasket.setThrowerid(throwerid);
				orderBasket.setOitem(oitem);
				orderBasket.setOitemid(oitemid);
				orderBasket.setCnt(cnt);
				orderBasket.setValidity(validity);
				
				orderbasketList.add(orderBasket);
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("기타 오류");
			e.printStackTrace();
		} finally {
			DBConn.close(rs, stmt, conn);
		}
		return orderbasketList;	
	}
	
	//장바구니 조회
	public OrderBasketVO getOrderbasket(OrderBasketVO vo) {
		OrderBasketVO orderBasket= null;
		try {
			conn = DBConn.getConnection();
			String sql = "select * from orderbasket where orderbasketid=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, vo.getOrderbasketid());
			rs = stmt.executeQuery();
			if (rs.next()) {
				orderBasket = new OrderBasketVO();
				orderBasket.setOrderbasketid(rs.getInt("orderbasketid"));
				orderBasket.setOcode(rs.getString("ocode"));
				orderBasket.setThrowerid(rs.getInt("throwerid"));
				orderBasket.setOitem(rs.getString("Oitem"));
				orderBasket.setOitemid(rs.getInt("oitemid"));
				orderBasket.setCnt(rs.getInt("cnt"));
				orderBasket.setValidity(rs.getInt("validity"));
			}
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 오류");
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("SQL구문 오류");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("기타 오류");
			e.printStackTrace();
		} finally {
			DBConn.close(rs, stmt, conn);
		}
		return orderBasket;
	}
	
	//상품 삭제
	public int deleteOrderbasket(OrderBasketVO vo) {
		int r = 0;
		try {
			conn = DBConn.getConnection();
			String sql = "delete from orderbasket where orderbasketid=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, vo.getOrderbasketid());
			r = stmt.executeUpdate();
		
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 오류");
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("SQL구문 오류");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("기타 오류");
			e.printStackTrace();
		} finally {
			DBConn.close(stmt, conn);
		}
		
		return r;
	}
	
	//상품 추가
	public int addOrderBasket(OrderBasketVO vo) {
		int cnt = 0;
		try {
			conn = DBConn.getConnection();
			String sql = "insert into orderbasket values(orderbasket_seq.nextval, ?, ?, ?, ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, vo.getOcode());
			stmt.setInt(2, vo.getThrowerid());
			stmt.setString(3, vo.getOitem());
			stmt.setInt(4, vo.getOitemid());
			stmt.setInt(5, vo.getCnt());
			stmt.setInt(6, vo.getValidity());
			cnt = stmt.executeUpdate();
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 오류");
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("SQL구문 오류");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("기타 오류");
			e.printStackTrace();
		} finally {
			DBConn.close(stmt, conn);
		}
		
		return cnt;
	}
	
	//장바구니 조회
	public ArrayList<OrderBasketVO> getOrderBasketList(OrderBasketVO vo) {
		ArrayList<OrderBasketVO> orderbasketList = null;
		try {
			String sql = "select * from orderbasket order by orderbasketid where throwerid=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, vo.getThrowerid());
			rs = stmt.executeQuery();
			orderbasketList = new ArrayList<OrderBasketVO>();
			while(rs.next()) {
				int orderbasketid = rs.getInt("orderbasketid");
				String ocode = rs.getString("ocode");
				int throwerid = rs.getInt("throwerid");
				String oitem = rs.getString("oitem");
				int oitemid = rs.getInt("oitemid");
				int cnt = rs.getInt("cnt");
				int validity = rs.getInt("validity");
				
				OrderBasketVO orderBasket = new OrderBasketVO();
				
				orderBasket.setOrderbasketid(orderbasketid);
				orderBasket.setOcode(ocode);
				orderBasket.setThrowerid(throwerid);
				orderBasket.setOitem(oitem);
				orderBasket.setOitemid(oitemid);
				orderBasket.setCnt(cnt);
				orderBasket.setValidity(validity);
				
				orderbasketList.add(orderBasket);
			}
		
		} catch (Exception e) {
			System.out.println("기타 오류");
			e.printStackTrace();
		} finally {
			DBConn.close(rs, stmt, conn);
		}
		return orderbasketList;	
	}	
}
