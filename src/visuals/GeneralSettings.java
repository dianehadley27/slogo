package visuals;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.shape.Rectangle;


/**
 * 
 * The purpose of this class is to display the interface the user can use to change settings
 * and to return the results of these settings
 * 
 * 
 * @author Diane
 *
 */

public class GeneralSettings{
	
	private Group root = new Group();
	private ComboBox<String> languageComboBox;
	private ResourceBundle generalResources;
	
	
	public GeneralSettings(ResourceBundle resources){
		generalResources = resources;
	}
	

	/*
	 * returns the root with all visualizations of 
	 * how the user can update settings
	 */
	public Group getRoot(){
		
		makeLanguageComboBox();
		return root;
	}
	
	
	
	/*
	 * returns the selected language
	 */
	public Object getLanguage(){
		return null;
	}
	
	
	private void makeLanguageComboBox(){
		
		ObservableList<String> languageOptions = FXCollections.observableArrayList(
				generalResources.getString("Chinese"), generalResources.getString("English"),
				generalResources.getString("French"), generalResources.getString("German"),
				generalResources.getString("Italian"), generalResources.getString("Portuguese"),
				generalResources.getString("Russian"), generalResources.getString("Spanish"));		
		
		
		languageComboBox = new ComboBox<String>(languageOptions);
		//backgroundComboBox.setValue(turtleResources.getString());
		
		
		
		root.getChildren().add(setControlLayout(languageComboBox, 140, 10));
	}
	
	private Control setControlLayout(Control control, int x, int y) {
		control.setLayoutX(x);
		control.setLayoutY(y);
		control.setFocusTraversable(false);
		control.getStyleClass().add("generalcontrol");
		return control;
	}
	
	
}