package controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

import domain.AmministratoreAziendale;
import domain.Studente;
import domain.TutorAziendale;
import domain.TutorUniversitario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import service.sqlUtenteService;
import view.ViewDispatcher;

public class RegistrazioneController implements Initializable, DataInitializable<Object> {

	private ViewDispatcher dispatcher;
	private sqlUtenteService utenteService;

	@FXML
	private DatePicker dataNascita;
	@FXML
	private TextField matricola;
	@FXML
	private TextField corsoLaurea;
	@FXML
	private TextField codiceFiscale;
	@FXML
	private TextField nome;
	@FXML
	private TextField cognome;
	@FXML
	private TextField luogoNascita;
	@FXML
	private TextField residenza;
	@FXML
	private CheckBox handicapSi;
	@FXML
	private CheckBox handicapNo;
	@FXML
	private Label handicapLabel;
	@FXML
	private ComboBox<String> tipologiaUtente;
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	@FXML
	private PasswordField confermaPassword;
	@FXML
	private Button confermaBottone;
	@FXML
	private Label labelErrore;

	String s = "";

	public RegistrazioneController() {
		dispatcher = ViewDispatcher.getInstance();
		utenteService = new sqlUtenteService();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		handicapNo.setSelected(true);
		tipologiaUtente.getItems().addAll("Studente", "Tutor aziendale", "Tutor universitario",
				"Amministratore aziendale");
		labelErrore.setVisible(false);
	}

	public static Connection getConnection() throws Exception {
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto", "root", "root");
			return con;

		} catch (Exception e) {
			System.out.println("get connection" + e.getMessage());
		}
		return null;
	}

	@FXML
	void annulla(ActionEvent event) {
		dispatcher.logout();
	}

	public Date convertToDateViaSqlDate(LocalDate dateToConvert) {
		return java.sql.Date.valueOf(dateToConvert);
	}

	@FXML
	void conferma(ActionEvent event) throws Exception {

		if (!password.getText().equalsIgnoreCase(confermaPassword.getText())) {
			labelErrore.setText("Le password non coincidono!");
		}

		switch (s) {
		case "Studente":

			Studente u = new Studente();
			u.setNome(nome.getText());
			u.setCognome(cognome.getText());
			u.setCorsoDiLaurea(corsoLaurea.getText());
			u.setPassword(password.getText());
			u.setUsername(username.getText());
			u.setMatricola(Integer.parseInt(matricola.getText()));
			if (handicapSi.isSelected()) {
				u.setHandicap(true);
			}
			if (handicapNo.isSelected()) {
				u.setHandicap(false);
			}
			u.setCodiceFiscale(codiceFiscale.getText());
			u.setDataNascita((dataNascita.getValue()));
			u.setLuogoNascita(luogoNascita.getText());
			u.setResidenza(residenza.getText());

			utenteService.creaStudente(u);

			dispatcher.logout();
			break;

		case "Tutor aziendale":

			TutorAziendale ta = new TutorAziendale();
			ta.setNome(nome.getText());
			ta.setCognome(cognome.getText());
			ta.setUsername(username.getText());
			ta.setPassword(password.getText());

			utenteService.creaTutorAziendale(ta);
			dispatcher.logout();
			break;

		case "Tutor universitario":

			TutorUniversitario tu = new TutorUniversitario();
			tu.setNome(nome.getText());
			tu.setCognome(cognome.getText());
			tu.setUsername(username.getText());
			tu.setPassword(password.getText());

			utenteService.creaTutorUniversitario(tu);
			dispatcher.logout();
			break;

		case "Amministratore aziendale":
			AmministratoreAziendale aa = new AmministratoreAziendale();

			aa.setNome(nome.getText());
			aa.setCognome(cognome.getText());
			aa.setUsername(username.getText());
			aa.setPassword(password.getText());

			utenteService.creaAdminAziendale(aa);
			dispatcher.logout();
			break;
		}

	}

	@FXML
	void handicap(ActionEvent event) {
		if (event.getSource().equals(handicapSi)) {
			handicapNo.setSelected(false);
		} else {
			handicapSi.setSelected(false);
		}

	}

	@FXML
	void selezionaUtente(ActionEvent event) {
		tipologiaUtente.setVisible(false);
		if (!tipologiaUtente.getValue().equalsIgnoreCase("Studente")) {

			handicapLabel.setVisible(false);
			handicapNo.setVisible(false);
			handicapSi.setVisible(false);
			matricola.setVisible(false);
			corsoLaurea.setVisible(false);
			dataNascita.setVisible(false);
			luogoNascita.setVisible(false);
			residenza.setVisible(false);
			codiceFiscale.setVisible(false);
		}

		s = tipologiaUtente.getValue();
	}
}
