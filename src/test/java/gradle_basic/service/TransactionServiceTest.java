package gradle_basic.service;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import gradle_basic_dto.Department;
import gradle_basic_dto.Title;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TransactionServiceTest {
	private static TransactionService service;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service = new TransactionService();
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
		service = null;
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("----------------");
	}

// -------------------------------------------------------------------------

	@Test
	public void test01TransAddTitleAndDepartment_FailTitle() {
		System.out.printf("%s()%n", "testTransAddTitleAndDepartment_FailTitle");
		Title title = new Title(1, "영업");
		Department dept = new Department(5, "비상계획부", 10);

		String res = service.transAddTitleAndDepartment(title, dept);
		Assert.assertEquals("rollback", res);
	}

	@Test
	public void test02TransAddTitleAndDepartment_FailDept() {
		System.out.printf("%s()%n", "testTransAddTitleAndDepartment_FailTitle");

		Title title = new Title(6, "인턴");
		Department dept = new Department(1, "비상계획부", 10);

		String res = service.transAddTitleAndDepartment(title, dept);
		Assert.assertEquals("rollback", res);
	}

	@Test
	public void test03TransAddTitleAndDepartment_FailBoth() {
		System.out.printf("%s()%n", "testTransAddTitleAndDepartment_FailTitle");

		Title title = new Title(1, "인턴");
		Department dept = new Department(1, "비상계획부", 10);

		String res = service.transAddTitleAndDepartment(title, dept);
		Assert.assertEquals("rollback", res);
	}

	@Test
	public void test04TransAddTitleAndDepartment_Success() {
		System.out.printf("%s()%n", "testTransAddTitleAndDepartment_FailTitle");

		Title title = new Title(6, "인턴");
		Department dept = new Department(5, "비상계획부", 10);

		String res = service.transAddTitleAndDepartment(title, dept);
		Assert.assertEquals("commit", res);
	}

// -------------------------------------------------------------------------

	@Test
	public void test05TransRemoveTitleAndDepartment_FailTitle() {
		System.out.printf("%s()%n", "testTransRemoveTitleAndDepartment_FailTitle");
		
		Title title = new Title(6);
		Department dept = new Department(0);
		
		int res = service.transRemoveTitleAndDepartment(title, dept);
		Assert.assertEquals(1, res);
		
	}

	@Test
	public void test06TransRemoveTitleAndDepartment_FailDept() {
		System.out.printf("%s()%n", "testTransRemoveTitleAndDepartment_FailDept");
		
		Title title = new Title(0);
		Department dept = new Department(15);
		
		int res = service.transRemoveTitleAndDepartment(title, dept);
		Assert.assertEquals(0, res);
	}

	@Test
	public void test07TransRemoveTitleAndDepartment_FailBoth() {
		System.out.printf("%s()%n", "testTransRemoveTitleAndDepartment_FailBoth");
		Title title = new Title(0);
		Department dept = new Department(0);
		
		int res = service.transRemoveTitleAndDepartment(title, dept);
		Assert.assertEquals(0, res);
		
	}

	@Test
	public void test08TransRemoveTitleAndDepartment_Success() {
		System.out.printf("%s()%n", "testTransRemoveTitleAndDepartment_Success");
		Title title = new Title(6);
		Department dept = new Department(5);
		
		int res = service.transRemoveTitleAndDepartment(title, dept);
		Assert.assertEquals(2, res);
	}

// -------------------------------------------------------------------------
}
