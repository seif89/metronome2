package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import command.Command;
import command.Tic;
import command.UpdateMesure;
import command.UpdateTempo;
import controlleur.ControlleurImpl;
import moteur.MoteurImpl;

public class TestMetronome {
	static MoteurImpl m;
	static ControlleurImpl controller;
	static UpdateTempo updatetempo;
	static UpdateMesure updatemesure;
	static Tic tic;

	@BeforeClass
	public static void init() {
		m = new MoteurImpl();
		controller = new ControlleurImpl(m);
		updatetempo = new UpdateTempo(controller);
		updatemesure = new UpdateMesure(controller);
		tic = new Tic(controller);
		m.setCmdUpdate(updatetempo, updatemesure);
		m.setCmdTic(tic);

	}
	
    // test Moteur 
	@Test
	public void testsettempos() {
		controller.start();
		m.settempos(130);
		assertTrue(m.gettempo() == 130);
	}

	@Test
	public void testgettempos() {
		controller.start();
		m.settempos(130);
		float tempo = m.gettempo();
		assertTrue(tempo == m.gettempo());
	}

	@Test
	public void testsetEtat() {
		m.setEtat(true);
		assertTrue(m.getEtat() == true);

	}

	@Test
	public void testgetEtat() {
		m.setEtat(true);
		boolean etat = m.getEtat();
		assertTrue(m.getEtat() == etat);
	}

	@Test
	public void testcreateHorloge() {
		m.createHorloge();
		assertNotNull(m.getHorloge());
	}
	
	@Test 
	public void testsetCmdUpdate() {
		// TODO Auto-generated method stub
		Command cupdatetempo = new UpdateTempo(controller);
		Command cupdatemesure = new UpdateMesure(controller);
		m.setCmdUpdate(cupdatetempo, cupdatemesure);
		assertNotNull(m.getUpdateTempo());
		assertNotNull(m.getUpdateMesure());
	}
	
	@Test
	public void testsetCmdTic() {
		// TODO Auto-generated method stub
		Command ctic = new Tic(controller);
		m.setCmdTic(ctic);
		assertNotNull(m.getTic());	
	}
	
	@Test
	public void testgetMesure() {
		// TODO Auto-generated method stub
		m.setMesure(3);
		int mesure = m.getMesure();
		assertTrue(mesure == m.getMesure() );	
	}
	
	@Test
	public void testsetMesure() {
		// TODO Auto-generated method stub
		m.setMesure(3);
		assertTrue( 3 == m.getMesure() );	
	}
	
	
	// test controller 
	
	@Test
	public void teststart() {
		// TODO Auto-generated method stub
		controller.start();
		assertTrue( m.getEtat()==true );	
	}
	
	@Test
	public void testinc() {
		// TODO Auto-generated method stub
		int mesure = m.getMesure();
		controller.inc();
		mesure++;
		assertTrue( m.getMesure() == mesure);	
	}
	

	@Test
	public void testdec() {
		// TODO Auto-generated method stub
		int mesure = m.getMesure();
		controller.dec();
		mesure--;
		assertTrue( m.getMesure() == mesure);	
	}
	
	@Test
	public void teststop() {
		// TODO Auto-generated method stub
		controller.stop();
		assertTrue( m.getEtat() == false);	
	}
	

	
	
	

}
