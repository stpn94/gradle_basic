package gradle_basic.util;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JdbcUtilTest {

	@BeforeClass //1
	public static void setUpBeforeClass() throws Exception {
		System.out.printf("%s()%n","setUpBeforeClass");
		System.out.println();
	}

	@AfterClass //5
	public static void tearDownAfterClass() throws Exception {
		System.out.printf("%s()%n","tearDownAfterClass");
		System.out.println();
	}

	@Before //2
	public void setUp() throws Exception {
		System.out.printf("%s()%n","setUp");
		System.out.println();
	}

	@After //4
	public void tearDown() throws Exception {
		System.out.printf("%s()%n","tearDown");
		System.out.println();
	}

	@Test //3
	public void testGetConnection() {
		System.out.printf("%s()%n","testGetConnection");
		Connection con = JdbcUtil.getConnection();
		System.out.println("con >"+con);
		Assert.assertNotNull(con);
		System.out.println();
	}

}
