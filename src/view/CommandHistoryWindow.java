package view;
import view.data.DataIn;

import java.util.Collection;
import java.util.HashMap;
import java.util.Queue;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CommandHistoryWindow extends UIBuilder{
	private int height;
	private int width;
	Stage stage;
	Group group;
	Scene scene;
	TextArea commandList;
	VBox VBox;
	private UI ui;
	private CommandLine commandLine;
	final ScrollBar sc = new ScrollBar();

	CommandHistoryWindow(UI ui,CommandLine commandLine,int height, int width) {
		super();
		this.stage=new Stage();
		this.commandList = new TextArea();
		this.height=height;
		this.width=width;
		this.group=new Group();
		this.scene=new Scene(group,width,height);
		this.VBox=new VBox(20);
		this.ui=ui;
		this.commandLine=commandLine;
		init();
	}
	
	public void init() {
        VBox.setPadding(new Insets(20));
        stage.setResizable(false);
        stage.setTitle("History");
        stage.setWidth(width);
        stage.setHeight(height);
        group.getChildren().addAll(sc,VBox);
        
        VBox.setLayoutX(5);
        VBox.setSpacing(10);
 
        sc.setLayoutX(scene.getWidth()-sc.getWidth());
        sc.setMin(0);
        sc.setOrientation(Orientation.VERTICAL);
        sc.setPrefHeight(height);
        sc.setMax(height);
        
        sc.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
                    VBox.setLayoutY(-new_val.doubleValue());
                }
        });
        
	}
	
	public void updateCommandHistory(Collection<String> commandHistory) {
		for (String command:commandHistory) {
			HBox HBox = new HBox(10);
			HBox.getChildren().add(new Text(command));
			HBox.getChildren().add(getRedoButton(command));
			VBox.getChildren().add(HBox);
		}
//		System.out.println("size: "+commandHistory.size());
	}
	
	public Button getRedoButton(String command) {
		Button button=new Button("Redo");
		button.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {  
		    	commandLine.setCommand(command);
		    	try {
					ui.updateDataIn();
					commandLine.setCommand("");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    }
		});
		return button;
	}
	
	public void show() {
		stage.setScene(scene);
        stage.show();
	}

}
