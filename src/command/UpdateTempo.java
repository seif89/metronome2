package command;

import controlleur.Controlleur;

public class UpdateTempo implements Command{
	Controlleur c ;
	/**
	 * Creation de la commande UpdateTempo
	 * @param a Controlleur de moteur et la vue 
	 */
	public UpdateTempo (Controlleur a){
		c=a;
}
	@Override
	public void execute() {

		c.updateTempo();
	}
}
