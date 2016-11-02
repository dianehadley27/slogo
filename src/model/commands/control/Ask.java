package model.commands.control;

import controller.CommandManager;
import controller.Node;
import model.abstractcommands.ControlCommand;
import model.interfaces.ControlCommandInterface;

/**
 * Created by Soravit on 10/31/2016.
 */
public class Ask extends ControlCommand{

    public Ask(Node root, CommandManager commandManager, ControlCommandInterface model) {
        super(root, commandManager, model);
    }

    @Override
    public double execute() throws Exception {
        Node turtleRoot = getRoot().getChildren().get(0);
        Node commandRoot = getRoot().getChildren().get(1);
        double ret = 0;
        getModel().addNestedAsk();
        for(int i = 0 ; i < turtleRoot.getChildren().size(); i++){
            getModel().addTurtle(Double.parseDouble(turtleRoot.getChildren().get(i).getValue()));
        }
        for(int j = 0 ; j < commandRoot.getChildren().size(); j++) {
            ret = executeTree(commandRoot.getChildren().get(j));
        }
        getModel().subtractNestedAsk();
        return ret;
    }
}
