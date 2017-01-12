package controlleur;

import command.*;
import moteur.Moteur;
import moteur.MoteurImpl;
import	vue.Vue;
import vue.VueImpl;
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


            controller = new ControlleurImpl(moteur);
            controller.setVue(vue);

            Dec dec = new Dec(controller);
            Inc inc = new Inc (controller);
            Cursseur curs = new Cursseur(controller);
            Tic tic = new Tic (controller);
            Stop stop = new Stop(controller);
            UpdateTempo updatetempo = new UpdateTempo(controller);
            UpdateMesure updatemesure = new UpdateMesure(controller);
            Start start = new Start (controller);
            vue.setCursseur(curs);
            vue.setStart(start);
            vue.setStope(stop);
            vue.setInc(inc);
            vue.setDec(dec);

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