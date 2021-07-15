
import java.net.URL;
import java.util.ResourceBundle;

import entita.Amministratore;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class AdminController implements Initializable{

    @FXML
    private TableView<Amministratore> tabellaAdmin;

    @FXML
    private TableColumn<Amministratore, Integer> idAdmin;
    @FXML
    private TableColumn<Amministratore, String> usernameAdmin;
    @FXML
    private TableColumn<Amministratore, String> passwordAdmin;
    
    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		idAdmin.setCellValueFactory(new PropertyValueFactory<Amministratore, Integer>("idAmministratore"));
		usernameAdmin.setCellValueFactory(new PropertyValueFactory<Amministratore, String>("username"));
		passwordAdmin.setCellValueFactory(new PropertyValueFactory<Amministratore, String>("password"));
		
		ObservableList<Amministratore> a;
		try {
			a = FXCollections.observableArrayList(Prova1.getLista());
			tabellaAdmin.setItems(a);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}

