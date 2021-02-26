package gradle_basic_dao;

import java.util.List;

import gradle_basic_dto.Title;

/*
 * Data Access Object
 * C(insert)
 * R(select, select where)
 * U(update)
 * D(delete)
 */


public interface TitleDao {
	List<Title> selectTitleByAll();
	Title selectTitleByNo(Title title);
	
	int insertTilte(Title title); //객체
	int updateTitle(Title title); 
	int deleteTitle(int titleNo); //기본타입
	
}
