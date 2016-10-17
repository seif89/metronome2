package observer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author plouzeau
 * @version 1.0 2012-09-15 T 20:00
 * Cours M1 ACO
 * Classe de test unitaire pour évaluer le bon fonctionnement 
 * de Compteur.
 * Comporte un test d'intégration Compteur/Observer (opération testSetValue).
 */
public class TestCompteur {

	private Moteur<Integer> cpt;
	private Observer<Integer> observer;

	@Before
	public void setUp() throws Exception {
		cpt = new ConcreteSubject<Integer>();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetValue() {
		Integer theValue = new Integer(1200);
		cpt.setValue(theValue);
		assertEquals(cpt.getValue(), theValue);
	}

	@Test
	public void testAttach() {
		observer = new Afficheur();
		cpt.attach(observer);
		assertTrue(cpt.isAttached(observer));
	}

	@Test
	public void testDetach() {
		observer = new Afficheur();
		cpt.attach(observer);
		cpt.detach(observer);
		assertFalse(cpt.isAttached(observer));
	}

	class ObserverTest implements Observer<Integer> {
		boolean appelRecu = false;
		Integer valeur;
		
		public boolean isAppelRecu() {
			return appelRecu;
		}

		public void update(Moteur<Integer> s) {
			appelRecu = true;
			valeur = s.getValue();
		}
		
		public Integer getValeur() {
			return valeur;
		}
	}

	
	/**
	 * Vérifie que le mécanisme de notification fonctionne entre Compteur et Observer.
	 * On emploie une classe interne qui ne sert que pour la définition d'un Observer spécial test
	 */
	@Test
	public void testSetValue() {
		Observer<Integer> obsTest = new ObserverTest();

		Integer theValue = new Integer(1200);
		cpt.attach(obsTest);
		cpt.setValue(theValue);
		// Conversion de type nécessaire pour accéder à l'opération 'isAppelRecu()'
		//   spécifique de ObserverTest
		assertTrue(((ObserverTest) obsTest).isAppelRecu());
		assertEquals(((ObserverTest) obsTest).getValeur(),theValue);
	}

}
