package controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import domain.AmministratoreAziendale;
import domain.Utente;
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
		String s = "SELECT * FROM utente " + "WHERE username=" + "'" + username.getText() + "'" + " AND " + "password="
				+ "'" + password.getText() + "';";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(s);
		try {
			if (rs.next()) {
				apriSchermate(rs);
			} else {

				labelErrore.setVisible(true);
				username.clear();
				password.clear();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void apriSchermate(ResultSet rs) throws Exception {
		switch (rs.getString("tipo")) {
		case "s":
			Utente u = new Utente();
			u.setNome(rs.getString("nome"));
			u.setNome(rs.getString("cognome"));
			u.setNome(rs.getString("username"));
			u.setNome(rs.getString("password"));
			dispatcher.loggedIn(u);
			break;
		case "ta":

			break;
		case "tu":
			System.out.println("tutor uni");
			break;
		case "aa":
			AmministratoreAziendale aa = new AmministratoreAziendale();
			aa.setUsername(username.getText());
			dispatcher.GetView("adminaziendale", aa);
		}

	}

	@FXML
	void registrazione(ActionEvent event) {
		dispatcher.GetView("registrazione", null);
	}

}
