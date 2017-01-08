package controlleur;

import Moteur;
import vue.Vue;

public class ControlleurImpl implements Controlleur {

	Moteur moteur;
	Vue vue;
	int nbTempo;

	public ControlleurImpl(Moteur moteur) {
		super();
		this.moteur = moteur;
		nbTempo = 0;
	}

	public void setVue(Vue v) {
		this.vue = v;
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		moteur.setEtat(true);
		moteur.createHorloge();

	}

	@Override
	public void inc() {
		moteur.incMesure();

	}

	@Override
	public void dec() {
		// TODO Auto-generated method stub

		moteur.decMesure();
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
		moteur.setEtat(false);
		moteur.getHorloge().desactiver();
		if (vue != null)
			vue.eteindled();
		     nbTempo=0;
	}

	@Override
	public void cursseur() {
		// TODO Auto-generated method stub
		
		if (vue != null) {
			int valuetempo = (int) vue.getvaleurslider();
			moteur.settempos(valuetempo);
		}
	}

	@Override
	public void updateTempo() {
		// TODO Auto-generated method stub
	
		if (vue != null)
			
			vue.setlabel((int) moteur.gettempo());
	}

	@Override
	public void tic() {
		// TODO Auto-generated method stub

		nbTempo++;
	
		if (nbTempo >= moteur.getMesure()) {
			
			nbTempo = 0;
			if (vue != null)
				vue.allumerled2();
			    
		}
		if (vue != null)
			vue.allumerled1();
		// vue.eteindled1();

	}

	@Override
	public void updateMesure() {
		// TODO Auto-generated method stub
		if (vue != null)
			vue.updateMeasure(moteur.getMesure());
	}


}
