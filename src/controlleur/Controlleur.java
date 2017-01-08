package controlleur;

import vue.Vue;

public interface Controlleur {
	/**
	 *  démarrer le metronome  
	 */
void start();
void inc();
void dec();
void stop();
void cursseur();
void updateTempo();
void tic();
void updateMesure();
public void setVue(Vue v);

}
