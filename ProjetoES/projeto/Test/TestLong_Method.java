package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import projeto.Long_Method;

public class TestLong_Method {

	@Test
	public void test_longMethod() {
		Long_Method lm = new Long_Method(4,5);
		boolean a = lm.detetarDefeitos(5, 6, "AND");
		boolean b = lm.detetarDefeitos(3, 4, "AND");
		boolean f = lm.detetarDefeitos(3, 6, "AND");
		boolean g = lm.detetarDefeitos(5, 4, "AND");


		boolean c = lm.detetarDefeitos(5, 6, "OR");
		boolean d = lm.detetarDefeitos(3, 4, "OR");
		boolean e = lm.detetarDefeitos(3, 7, "OR");
		boolean h = lm.detetarDefeitos(5, 4, "OR");

		
		assertEquals(true, a );
		assertEquals(false, b);
		assertEquals(false, f);
		assertEquals(true, c );
		assertEquals(false, d);
		assertEquals(true, e);
		assertEquals(true, h);

		
	}

}
