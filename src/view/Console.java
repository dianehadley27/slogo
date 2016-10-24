package view;
import java.util.Collection;
import java.util.Queue;

import view.data.DataIn;
import javafx.scene.Group;
import javafx.scene.control.TextArea;


/**
 * The purpose of this class is to create the root that visualizes the console.
 * This root can then be passed to UI to be displayed in the scene
 * 
 * @author Diane Hadley
 */

public class Console extends UIBuilder{
	
	private Group root = new Group();
	private int consoleHeight;
	private int consoleWidth;
	private int consoleX;
	private int consoleY;
	private TextArea console;
	
	
	public Console(int sceneHeight, int sceneWidth){
		super();
		this.consoleHeight = sceneHeight - WORKSPACE_HEIGHT - 120;
		this.consoleWidth = sceneWidth - COMMAND_LINE_WIDTH - 30;
		this.consoleX = COMMAND_LINE_WIDTH + 20;
		this.consoleY = WORKSPACE_HEIGHT + 110;
	}
	
	
	
	/*
	 * returns root with all visualization of console
	 * 
	 */	
	public Group getRoot(){
		
		makeConsole();
		root.getChildren().add(getText(consoleX, consoleY - 10, uiResources.getString("Console")));
		return root;
	}
	
	
	private void makeConsole(){
		console = new TextArea();
		console.setEditable(false);
		console.setPrefWidth(consoleWidth);
		console.setPrefHeight(consoleHeight);
		console.setLayoutX(consoleX);
		console.setLayoutY(consoleY);		
		root.getChildren().add(console);
	}
	
	public void updateConsole(Collection<String> consoleResults) {
		for (String command:consoleResults) {
			console.appendText(command+"\n");
		}
	}
	
	
}

