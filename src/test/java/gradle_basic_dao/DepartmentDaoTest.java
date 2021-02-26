package gradle_basic_dao;

import java.util.List;

import org.junit.After;  
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import gradle_basic_dao_Impl.DepartmentDaoImpl;
import gradle_basic_dto.Department;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class DepartmentDaoTest {
	private static DepartmentDao dao = DepartmentDaoImpl.getInstance();

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}
	
	@Test
	public void test04SelectDepartmentByAll() {
		System.out.printf("%s()%n", "testSelectDepartmentByAll");
		List<Department> DepartmentList = dao.selectDepartmentByAll();
		Assert.assertNotNull(DepartmentList);

		DepartmentList.stream().forEach(System.out::println);
//		for(Department d : DepartmentList) {
//			System.out.println(d);
//		}
		
	}
	
	@Test
	public void test05SelectDepartmentByNo() {
		Department department = new Department(3);
		Department searchDepartment = dao.selectDepartmentByNo(department);
		Assert.assertNotNull(searchDepartment);
		System.out.println(searchDepartment);
	}
	
	@Test
	public void test01InsertDepartment() {
		System.out.printf("%s()%n", "testInsertDepartment");
		Department newDepartment = new Department(6, "청소", 1);
		int res = dao.insertDepartment(newDepartment);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectDepartmentByNo(newDepartment));
	}

	@Test
	public void test03DeletedateDepartment() {
		System.out.printf("%s()%n", "testDeleteDepartment");
		int res = dao.deleteDepartment(6);
		Assert.assertEquals(1, res);
		dao.selectDepartmentByAll().stream().forEach(System.out::println);
	}

	@Test
	public void test02UpdateDepartment() {
		System.out.printf("%s()%n", "testUpdateDepartment");
		Department newDepartment = new Department(6, "계약직");
		int res = dao.updateDepartment(newDepartment);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectDepartmentByNo(newDepartment));
	}

	
	
}
