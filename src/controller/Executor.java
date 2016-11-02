package controller;

import error.InvalidCommandException;
import model.Model;
import model.abstractcommands.CommandInterface;
import model.interfaces.EmptyInterface;
import model.interfaces.TurtleCommandInterface;

import java.lang.reflect.Constructor;

/**
 * Created by Soravit on 10/29/2016.
 */
public abstract class Executor {

    public static final String GENERAL_COMMAND_PACKAGE = "model.commands.general.";

    private String commandPackage = GENERAL_COMMAND_PACKAGE;
    private Class commandInterface = EmptyInterface.class;

    public double execute(Node root, CommandManager commandManager, Model model) throws InvalidCommandException{
        try{
            Node paramRoot = root;
            double[] doubles;
            if(root.getChildren().size() > 0 && root.getChildren().get(0).getValue().equals(Interpreter.CONTROL_STRUCTURES)){
                paramRoot = root.getChildren().get(0);
                doubles = new double[paramRoot.getChildren().size()];
            }else{
                doubles = new double[root.getChildren().size()];
            }
            for (int i = 0; i < paramRoot.getChildren().size(); i++) {
                Node currNode = paramRoot.getChildren().get(i);
                doubles[i] = commandManager.executeTree(currNode);
            }
            Class<?> command = Class.forName(commandPackage + root.getValue());
            Constructor<?> constructor = command.getDeclaredConstructor(double[].class, commandInterface);
            Object t = constructor.newInstance(doubles, model);
            double x = commandManager.executeCommand((CommandInterface) t);
            model.updateConsoleReturn(x);
            model.updateView();
            return x;
        }catch(Exception exception){
            exception.printStackTrace();
            throw new InvalidCommandException(root.getValue());
        }
    }

    public void setPackage(String commandPackage){
        this.commandPackage = commandPackage;
    }

    public String getPackage(){
        return commandPackage;
    }

    public void setCommandInterface(Class commandInterface){
        this.commandInterface = commandInterface;
    }
}
