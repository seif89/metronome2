package observercmd;

/**
 * @author JELASSI
 * @version 1.0
 * 
 * Interface de base pour les sujets.
 * Le code propre à la notification est situé dans une classe concrète.
 * Le paramètre 'V' est le type de la valeur gérée par le sujet.
 */
public interface MoteurCmd<V> {
	public void attach(Composant c);
	public void detach(Composant c);
	public boolean isAttached(Composant c);
	public V getValue();
	public void setValue(V value);
}

