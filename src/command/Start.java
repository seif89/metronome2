package command;

import controlleur.Controlleur;

public class Start implements Command  {
	Controlleur c ;
	/**
	 * Creation de la commande start
	 * @param a Controlleur de moteur et la vue 
	 */
	public Start (Controlleur a){
		c=a;
}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		c.start();
	}
	

}
