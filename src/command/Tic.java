package command;

import controlleur.Controlleur;

public class Tic implements Command {
	Controlleur c ;
	
	/**
	 * Creation de la Commande Tic
	 * @param a Controlleur de moteur et la vue 
	 */
	public Tic (Controlleur a){
		c=a;
}
	public void execute() {
		// TODO Auto-generated method stub
		
		c.tic();
		
	}
}
