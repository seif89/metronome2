package moteur;

import command.Command;

public interface Horloge {
    /**
     * Activation de la commande cmd périodiquement par periodeEnMiliSecondes
     * @param cmd la commande a activé
     * @param periodeEnMiliSecondes periodeEnMiliSecondes
     */
	void activerPeriodiquement(Command cmd, float periodeEnMiliSecondes);

/**
 *  d�sactivation de l'horloge  
 *  
 *  
 */
	void desactiver();
	
	
}
