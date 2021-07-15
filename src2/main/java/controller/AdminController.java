package controller;

import java.net.URL;
import java.util.ResourceBundle;

import domain.Amministratore;
import domain.Utente;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class AdminController implements Initializable, DataInitializable<Utente> {

	@FXML
	private TableView<Utente> tabellaAdmin;
	@FXML
	private TableColumn<Utente, Integer> idAdmin;
	@FXML
	private TableColumn<Utente, String> usernameAdmin;
	@FXML
	private TableColumn<Utente, String> passwordAdmin;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		idAdmin.setCellValueFactory(new PropertyValueFactory<Utente, Integer>("idAmministratore"));
		usernameAdmin.setCellValueFactory(new PropertyValueFactory<Utente, String>("username"));
		passwordAdmin.setCellValueFactory(new PropertyValueFactory<Utente, String>("password"));

		ObservableList<Amministratore> a;
		try {
//			a = FXCollections.observableArrayList(prova1.getLista());
//			tabellaAdmin.setItems(a);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("ERRORE: durante initialize");
		}
	}

	@Override
	public void initializeData(Utente utente) {

	}

}
