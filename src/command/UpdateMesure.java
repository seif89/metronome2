package command;

import controlleur.Controlleur;

public class UpdateMesure implements Command {

	
	private Controlleur c;
	/**
	 * Creation de la commande UpdateMesure
	 * @param a Controlleur de moteur et la vue 
	 */
	public UpdateMesure(Controlleur a) {
		c=a;
	}

	@Override
	public void execute() {
		c.updateMesure();
	}
}
