package controller;

import java.net.URL;
import java.util.ResourceBundle;

import domain.Utente;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class HomeController implements Initializable, DataInitializable<Utente> {
	
	@FXML
	private Label labelBenvenuto;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	@Override
	public void initializeData(Utente utente) {
		labelBenvenuto.setText("Benvenuto " + utente.getNome() + " " + utente.getCognome());

	}

}
