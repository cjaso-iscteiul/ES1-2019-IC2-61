package projeto;

public class Future_Envy {

	private int aftd;
	private int laa;
	
	public Future_Envy(int aftd, int laa) {
		this.aftd = aftd;
		this.laa = laa;
	}
	
	public boolean detetarDefeitos(int aftdTable, int laaTable, String operadorLogico) {
		if(operadorLogico.equals("AND")) {
				if(aftdTable > this.aftd && laaTable < this.laa) {
					return true;
				}
				else {
					return false;
				}
		}
		else {
				if(aftdTable > this.aftd || laaTable < this.laa) {
					return true;
				}
				else 
					return false;
		}
	}
	
	
	
	
	
}
