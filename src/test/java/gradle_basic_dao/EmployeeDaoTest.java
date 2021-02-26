package gradle_basic_dao;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import gradle_basic_dao_Impl.EmployeeDaoImpl;
import gradle_basic_dto.Department;
import gradle_basic_dto.Employee;
import gradle_basic_dto.Title;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeDaoTest {
	private static EmployeeDao dao = EmployeeDaoImpl.getInstance();

	@Test
	public void test04SelectEmployeeByAll() {
		System.out.printf("%s()%n", "testSelectEmployeeByAll");
		List<Employee> EmployeeList = dao.selectEmployeeByAll();
		Assert.assertNotNull(EmployeeList);

		EmployeeList.stream().forEach(System.out::println);
//		for(Employee d : EmployeeList) {
//			System.out.println(d);
//		}

	}

	@Test
	public void test05SelectEmployeeByNo() {
		System.out.printf("%s()%n", "testSelectEmployeeByNo");
		Employee employee = new Employee(2106);
		Employee searchEmployee = dao.selectEmployeeByNo(employee);
		Assert.assertNotNull(searchEmployee);
		System.out.println(searchEmployee);
	}

	@Test
	public void test01InsertEmployee() {
		System.out.printf("%s()%n", "testInsertEmployeeByNo");
		Employee employee = new Employee(1004, "이종윤", new Title(1), new Employee(1003), 4000000, new Department(2));
		int res = dao.insertEmployee(employee);
		Assert.assertEquals(1, res);
	}

	@Test
	public void test02UpdateEmployee() {
		System.out.printf("%s()%n", "testInsertEmployeeByNo");
		Employee employee = new Employee(1004, "이종순");
		int res = dao.updateEmployee(employee);
		Assert.assertEquals(1, res);
	}

	@Test
	public void test03DeleteEmployee() {
		System.out.printf("%s()%n", "testDeleteEmployeeByNo");
		int res = dao.deleteEmployee(1004);
		Assert.assertEquals(1, res);
	}
	
	@Test
	public void test06SelectEmployeeByDeptNo() {
		System.out.printf("%s()%n", "testInsertEmployeeByDeptNo");
		Department department = new Department(1);
		List<Employee> searchEmployeeByDeptNo = dao.selectEmployeeBydeptNo(department);
		Assert.assertNotNull(searchEmployeeByDeptNo);
		
		for(Employee d : searchEmployeeByDeptNo) {
			System.out.println(d);
		}
		
	}

}
