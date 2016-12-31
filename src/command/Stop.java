package command;

import controlleur.Controlleur;

public class Stop  implements Command {
	Controlleur c ;
	/**
	 * Creation de la commande stop
	 * @param a Controlleur de moteur et la vue 
	 */
	public Stop (Controlleur a){
		c=a;
}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
		c.stop();
		
	}

}
