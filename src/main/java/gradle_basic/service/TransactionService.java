package gradle_basic.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import gradle_basic.util.JdbcUtil;
import gradle_basic_dto.Department;
import gradle_basic_dto.Title;

public class TransactionService {
	public String transAddTitleAndDepartment(Title title, Department dept) {
		String titleSql = "insert into title values( ?, ?)";
		String deptSql = "insert into department values(?, ?, ?)";
		Connection con = null;
		PreparedStatement tPstmt = null;
		PreparedStatement dPstmt = null;
		String res = null;
		
		try {
			con = JdbcUtil.getConnection();
			con.setAutoCommit(false); // 오토커밋 자동으로 안하게 하기

			tPstmt = con.prepareStatement(titleSql);
			tPstmt.setInt(1, title.gettNo()); // 첫번째 물음표
			tPstmt.setString(2, title.gettName()); // 두번째 물음표
			tPstmt.executeUpdate(); // 실행

			dPstmt = con.prepareStatement(deptSql);
			dPstmt.setInt(1, dept.getDeptNo()); // 첫번째 물음표
			dPstmt.setString(2, dept.getDeptName()); // 두번째 물음표
			dPstmt.setInt(3, dept.getFloor()); // 세번째 물음표
			dPstmt.executeUpdate(); // 실행

			con.commit(); // 커밋
			res = "commit";

		} catch (SQLException e) { // 예외 발생하면
			rollbackUtil(con);
			res = "rollback";
		} finally {
			System.out.println(res);
			closeUtil(con, tPstmt, dPstmt);
		}
		return res;
	}

	public int transRemoveTitleAndDepartment(Title title, Department dept) {
		String titleSql = "delete from title where tno = ?";
		String deptSql = "delete from department where deptno = ?";

		Connection con = null;
		PreparedStatement tPstmt = null;
		PreparedStatement dPstmt = null;
		int res = 0;
		
		try {
			con = JdbcUtil.getConnection();
			con.setAutoCommit(false); // 오토커밋 자동으로 안하게 하기
			System.out.println("res"+res);
			
			tPstmt = con.prepareStatement(titleSql);
			tPstmt.setInt(1, title.gettNo()); // 첫번째 물음표
			res += tPstmt.executeUpdate(); // 실행
			System.out.println("res"+res);

			dPstmt = con.prepareStatement(deptSql);
			dPstmt.setInt(1, dept.getDeptNo()); // 첫번째 물음표

			res += dPstmt.executeUpdate(); // 실행
			System.out.println("res"+res);
			
			if(res == 2) {
				con.commit(); // 커밋
				System.out.println("commit()");
			}else {
				throw new SQLException();
			}
		} catch (SQLException e) { // 예외 발생하면
			rollbackUtil(con);
		} finally {
//			System.out.println(res);
			closeUtil(con, tPstmt, dPstmt);
		}
		return res;

	}

	public void closeUtil(Connection con, PreparedStatement tPstmt, PreparedStatement dPstmt) {
		try {
			con.setAutoCommit(true);
			if (tPstmt != null)
				tPstmt.close();
			if (dPstmt != null)
				dPstmt.close();
			if (con != null)
				con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void rollbackUtil(Connection con) {
		try {
			System.out.println("rollback()호출 ");
			con.rollback(); // 롤백
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

}
