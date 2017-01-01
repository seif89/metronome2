package moteur;

import command.Command;


public interface Moteur {

	/** renvoie la propriété qui définit  nombre de temps par mesure
	 * 
	 * @return la propriété qui définit  nombre de temps par mesure.
	 */
	public int getMesure();
    /**
     *  Assignation de la propriété  de mesure 
     * @param mesure la propriété  de mesure 
     */
	public void setMesure(int mesure);

	/**
	 * Renvoie la propriété qui définit le nombre de batement par minute 
	 * @return la propriété qui définit le nombre de batement par minute
	 */
	public float gettempo();
/**
 *  Incrémente la propriété qui définit  nombre de temps par mesure
 */
	public void incMesure();
/**
 * Décrémente la propriété qui définit  nombre de temps par mesure
 */
	public void decMesure();
/**
 * Assignation de la commande flashTic 
 * @param ctic la commande flashTic 
 */
	void setCmdTic(Command ctic);
/**
 * assignation de la commande UpdateMesure et UpdateTempo
 * @param c1 la commande UpdateMesure
 * @param c2 la commande UpdateTempo
 */
	public void setCmdUpdate(Command c1, Command c2);
/**
 * Renvoie l'horloge 
 * @return l'horloge
 */
	public Horloge getHorloge();

	/**
	 * Assignation de  la propriété qui définit le nombre de batement par minute
	 * @param a la propriété qui définit le nombre de batement par minute
	 */
	public void settempos(int a);

	/**
	 * Renvoie la propriété qui définit l'etat de métronome 
	 * 
	 * @return true si EnMarche 
	 *         false si non
	 */
	public boolean getEtat();

	/**
	 * Assignation de la propriété qui définit l'état de métronome 
	 * @param etat la propriété qui définit l'état de métronome
	 */
	public void setEtat(boolean etat);

	

	/**
	 * Créer une horloge 
	 */
	void createHorloge();
	


	

}
