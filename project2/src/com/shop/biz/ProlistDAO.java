package com.shop.biz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.shop.model.DBConn;
import com.shop.model.ProlistVO;


//배치(batch) 프로그래밍: 한 곳에서 일을 한꺼번에 처리하기 위한 프로그래밍
//Prolist 테이블에 접근하여 데이터 처리 요청되어 온 일들을 모두 한 곳에서 처리하기 위한 모듈

public class ProlistDAO {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	//사용자 리스트를 데이터베이스에 접근하여 가져와서 VO에 담은 후 Controller에 리턴해 주는 역할의 메서드
	
	//상품목록 조회
	public ArrayList<ProlistVO> getProlistList() {
		ArrayList<ProlistVO> ProlistList = null;
		try {
			conn = DBConn.getConnection();
			String sql = "select prolistid, pcode, pname, nat, genre, price, img, cnt from Prolist order by prolistid";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			ProlistList = new ArrayList<ProlistVO>();
			while(rs.next()) {
				
				//데이터베이스 테이블에서 반환된 결과세트를 각 컬럼별로 지역변수에 담기
				int prolistid = rs.getInt("Prolistid");
				String pcode = rs.getString("pcode");
				String pname = rs.getString("pname");
				String nat = rs.getString("nat");
				String genre = rs.getString("genre");
				int price = rs.getInt("price");
				String img = rs.getString("img");
				int cnt = rs.getInt("cnt");
				
				//각 지역변수에 담긴 필드값을 VO에 담기
				ProlistVO prolist = new ProlistVO();
				prolist.setProlistid(prolistid);
				prolist.setPcode(pcode);
				prolist.setPname(pname);
				prolist.setNat(nat);
				prolist.setGenre(genre);
				prolist.setPrice(price);
				prolist.setImg(img);
				prolist.setCnt(cnt);
				
				//VO에 담긴 데이터를 LIST에 답기
				ProlistList.add(prolist);
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
		//VO의 값을 LIST에 담은 결과를 반환
		return ProlistList;
	}
	
	//아동 도서 불러오기
	public ArrayList<ProlistVO> getChildProlistList() {
		ArrayList<ProlistVO> ProlistList = null;
		try {
			conn = DBConn.getConnection();
			String sql = "select prolistid, pcode, pname, nat, genre, price, img, cnt from Prolist where genre='아동' order by prolistid";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			ProlistList = new ArrayList<ProlistVO>();
			while(rs.next()) {
				
				//데이터베이스 테이블에서 반환된 결과세트를 각 컬럼별로 지역변수에 담기
				int prolistid = rs.getInt("Prolistid");
				String pcode = rs.getString("pcode");
				String pname = rs.getString("pname");
				String nat = rs.getString("nat");
				String genre = rs.getString("genre");
				int price = rs.getInt("price");
				String img = rs.getString("img");
				int cnt = rs.getInt("cnt");
				
				//각 지역변수에 담긴 필드값을 VO에 담기
				ProlistVO prolist = new ProlistVO();
				prolist.setProlistid(prolistid);
				prolist.setPcode(pcode);
				prolist.setPname(pname);
				prolist.setNat(nat);
				prolist.setGenre(genre);
				prolist.setPrice(price);
				prolist.setImg(img);
				prolist.setCnt(cnt);
				
				//VO에 담긴 데이터를 LIST에 답기
				ProlistList.add(prolist);
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
		//VO의 값을 LIST에 담은 결과를 반환
		return ProlistList;
	}
	
	//소설 도서 불러오기
	public ArrayList<ProlistVO> getNovelProlistList() {
		ArrayList<ProlistVO> ProlistList = null;
		try {
			conn = DBConn.getConnection();
			String sql = "select prolistid, pcode, pname, nat, genre, price, img, cnt from Prolist where genre='소설' order by prolistid";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			ProlistList = new ArrayList<ProlistVO>();
			while(rs.next()) {
				
				//데이터베이스 테이블에서 반환된 결과세트를 각 컬럼별로 지역변수에 담기
				int prolistid = rs.getInt("Prolistid");
				String pcode = rs.getString("pcode");
				String pname = rs.getString("pname");
				String nat = rs.getString("nat");
				String genre = rs.getString("genre");
				int price = rs.getInt("price");
				String img = rs.getString("img");
				int cnt = rs.getInt("cnt");
				
				//각 지역변수에 담긴 필드값을 VO에 담기
				ProlistVO prolist = new ProlistVO();
				prolist.setProlistid(prolistid);
				prolist.setPcode(pcode);
				prolist.setPname(pname);
				prolist.setNat(nat);
				prolist.setGenre(genre);
				prolist.setPrice(price);
				prolist.setImg(img);
				prolist.setCnt(cnt);
				
				//VO에 담긴 데이터를 LIST에 답기
				ProlistList.add(prolist);
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
		//VO의 값을 LIST에 담은 결과를 반환
		return ProlistList;
	}
	
	//국내 도서 불러오기
	public ArrayList<ProlistVO> getKorProlistList() {
		ArrayList<ProlistVO> ProlistList = null;
		try {
			conn = DBConn.getConnection();
			String sql = "select prolistid, pcode, pname, nat, genre, price, img, cnt from Prolist where nat='국내' order by prolistid";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			ProlistList = new ArrayList<ProlistVO>();
			while(rs.next()) {
				
				//데이터베이스 테이블에서 반환된 결과세트를 각 컬럼별로 지역변수에 담기
				int prolistid = rs.getInt("Prolistid");
				String pcode = rs.getString("pcode");
				String pname = rs.getString("pname");
				String nat = rs.getString("nat");
				String genre = rs.getString("genre");
				int price = rs.getInt("price");
				String img = rs.getString("img");
				int cnt = rs.getInt("cnt");
				
				//각 지역변수에 담긴 필드값을 VO에 담기
				ProlistVO prolist = new ProlistVO();
				prolist.setProlistid(prolistid);
				prolist.setPcode(pcode);
				prolist.setPname(pname);
				prolist.setNat(nat);
				prolist.setGenre(genre);
				prolist.setPrice(price);
				prolist.setImg(img);
				prolist.setCnt(cnt);
				
				//VO에 담긴 데이터를 LIST에 답기
				ProlistList.add(prolist);
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
		//VO의 값을 LIST에 담은 결과를 반환
		return ProlistList;
	}	
		
	//해외 도서 불러오기
	public ArrayList<ProlistVO> getAbroadProlistList() {
		ArrayList<ProlistVO> ProlistList = null;
		try {
			conn = DBConn.getConnection();
			String sql = "select prolistid, pcode, pname, nat, genre, price, img, cnt from Prolist where nat='해외' order by prolistid";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			ProlistList = new ArrayList<ProlistVO>();
			while(rs.next()) {
				
				//데이터베이스 테이블에서 반환된 결과세트를 각 컬럼별로 지역변수에 담기
				int prolistid = rs.getInt("Prolistid");
				String pcode = rs.getString("pcode");
				String pname = rs.getString("pname");
				String nat = rs.getString("nat");
				String genre = rs.getString("genre");
				int price = rs.getInt("price");
				String img = rs.getString("img");
				int cnt = rs.getInt("cnt");
				
				//각 지역변수에 담긴 필드값을 VO에 담기
				ProlistVO prolist = new ProlistVO();
				prolist.setProlistid(prolistid);
				prolist.setPcode(pcode);
				prolist.setPname(pname);
				prolist.setNat(nat);
				prolist.setGenre(genre);
				prolist.setPrice(price);
				prolist.setImg(img);
				prolist.setCnt(cnt);
				
				//VO에 담긴 데이터를 LIST에 답기
				ProlistList.add(prolist);
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
		//VO의 값을 LIST에 담은 결과를 반환
		return ProlistList;	
	}
	
	//
	public ProlistVO getProlist(ProlistVO vo) {
		ProlistVO Prolist= null;
		try {
			conn = DBConn.getConnection();
			String sql = "select * from Prolist where Prolistid=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, vo.getProlistid());
			rs = stmt.executeQuery();
			if (rs.next()) {
				Prolist = new ProlistVO();
				Prolist.setProlistid(rs.getInt("Prolistid"));
				Prolist.setPcode(rs.getString("pcode"));
				Prolist.setPname(rs.getString("pname"));
				Prolist.setNat(rs.getString("nat"));
				Prolist.setGenre(rs.getString("genre"));
				Prolist.setPrice(rs.getInt("price"));
				Prolist.setImg(rs.getString("img"));
				Prolist.setCnt(rs.getInt("cnt"));
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
		return Prolist;
	}
	
	//상품 수정
	public int updateProlist(ProlistVO vo) {
		int r=0;
		try {
			conn= DBConn.getConnection();
			String sql = "update Prolist set pcode=? pname=? nat=? genre=? price=? img=? cnt=? where Prolistid=?";
			stmt.getConnection().prepareStatement(sql);
			stmt.setString(1, vo.getPcode());
			stmt.setString(2, vo.getPname());
			stmt.setString(3, vo.getNat());
			stmt.setString(4, vo.getGenre());
			stmt.setInt(5, vo.getPrice());
			stmt.setString(6, vo.getImg());
			stmt.setInt(7, vo.getCnt());
			stmt.setInt(8, vo.getProlistid());
			r = stmt.executeUpdate();
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 연결 실패");
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("SQL구문 오류");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("기타 오류");
		} finally {
			DBConn.close(stmt, conn);
		}
		return r;
	}
	
	//상품 삭제
	public int deleteProlist(ProlistVO vo) {
		int r = 0;
		try {
			conn = DBConn.getConnection();
			String sql = "delete from Prolist where Prolistid=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, vo.getProlistid());
			r = stmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 연결 오류");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("기타 오류");
			e.printStackTrace();
		} finally {
			DBConn.close(stmt, conn);
		}
		return r;
	}
	
	//상품 추가
	public int addProlist(ProlistVO vo) {
		int r=0;
		try {
			conn = DBConn.getConnection();
			String sql = "insert into Prolist values(Prolist_seq.nextval, ?, ?, ?, ?, ?, ?, ? sysdate, 0)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, vo.getPcode());
			stmt.setString(2, vo.getPname());
			stmt.setString(3, vo.getNat());
			stmt.setString(4, vo.getGenre());
			stmt.setInt(5, vo.getPrice());
			stmt.setString(6, vo.getImg());
			stmt.setInt(7, vo.getCnt());
			r = stmt.executeUpdate();
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 연결 실패");
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("SQL구문 오류");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("기타 오류");
		} finally {
			DBConn.close(stmt, conn);
		}
		return r;
	}
}
