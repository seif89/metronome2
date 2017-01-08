package vue;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import command.Command;
import command.Cursseur;
import command.Dec;
import command.Inc;
import command.Start;
import command.Stop;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class VueImpl implements Vue {

	Start start;
	Stop stope;
	Inc inc;
	Dec dec;
	Cursseur cursseur;

	@FXML
	private Slider tempoSlider;

	@FXML
	private Label tempoDisplay;

	@FXML
	private Button startButton;
	@FXML
	private Button stopButton;
	@FXML
	private Button increaseButton;
	@FXML
	private Button decreaseButton;

	@FXML
	private Circle led1;
	@FXML
	private Circle led2;
	private AudioClip clip1;
	private AudioClip clip2;

	private ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);

	@Override
	public void start() {
		// TODO Auto-generated method stub
		startButton.setDisable(true);
		stopButton.setDisable(false);
		start.execute();
		// System.out.println("toucher");

	}

	@Override
	public void stop() {
		startButton.setDisable(false);
		stopButton.setDisable(true);

		// TODO Auto-generated method stub
		stope.execute();

	}

	@Override
	public void inc() {
		// TODO Auto-generated method stub
		inc.execute();

	}

	@Override
	public void dec() {
		// TODO Auto-generated method stub
		dec.execute();
	}

	public void setCursseur(Cursseur c) {
		cursseur = c;
	}

	public float getvaleurslider() {
		return (float) tempoSlider.getValue();
	}

	public void setlabel(int value) {

		String val = Integer.toString(value);
		tempoDisplay.setText(val);
	}

	public void initialise() {
		
	
		final URL resource1 = getClass().getResource("kick.wav");
		final URL resource2 = getClass().getResource("snare.wav");
		clip1 = new AudioClip(resource1.toString());
		clip2 = new AudioClip(resource2.toString());
		tempoSlider.setValue(120);
		cursseur.execute();
		//tempoDisplay.setText("120");
		tempoSlider.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
				
				cursseur.execute();
			}
		});

	}

	@Override
	public void allumerled1() {
		// TODO Auto-generated method stub
		/*
		 * System.out.println("rouge"); if(led1.getFill().equals(Color.WHITE))
		 * led1.setFill(Color.RED); else led1.setFill(Color.WHITE);
		 */

		led1.setFill(Color.RED);
		clip1.play(1.0);
		executor.schedule((Runnable) () -> led1.setFill(Color.WHITE), 50, TimeUnit.MILLISECONDS);

	}

	@Override
	public void setStart(Start c) {
		// TODO Auto-generated method stub
		start = c;
	}

	@Override
	public void setStope(Stop c) {
		// TODO Auto-generated method stub
		this.stope = c;

	}

	@Override
	public void eteindled() {
		// TODO Auto-generated method stub
		System.out.println("white");
		led1.setFill(Color.WHITE);
		led2.setFill(Color.WHITE);

	}

	@Override
	public void updateMeasure(int measure) {
		// TODO Auto-generated method stub
		if (measure == 7)
			increaseButton.setDisable(true);
		else
			increaseButton.setDisable(false);

		if (measure == 2)
			decreaseButton.setDisable(true);
		else
			decreaseButton.setDisable(false);
	}

	@Override
	public void allumerled2() {
		// TODO Auto-generated method stub
		/*
		 * if(led2.getFill().equals(Color.WHITE)) led2.setFill(Color.BLUE); else
		 * led2.setFill(Color.WHITE);
		 */

		led2.setFill(Color.RED);
		clip2.play(1.0);
		executor.schedule((Runnable) () -> led2.setFill(Color.WHITE), 50, TimeUnit.MILLISECONDS);

	}

	@Override
	public void setDec(Dec c) {
		// TODO Auto-generated method stub
		dec = c;
	}

	@Override
	public void setInc(Inc c) {
		// TODO Auto-generated method stub
		inc = c;
	}

}
