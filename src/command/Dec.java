package command;

import controlleur.Controlleur;

public class Dec implements Command {
	Controlleur c ;
	/**
	 *  Creation de la Command dec 
	 * @param a Controlleur de moteur et la vue 
	 */
	public Dec (Controlleur a){
		c=a;
}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		c.dec();
	}

}
