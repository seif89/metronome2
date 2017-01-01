package moteur;

import command.Command;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class HorlogeImpl implements Horloge {
	private ScheduledExecutorService scheduler;
	private ScheduledFuture<?> beeperHandle;

	@Override
	public void activerPeriodiquement(Command cmd, float periodeEnMiliSecondes) {
		scheduler = Executors.newScheduledThreadPool(1);
		final Runnable beeper = new Runnable() {
			public void run() {
				cmd.execute();
			}
		};
		beeperHandle = scheduler.scheduleAtFixedRate(beeper, 0, (int) (periodeEnMiliSecondes * 1000), MILLISECONDS);
		/*
		 * scheduler.schedule(new Runnable() { public void run() {
		 * beeperHandle.cancel(true); } }, 60 * 60, SECONDS);
		 */
	}

	@Override
	public void desactiver() {
		// TODO Auto-generated method stub
		scheduler.shutdownNow();
	}

}
