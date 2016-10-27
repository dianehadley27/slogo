package model.commands;
import controller.Node;
import controller.Interpreter;
import model.Model;
import model.WorkspaceState;
import model.abstractcommands.ControlCommand;

/**
 * Created by Soravit on 10/23/2016.
 */
public class For extends ControlCommand{

	private String variable;
	private double start;
	private double end;
	private double increment;

	public For(Node root, Interpreter parser, Model model) throws Exception{
		super(root,parser,model);
		Node commandRoot = getRoot().getChildren().get(0);
		variable = commandRoot.getChildren().get(0).getValue();
		start = getParser().executeTree(commandRoot.getChildren().get(1));
		end = getParser().executeTree(commandRoot.getChildren().get(2));
		increment = getParser().executeTree(commandRoot.getChildren().get(3));
	}

	@Override
	public double execute() throws Exception {
		double ret = 0;
		Node commandRoot = getRoot().getChildren().get(1);
        WorkspaceState workspace = this.getModel().getWorkspace();
        workspace.addVariable(variable, start);
        for(double i = start; i < end; i += increment){
        	for(double j = 0; j < commandRoot.getChildren().size(); j++){
        	ret = getParser().executeTree(commandRoot.getChildren().get((int)j));
        	workspace.addVariable(variable, i);
        	}
        }
        return ret;
	}
}
