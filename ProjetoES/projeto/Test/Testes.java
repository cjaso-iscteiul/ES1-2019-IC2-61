package Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;

import org.junit.Test;

import projeto.Feature_Envy;
import projeto.IG;
import projeto.Long_Method;
import projeto.readExcelFile;

public class Testes {
	

//	@Test
//	public void criacaoLongMethod () {
//		Long_Method lm1 = new Long_Method(3,5);
//		assertEquals(lm1, new Long_Method(3,5)  );
//	} Não sei se faz sentido fazer isto, nem se está bem feito
	
	
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
			assertEquals(true, c );
			assertEquals(false, d);
			assertEquals(true, e);
			assertEquals(true, h);



	}
		@Test
		public void test_reader() {
			readExcelFile reader = new readExcelFile();
			ArrayList<String> listaLida = reader.getLista();
			assertEquals(new ArrayList<String>(), listaLida);
			reader.showExcel();
			assertNotEquals(new ArrayList<String>(), listaLida);

			
		}
		
		
//		public void testIG() {
		
		
// //Não sei como se faz isto
//
		
//		}
}