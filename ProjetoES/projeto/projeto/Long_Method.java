package projeto;

public class Long_Method {
	
	private int loc;
	private int cyclo;
	
	public Long_Method(int loc, int cyclo) {
		this.loc = loc;
		this.cyclo = cyclo;
	}
	
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
