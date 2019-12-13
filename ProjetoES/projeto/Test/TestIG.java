package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import projeto.IG;

public class TestIG {

	@Test
	public void test_pesquisa() {
		IG ig = new IG();
		ig.procurar();

		
	}
	@Test
	public void test_iniciar() {
		IG ig = new IG();
		ig.iniciar();
	}
	
}

