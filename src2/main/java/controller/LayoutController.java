package controller;

import java.net.URL;
import java.util.ResourceBundle;

import domain.Utente;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import view.ViewDispatcher;

public class LayoutController implements Initializable, DataInitializable<Utente> {
	private ViewDispatcher dispatcher;
	public static Utente utenteMemorizzato;

	@FXML
	private VBox barraMenu;

	private static final MenuElement MENU_HOME = new MenuElement("Home", "home");
	private static final MenuElement[] MENU_ADMIN =	{	new MenuElement("Nuovo Movimento", "aggiungiMovimento"),
														new MenuElement("Lista Movimenti", "listaMovimenti") };

	public LayoutController() {
		dispatcher = ViewDispatcher.getInstance();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	@Override
	public void initializeData(Utente utente) {
		utenteMemorizzato = utente;
		barraMenu.getChildren().add(createButton(MENU_HOME));
		barraMenu.getChildren().add(new Separator());
		for (MenuElement menuElement : MENU_ADMIN) {
			barraMenu.getChildren().add(createButton(menuElement));
		}
	}

	// metodo che serve per creare un bottone nella BARRA_MENU
	private Button createButton(MenuElement viewItem) {
		Button button = new Button(viewItem.getNome());
		button.setStyle("-fx-background-color: transparent; -fx-font-size: 14;");
		button.setTextFill(Paint.valueOf("white"));
		button.setPrefHeight(20);
		button.setPrefWidth(150);
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				dispatcher.renderView(viewItem.getVista(), utenteMemorizzato);
			}
		});
		return button;
	}

}
