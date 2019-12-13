package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import projeto.readExcelFile;

public class TestReadExcelFile {

	@Test
	public void test_reader() {
		readExcelFile reader = new readExcelFile();
		ArrayList<String> listaLida = reader.getLista();
		assertEquals(new ArrayList<String>(), listaLida);
		reader.showExcel();
		assertNotEquals(new ArrayList<String>(), listaLida);

	}
}
