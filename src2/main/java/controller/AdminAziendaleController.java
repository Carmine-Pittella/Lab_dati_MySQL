package controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

import domain.AmministratoreAziendale;
import domain.Azienda;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import service.SqlAziendaService;
import view.ViewDispatcher;

public class AdminAziendaleController implements Initializable, DataInitializable<AmministratoreAziendale> {

	

	private SqlAziendaService aziendaservice;
	private AmministratoreAziendale admin;
	private ViewDispatcher dispatcher;

	@FXML
	private TextField partitaIva;
	@FXML
	private TextField nome;
	@FXML
	private TextField settore;
	@FXML
	private TextField NomeRappr;
	@FXML
	private TextField cognomeRappr;
	@FXML
	private Button conferma;
	@FXML
	private Button annulla;
	@FXML
    private Label successo;

	public AdminAziendaleController() {
		aziendaservice = new SqlAziendaService();
		dispatcher = ViewDispatcher.getInstance();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		successo.setVisible(false);

	}

	@FXML
	void inserisciAzienda(ActionEvent event) throws Exception {

		Azienda azienda = new Azienda();
		azienda.setCognomeRappresentante(cognomeRappr.getText());
		azienda.setNome(nome.getText());
		azienda.setNomeRappresentante(NomeRappr.getText());
		azienda.setSettore(settore.getText());
		azienda.setPartitaIva(partitaIva.getText());

		aziendaservice.creaAzienda(azienda, admin.getUsername());
		successo.setVisible(true);
	}
	
	 @FXML
	    void tornaIndietro(ActionEvent event) {
		 dispatcher.logout();

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

	@Override
	public void initializeData(AmministratoreAziendale t) {
		this.admin = t;
	}

}
