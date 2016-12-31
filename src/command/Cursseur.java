package command;

import controlleur.Controlleur;

public class Cursseur implements Command {
    Controlleur c ;
	
	/**
	 * Creation du cursseur 
	 * @param a Controlleur de la vue et metronome 
	 */
	public Cursseur (Controlleur a){
			c=a;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		c.cursseur();
		
	}

}
