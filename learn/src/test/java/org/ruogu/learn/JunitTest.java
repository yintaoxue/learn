package org.ruogu.learn;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * JunitTest
 * 
 * @author xueyintao 2016年2月22日 下午9:41:46
 */
public class JunitTest {

	public JunitTest() {
		System.out.println("构造方法JunitTest()");
	}

	/**
	 * 在所有方法之前执行
	 * 
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("在所有方法之前执行，初始化");
	}

	/**
	 * 在所有方法之后执行，释放资源
	 * 
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("在所有方法之后执行，释放资源");
	}

	/**
	 * 在每个方法之前执行
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("在每个方法之前执行");
	}

	/**
	 * 在每个方法之后执行
	 * 
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		System.out.println("在每个方法之后执行");
	}

	@Test
	public void test() {
		Integer a = 3, b = 2, c = 3;

		assertEquals(a, c);

		assertEquals(1, 1);

		// assertEquals(2, b); error

		System.out.println("test.test()");

		// fail("Not yet implemented"); 执行到该行代码则报错
	}

	@Test(timeout = 100)
	public void testSite() {
		assertEquals("a", "a");
		System.out.println("test.testSite()");
	}

	@Test(expected = Exception.class, timeout = 100)
	public void testExp() throws Exception {
		throw new Exception("exp");
	}

}
