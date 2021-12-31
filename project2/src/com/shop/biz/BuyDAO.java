package com.shop.biz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.shop.model.DBConn;
import com.shop.model.BuyVO;

public class BuyDAO {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	//전체 회원 결제 내역 조회 (관리자)
	public ArrayList<BuyVO> adminGetBuyList() {
		ArrayList<BuyVO> buyList = null;
		try {
			conn=DBConn.getConnection();
			String sql = "select * from buy order by buyid";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			buyList = new ArrayList<BuyVO>();
			while(rs.next()) {
				int buyid = rs.getInt("buyid");
				String bcode = rs.getString("bcode");
				String buyer = rs.getString("buyer");
				String email = rs.getString("email");
				String tel = rs.getString("tel");
				String add1 = rs.getString("add1");
				String add2 = rs.getString("add2");
				String add3 = rs.getString("add3");
				String note = rs.getString("note");
				String bitem = rs.getString("bitem");
				int bitemid = rs.getInt("bitemid");
				int cnt = rs.getInt("cnt");
				int amount = rs.getInt("amount");
				String cpuse = rs.getString("cpuse");
				String paytype = rs.getString("paytype");
				String payprop = rs.getString("payprop");
				
				BuyVO buy = new BuyVO();
				buy.setBuyid(buyid);
				buy.setBcode(bcode);
				buy.setBuyer(buyer);
				buy.setEmail(email);
				buy.setTel(tel);
				buy.setAdd1(add1);
				buy.setAdd2(add2);
				buy.setAdd3(add3);
				buy.setNote(note);
				buy.setBitem(bitem);
				buy.setBitemid(bitemid);
				buy.setCnt(cnt);
				buy.setAmount(amount);
				buy.setCpuse(cpuse);
				buy.setPaytype(paytype);
				buy.setPayprop(payprop);
				
				buyList.add(buy);
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
		return buyList;	
	}
	
	//회원용 결제 내역 조회
	public BuyVO getBuy(BuyVO vo) {
		BuyVO buy= null;
		try {
			conn = DBConn.getConnection();
			String sql = "select * from buy where buyid=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, vo.getBuyid());
			rs = stmt.executeQuery();
			if (rs.next()) {
				buy = new BuyVO();
				buy.setBuyid(rs.getInt("buyid"));
				buy.setBcode(rs.getString("bcode"));
				buy.setBuyer(rs.getString("buyer"));
				buy.setEmail(rs.getString("email"));
				buy.setTel(rs.getString("tel"));
				buy.setAdd1(rs.getString("add1"));
				buy.setAdd2(rs.getString("add2"));
				buy.setAdd3(rs.getString("add3"));
				buy.setBitem(rs.getString("bitem"));
				buy.setBitemid(rs.getInt("bitem"));
				buy.setCnt(rs.getInt("cnt"));
				buy.setAmount(rs.getInt("amount"));
				buy.setCpuse(rs.getString("cpuse"));
				buy.setPaytype(rs.getString("paytype"));
				buy.setPayprop(rs.getString("payprop"));
				
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
		return buy;
	}
	
	//결제 기록 삭제
	public int deleteBuy(BuyVO vo) {
		int r = 0;
		try {
			conn = DBConn.getConnection();
			String sql = "delete from buy where buyid=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, vo.getBuyid());
			r= stmt.executeUpdate();
		
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
	
	//결제 추가
	public int addBuy(BuyVO vo) {
		int cnt = 0;
		
		try {
			conn = DBConn.getConnection();
			String sql = "insert into buy values(buy_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, vo.getBuyid());
			stmt.setString(2,vo.getBcode());
			stmt.setString(3, vo.getBuyer());
			stmt.setString(4, vo.getEmail());
			stmt.setString(5, vo.getTel());
			stmt.setString(6, vo.getAdd1());
			stmt.setString(7, vo.getAdd2());
			stmt.setString(8, vo.getAdd3());
			stmt.setString(9, vo.getNote());
			stmt.setString(10, vo.getBitem());
			stmt.setInt(11, vo.getBitemid());
			stmt.setInt(12, vo.getAmount());
			stmt.setString(13, vo.getCpuse());
			stmt.setString(14, vo.getPaytype());
			stmt.setString(15, vo.getPayprop());
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
	//회원별 결제 목록
	public ArrayList<BuyVO> getBuyList(BuyVO vo) {
		ArrayList<BuyVO> buyList = null;
		try {
			conn=DBConn.getConnection();
			String sql = "select * from buy order by buyid where buyer=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, vo.getBuyer());
			rs = stmt.executeQuery();
			buyList = new ArrayList<BuyVO>();
			while(rs.next()) {
				int buyid = rs.getInt("buyid");
				String bcode = rs.getString("bcode");
				String buyer = rs.getString("buyer");
				String email = rs.getString("email");
				String tel = rs.getString("tel");
				String add1 = rs.getString("add1");
				String add2 = rs.getString("add2");
				String add3 = rs.getString("add3");
				String note = rs.getString("note");
				String bitem = rs.getString("bitem");
				int cnt = rs.getInt("cnt");
				int amount = rs.getInt("amount");
				String cpuse = rs.getString("cpuse");
				String paytype = rs.getString("paytype");
				String payprop = rs.getString("payprop");
				
				BuyVO buy = new BuyVO();
				buy.setBuyid(buyid);
				buy.setBcode(bcode);
				buy.setBuyer(buyer);
				buy.setEmail(email);
				buy.setTel(tel);
				buy.setAdd1(add1);
				buy.setAdd2(add2);
				buy.setAdd3(add3);
				buy.setNote(note);
				buy.setBitem(bitem);
				buy.setCnt(cnt);
				buy.setAmount(amount);
				buy.setCpuse(cpuse);
				buy.setPaytype(paytype);
				buy.setPayprop(payprop);
				
				buyList.add(buy);
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
		return buyList;	
	}
}
