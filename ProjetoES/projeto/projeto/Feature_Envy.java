package projeto;

public class Feature_Envy {

	private int aftd;
	private double laa;
	
	public Feature_Envy(int aftd, double laa) {
		this.aftd = aftd;
		this.laa = laa;
	}
	
	public boolean detetarDefeitos(double aftdTable, double laaTable, String operadorLogico) {
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
