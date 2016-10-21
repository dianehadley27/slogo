package view;
import java.util.List;
import java.util.ResourceBundle;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

/**
 *The purpose of this class is to create the root that visualizes the commandLine
 *and to return the input in the command line as a list of commands so that
 *they can be executed
 *
 * @author Diane Hadley
 *
 */



public class CommandLine extends UIBuilder{
	
	private Group root = new Group();
	private TextArea textArea = new TextArea();

	private int commandLineHeight;
	private int commandLineWidth;
	private int commandLineY;
	
	private static int FIRST_BUTTON_X = 190;
	private static int BUTTON_SPACING = 170;
	private int buttonsY; 
	
	private static int COMMAND_LINE_X = 10;
	
	private DataIn DataIn;
	
	
	public CommandLine(int sceneHeight,DataIn DataIn){
		super();
		this.commandLineHeight = sceneHeight - TURTLE_CANVAS_HEIGHT - 120;
		this.commandLineY = TURTLE_CANVAS_HEIGHT + 110; 
		this.commandLineWidth = COMMAND_LINE_WIDTH;
		this.buttonsY = TURTLE_CANVAS_HEIGHT + 65;
		this.DataIn=DataIn;
	}
	
	
	/*
	 * returns root with all visualization of commandLine
	 * 
	 */	
	public Group getRoot(){
		makeCommandLine();
		getButtons();
		root.getChildren().add(getText(COMMAND_LINE_X, commandLineY - 10, 
				uiResources.getString("CommandLine")));
		return root;
	}
	
	
	/*
	 * returns list of objects which are each a line of input in the command line
	 */
	public List<Object> getCommand(){
		
		//Pim will complete this with observer
		return null;
	}
	
	private void makeCommandLine(){
		
		textArea.setLayoutY(commandLineY);
		textArea.setLayoutX(COMMAND_LINE_X);
		textArea.setPrefWidth(commandLineWidth);
		textArea.setPrefHeight(commandLineHeight);
		
		//Make scrollable
		
		root.getChildren().add(textArea);
	}
	
	private void getButtons(){
		Button reset = makeButton(FIRST_BUTTON_X, buttonsY, uiResources.getString("ResetAll"), "generalcontrol");
		reset.setOnAction((event) -> {
			//TODO: add action
		});	
		
		Button history = makeButton(FIRST_BUTTON_X + BUTTON_SPACING, buttonsY, 
				uiResources.getString("History"), "generalcontrol");
		history.setOnAction((event) -> {
			//get queue from dataout
			//keep displaying until its done
		});	
		
		Button submit = makeButton(FIRST_BUTTON_X + BUTTON_SPACING*2, buttonsY, 
				uiResources.getString("Submit"), "generalcontrol");
		submit.setOnAction((event) -> {
			//set commandLine
			if (!textArea.getText().trim().equals("")) {
				DataIn.addCommand(textArea.getText());
				System.out.println(DataIn.getCommand());
				//update variables from workspace
				//update turtle position
				
				//update console
				UI.console.updateResults(UI.DataOut.getConsoleResults());
				
				//update command history
				UI.console.updateResults(UI.DataOut.getCommandHistory());
			}
			
		});	
		
		root.getChildren().addAll(reset, history, submit);
	}
	

	
}