package command;

import controlleur.Controlleur;

public class Inc implements Command {
	Controlleur c ;
	/**
	 * Creation de la Command Inc
	 * @param a Controlleur de moteur et la vue 
	 */
	public Inc (Controlleur a){
		c=a;
    }
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		c.inc();
	}

}
