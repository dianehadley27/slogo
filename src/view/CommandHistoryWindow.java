package view;
import view.data.DataIn;

import java.util.Collection;
import java.util.HashMap;
import java.util.Queue;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;


public class CommandHistoryWindow {
	private int height;
	private int width;
	Stage stage;
	Group group;
	Scene scene;
	TextArea popupScene;

	CommandHistoryWindow(int height, int width) {
		this.stage=new Stage();
		this.popupScene = new TextArea();
		this.height=height;
		this.width=width;
		this.group=new Group();
		this.scene=new Scene(group);
		init();
	}
	
	public void init() {
        popupScene = new TextArea();
        stage.setTitle("History");
        popupScene.setEditable(false);
		popupScene.setPrefWidth(width);
		popupScene.setPrefHeight(height);
		popupScene.setLayoutX(width);
		popupScene.setLayoutY(height);
		group.getChildren().add(popupScene);
	}
	
	public void updateCommandHistory(Collection<String> commandHistory) {
		popupScene.appendText("hello");
		for (String command:commandHistory) {
			popupScene.appendText(command+"\n");
		}
	}
	
	public void show() {
		stage.setScene(scene);
        stage.show();
	}

}
