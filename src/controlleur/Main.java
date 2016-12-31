package controlleur;

import fr.istic.command.*;
import fr.istic.materiel.Materiel;
import fr.istic.materiel.MaterielImpl;
import fr.istic.moteur.Moteur;
import fr.istic.moteur.MoteurImpl;
import fr.istic.vue.Adaptateur;
import fr.istic.vue.AdapterInverse;
import fr.istic.vue.Vue;
import fr.istic.vue.VueImpl;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application{
	private static Moteur moteur;
	private static Vue vue;
	private static ControlleurImpl controller;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
        
	}

	@Override
	public void start(Stage primaryStage) throws IOException {
		// TODO Auto-generated method stub
		 FXMLLoader loader = new FXMLLoader ();
         Parent root  = loader.load(Main.class.getResource("vue.fxml").openStream());
          
         moteur= new MoteurImpl(); 
         vue  =  loader.getController() ;
         
         
         Adaptateur adaptateur = new Adaptateur();
         adaptateur.setVue((VueImpl)vue);
         
         Materiel.setMatriel(new MaterielImpl());
         
          controller = new ControlleurImpl(moteur);
          controller.setVue(adaptateur);
          
          AdapterInverse adapterInverse = new AdapterInverse();
          adapterInverse.setVue((VueImpl)vue);
          
          // initialisation des commandes de la vue 
          Dec cmddec = new Dec(adapterInverse);
          Inc cmdinc = new Inc (adapterInverse);
          Cursseur cmdcurs = new Cursseur(adapterInverse);
          Stop cmdstop = new Stop(adapterInverse);
          Start cmdstart = new Start (adapterInverse);
         
          // initialisation des commmande de adaptateur
         Dec dec = new Dec(controller);
         Inc inc = new Inc (controller);
         Cursseur curs = new Cursseur(controller);
         Tic tic = new Tic (controller);
         Stop stop = new Stop(controller);
         UpdateTempo updatetempo = new UpdateTempo(controller);
         UpdateMesure updatemesure = new UpdateMesure(controller);
         Start start = new Start (controller);
         
         
         Poll poll = new Poll(adaptateur);
         Materiel.getHorloge().activerPeriodiquement(poll,(float) 0.2);
         
         vue.setCursseur(cmdcurs);
         vue.setStart(cmdstart);
         vue.setStope(cmdstop);
         vue.setInc(cmdinc);
         vue.setDec(cmddec);
         
         adaptateur.setCursseur(curs);
         adaptateur.setStart(start);
         adaptateur.setStope(stop);
         adaptateur.setInc(inc);
         adaptateur.setDec(dec);
         
         moteur.setCmdUpdate(updatetempo ,updatemesure);
         moteur.setCmdTic(tic);
         vue.initialise();
         primaryStage.setTitle("metronome");
		 primaryStage.setScene(new Scene(root));
		 primaryStage.setResizable(false);
		 primaryStage.show();
		 primaryStage.setOnCloseRequest(t -> {
	            Platform.exit();
	            System.exit(0);
	        });
		
		}
	}

