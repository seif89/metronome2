package vue;

import fr.istic.command.Cursseur;
import fr.istic.command.Dec;
import fr.istic.command.Inc;
import fr.istic.command.Start;
import fr.istic.command.Stop;

public interface Vue {
	/**
	 *  Demarrer le metronome
	 */
void start();
/**
 *  arreter le metronome
 */
void stop();
/**
 *  Augmente le nombre de temps dans une mesure d'une unite
 */
void inc();
/**
 * dimininue le nombre de temps dans une mesure d'une unite 
 */
void dec();
/**
 *  intialise la vue
 */
void initialise ();
/**
 * Affecter la commande cursseur a la vue 
 * @param c Cursseur
 */
void setCursseur(Cursseur c );
/** Affecter la commande start a la vue
 * 
 * @param c Start
 */
void setStart(Start c );
/** Affecter la commande stop a la vue
 * 
 * @param c Start
 */
void setStope(Stop c);
/**
 * Affecter la commande Dec a la vue
 * @param Dec Dec
 */
void setDec(Dec c);
/**
 *  Affecter la commande Inc a la vue
 * @param c Inc
 */
void setInc (Inc c);
/**
 *  Renvoie la valeur de Molette
 * @return la valeure de molette
 */
float getvaleurslider();
/**
 *  assigner la valeur f a l'afficheur du metronome
 * @param f valeur f
 */
void setlabel(int f );
/**
 *  Emettre un eclair et un clic sonore  pour le  LED 1 
 */
void allumerled1();
/**
 * Eteint  LED 1  et LED 2
 */
void eteindled();
/**
 *  Emettre un eclair et un clic sonore  pour le  LED 2 
 */

void allumerled2();


/**
 * Mettre a jours  l'afficheur 
 * @param mesure mesure
 */

 void updateMeasure(int measure);

	

}
