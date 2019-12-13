package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import projeto.Feature_Envy;

public class TestFeature_Envy {

	@Test
	public void test_Feature_Envy() {
		Feature_Envy fe = new Feature_Envy(4,5);
		boolean a = fe.detetarDefeitos(5, 4, "AND");
		boolean b = fe.detetarDefeitos(3, 6, "AND");
		boolean f = fe.detetarDefeitos(6, 5, "AND");
		boolean g = fe.detetarDefeitos(4, 5, "AND");


		boolean c = fe.detetarDefeitos(5, 4, "OR");
		boolean d = fe.detetarDefeitos(3, 6, "OR");
		boolean e = fe.detetarDefeitos(5, 7, "OR");
		boolean h = fe.detetarDefeitos(3, 3, "OR");

		
		assertEquals(true, a );
		assertEquals(false, b);
		assertEquals(false, f);
		assertEquals(false, g);
		assertEquals(true, c );
		assertEquals(false, d);
		assertEquals(true, e);
		assertEquals(true, h);



	}
}
