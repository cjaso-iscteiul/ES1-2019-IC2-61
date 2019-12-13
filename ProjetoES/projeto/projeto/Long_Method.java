package projeto;

public class Long_Method {
	
	private int loc;
	private int cyclo;
	
	public Long_Method(int loc, int cyclo) {
		this.loc = loc;
		this.cyclo = cyclo;
	}
	
	/**
	 * Deteta se existe defeito is_long_method de acordo com os valores dados nos parametros
	 * @param locTable
	 * @param cycloTable
	 * @param operadorLogico
	 * @return
	 */
	public boolean detetarDefeitos(double locTable, double cycloTable, String operadorLogico) {
		if(operadorLogico.equals("AND")) {
				if(locTable > this.loc && cycloTable > this.cyclo) {
					return true;
				}
				else {
					return false;
				}
		}
		else {
				if(locTable > this.loc || cycloTable > this.cyclo) {
					return true;
				}
				else 
					return false;
		}
	}
	
}
