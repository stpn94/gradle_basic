package gradle_basic_dao;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import gradle_basic_dao_Impl.TitleDaoimpl;
import gradle_basic_dto.Title;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TitleDaoTest {
	private static TitleDao dao = TitleDaoimpl.getInstance();

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test04SelectTitleByAll() {
		System.out.printf("%s()%n", "testSelectTitleByAll");
		List<Title> titleList = dao.selectTitleByAll();
		Assert.assertNotNull(titleList);

		titleList.stream().forEach(System.out::println);
//		for(Title t : titleList) {
//			System.out.println(t);
//		}
	}

	@Test
	public void test05SelectTitleByNo() {
		Title title = new Title(3);
		Title searchtitle = dao.selectTitleByNo(title);
		Assert.assertNotNull(searchtitle);
		System.out.println(searchtitle);
	}

	@Test
	public void test01InsertTilte() {
		System.out.printf("%s()%n", "testSelectTitle");
		Title newTitle = new Title(6, "인턴");
		int res = dao.insertTilte(newTitle);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectTitleByNo(newTitle));
	}

	@Test
	public void test03DeletedateTitle() {
		System.out.printf("%s()%n", "testDeleteTitle");
		int res = dao.deleteTitle(6);
		Assert.assertEquals(1, res);
		dao.selectTitleByAll().stream().forEach(System.out::println);
	}

	@Test
	public void test02UpdateTitle() {
		System.out.printf("%s()%n", "testSelectTitle");
		Title newTitle = new Title(6, "계약직");
		int res = dao.updateTitle(newTitle);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectTitleByNo(newTitle));
	}

}
