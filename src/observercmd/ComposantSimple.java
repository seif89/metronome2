package observercmd;

import java.util.HashMap;

public class ComposantSimple implements Composant {
	
	private HashMap<String, Commande> tableCmds;
	
	public ComposantSimple() {
		tableCmds = new HashMap<String, Commande>();
	}
	@Override
	public Commande getCommande(String cl�) {
		return tableCmds.get(cl�);
	}

	@Override
	public void setCommand(String cl�, Commande c) {
		tableCmds.put(cl�, c);
	}

}