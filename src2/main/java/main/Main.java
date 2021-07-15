package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	public static void main(String[] args) throws Exception {
//		CreazioneTabelle.creaTabellaAzienda();
//		CreazioneTabelle.creaTabellaAdmin();
//		CreazioneTabelle.creaTabellaAnagrafica();
//		CreazioneTabelle.creaTabellaFeedback();
//		CreazioneTabelle.creaTabellaSede();
//		CreazioneTabelle.creaTabellaStudente();
//		CreazioneTabelle.creaTabellaTelefono();
//		CreazioneTabelle.creaTabellaTirocinio();
//		CreazioneTabelle.creaTabellaTutorAziendale();
//		CreazioneTabelle.creaTabellaTutorUniversitario();
		// Prova1.creaAmministratore();
		launch(args);

	}

	@Override
	public void start(Stage PrimaSchermata) throws Exception {
		Parent mainPane = FXMLLoader.load(Main.class.getResource("provina.fxml"));
		PrimaSchermata.setTitle("Farmacia");
		PrimaSchermata.setScene(new Scene(mainPane));
		PrimaSchermata.show();
	}

}
