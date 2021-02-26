package gradle_basic_dao_Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gradle_basic.util.JdbcUtil;
import gradle_basic_dao.TitleDao;
import gradle_basic_dto.Title;

public class TitleDaoimpl implements TitleDao {
	private static final TitleDaoimpl instance = new TitleDaoimpl();

	public static TitleDaoimpl getInstance() {
		return instance;
	}

	private TitleDaoimpl() {
	}

	@Override
	public List<Title> selectTitleByAll() {
		// select
		String sql = "select tno,tname from title";
		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<Title> list = new ArrayList<>();
				do {
					list.add(getTitle(rs));
				} while (rs.next());
				System.out.println(list.size());
				return list;
			}
		} catch (Exception e) {

		}
		return null;
	}

	private Title getTitle(ResultSet rs) throws SQLException {
		int tNo = rs.getInt("tno");
		String tName = rs.getString("tname");
		return new Title(tNo, tName);
	}

// -------------------------------------------------------------------------
	@Override
	public Title selectTitleByNo(Title title) {
		String sql = "select tno,tname from title where tno = ?";
		try (Connection con = JdbcUtil.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, title.gettNo());
//				System.out.println(pstmt);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return getTitle(rs);
				}
			} catch (SQLException e) {
				// TODO: handle exception
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public int insertTilte(Title title) {
		String sql = "insert into title values( ?, ?)";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, title.gettNo());
			pstmt.setString(2, title.gettName());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public int updateTitle(Title title) {
		String sql = "update title set tname = ? where tno = ?";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, title.gettName());
			pstmt.setInt(2, title.gettNo());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public int deleteTitle(int titleNo) {
		String sql = "delete from title where tno = ?";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, titleNo);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

}
