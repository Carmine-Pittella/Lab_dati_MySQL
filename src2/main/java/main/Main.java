package main;

import javafx.application.Application;
import javafx.stage.Stage;
import view.ViewDispatcher;

public class Main extends Application {
	public static void main(String[] args) throws Exception {
		//CreazioneTabelle.run();
		launch(args);

	}

	@Override
	public void start(Stage stage) throws Exception {
		ViewDispatcher dispatcher = ViewDispatcher.getInstance();
		dispatcher.login(stage);
	}

}
