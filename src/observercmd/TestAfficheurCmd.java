package observercmd;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class TestAfficheurCmd {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUpdateExiste() {
		Composant comp = new AfficheurCmd();
		assertTrue(comp.getCommande("update") != null);
	}

	@Test
	public void testAttach() {
		Composant compo = new AfficheurCmd();
		MoteurCmd<String> compteur = new ConcreteSubjectCmd<String>();
		
		compteur.attach(compo);
		assertTrue(compteur.isAttached(compo));
		
	}
	
	class ObserverTest extends ComposantSimple {
		boolean appelRecu = false;
		Integer valeur;
		
		public boolean isAppelRecu() {
			return appelRecu;
		}
		
		public Integer getValeur() {
			return valeur;
		}
		
		public void setValeur(Integer v) {
			valeur = v;
		}

		public ObserverTest() {
			setCommand("update", new Commande() {
			@Override
			public void executer(Object parametre) {
				appelRecu = true;
				valeur = ((MoteurCmd<Integer>) parametre).getValue();
			}
		});
		}
	}
	
	@Test
	public void testSetValue() {
		Composant obsTest = new ObserverTest();
		MoteurCmd<Integer> subject = new ConcreteSubjectCmd<Integer>();
		
		
		Integer theValue = new Integer(1200);
		subject.attach(obsTest);
		subject.setValue(theValue);
		// Conversion de type nécessaire pour accéder à l'opération 'isAppelRecu()'
		//   spécifique de ObserverTest
		assertTrue(((ObserverTest) obsTest).isAppelRecu());
		assertEquals(((ObserverTest) obsTest).getValeur(),theValue);
	}
}
