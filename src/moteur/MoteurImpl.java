package moteur;

import command.Command;

public class MoteurImpl implements Moteur {

	private int mesure = 4;
	private boolean etat;
	private float tempo = 120;

	private Horloge horloge;
	private Command updateMesure;
	private Command tic;
	private Command updateTempo;

	public Command getUpdateMesure() {
		return updateMesure;
	}

	public void setUpdateMesure(Command updateMesure) {
		this.updateMesure = updateMesure;
	}

	public Command getTic() {
		return tic;
	}

	public Command getUpdateTempo() {
		return updateTempo;
	}

	public void setUpdateTempo(Command updateTempo) {
		this.updateTempo = updateTempo;
	}

	public MoteurImpl() {
		super();
		etat = false;
	}

	@Override
	public float gettempo() {
		// TODO Auto-generated method stub
		return tempo;
	}

	@Override
	public void settempos(int a) {
		// TODO Auto-generated method stub
		this.tempo = a;
		
		updateTempo.execute();
		if (etat == true) {
			horloge.desactiver();
			createHorloge();
		}
	}

	@Override
	public boolean getEtat() {
		// TODO Auto-generated method stub
		return etat;
	}

	@Override
	public void setEtat(boolean val) {
		// TODO Auto-generated method stub
		etat = val;

	}


	@Override
	public void createHorloge() {
		// TODO Auto-generated method stub
		

		horloge = new HorlogeImpl();
		float a = 60 / gettempo();
		horloge.activerPeriodiquement(tic, a);
		updateTempo.execute();

	}

	public void setCmdUpdate(Command c1, Command c2) {
		// TODO Auto-generated method stub
		updateTempo = c1;
		updateMesure = c2;
	}

	@Override
	public void setCmdTic(Command ctic) {
		// TODO Auto-generated method stub
		tic = ctic;

	}

	public Horloge getHorloge() {
		return this.horloge;
	}



	@Override
	public int getMesure() {
		// TODO Auto-generated method stub

		return mesure;
	}

	@Override
	public void setMesure(int mesure) {
		if (mesure >= 2 && mesure <= 7)
			this.mesure = mesure;

	}

	@Override
	public void incMesure() {
		// TODO Auto-generated method stub
		if (mesure < 7) {
			mesure++;
		}

		updateMesure.execute();
	}

	@Override
	public void decMesure() {
		// TODO Auto-generated method stub
		if (mesure > 2) {
			mesure--;
		}
		updateMesure.execute();
	}

}
