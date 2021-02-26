package gradle_basic_dao_Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gradle_basic.util.JdbcUtil;
import gradle_basic_dao.DepartmentDao;
import gradle_basic_dto.Department;

//-------------------------------------------------------------------------
public class DepartmentDaoImpl implements DepartmentDao {
	private static final DepartmentDaoImpl instance = new DepartmentDaoImpl();

	public static DepartmentDaoImpl getInstance() {
		return instance;
	}

	private DepartmentDaoImpl() {

	}

//-------------------------------------------------------------------------
	@Override
	public List<Department> selectDepartmentByAll() { // 모든것을 검색할때 쓰는 메서드
		String sql = "select deptno,deptname,floor from department"; // statement sql작성
		try (Connection con = JdbcUtil.getConnection(); // close를 자동으로 호출해주는 방법
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<Department> list = new ArrayList<>();
				do {
					list.add(getDepartment(rs));

				} while (rs.next());
				return list;
			}
		} catch (Exception e) {

			// TODO: handle exception
		}
		return null;

	}

	private Department getDepartment(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		int deptNo = rs.getInt("deptno");
		String deptName = rs.getString("deptname");
		int floor = rs.getInt("floor");
		return new Department(deptNo, deptName, floor);
	}

//-------------------------------------------------------------------------
	@Override
	public Department selectDepartmentByNo(Department department) {
		String sql = "select deptno,deptname,floor from department where deptno=?";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, department.getDeptNo());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return getDepartment(rs);
				}
			} catch (SQLException e) {
				// TODO: handle exception
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}

		return null;

	}

//-------------------------------------------------------------------------
	@Override
	public int insertDepartment(Department department) {
		String sql = "insert into department values(?, ?, ?)";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, department.getDeptNo());
			pstmt.setString(2, department.getDeptName());
			pstmt.setInt(3, department.getFloor());
			return pstmt.executeUpdate();
		} catch (Exception e) {
		}
		return 0;
	}

//-------------------------------------------------------------------------

	@Override
	public int deleteDepartment(int DepartmentNo) {
		String sql = "delete from department where deptno = ?";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, DepartmentNo);
			return pstmt.executeUpdate();
		} catch (Exception e) {
		}
		return 0;
	}
//-------------------------------------------------------------------------

	@Override
	public int updateDepartment(Department department) {
		String sql = "update department set deptname = ? , floor = ? where deptno = ?";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, department.getDeptName());
			pstmt.setInt(2, department.getFloor());
			pstmt.setInt(3, department.getDeptNo());
			return pstmt.executeUpdate();
		} catch (Exception e) {
		}
		return 0;
	}

//-------------------------------------------------------------------------
	
//-------------------------------------------------------------------------
}
