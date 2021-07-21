package controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import domain.AmministratoreAziendale;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import view.ViewDispatcher;

public class LoginController implements Initializable, DataInitializable<Object> {

	private ViewDispatcher dispatcher;

	@FXML
	private Button accesso;
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	@FXML
	private Label labelErrore;
	@FXML
	private Button bottoneRegistrazione;

	public LoginController() {
		dispatcher = ViewDispatcher.getInstance();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
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
	void accesso(ActionEvent event) throws Exception {

		Connection con = getConnection();

		getUsernameUtente(username.getText());

		String s = "SELECT * FROM utente " + "WHERE username=" + "'" + username.getText() + "'" + " AND " + "password="
				+ "'" + password.getText() + "';";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(s);

		try {

			if (rs.next()) {
				apriSchermate(rs.getString("tipo"));
			} else {

				labelErrore.setVisible(true);
				username.clear();
				password.clear();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void apriSchermate(String s) {
		switch (s) {
		case "s":
			dispatcher.GetView("studente", null);
			break;
		case "ta":

			break;
		case "tu":
			System.out.println("tutor uni");
			break;
		case "aa":
			AmministratoreAziendale aa = new AmministratoreAziendale();
			aa.setUsername(username.getText());
			dispatcher.GetView("adminaziendale", aa );
		}

	}

	public String getUsernameUtente(String s) {
		return s;

	}

	@FXML
	void registrazione(ActionEvent event) {
		dispatcher.GetView("registrazione", null);

	}

}
