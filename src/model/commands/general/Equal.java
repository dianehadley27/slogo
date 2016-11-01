package model.commands.general;

import model.abstractcommands.MathBoolCommand;
import model.interfaces.EmptyInterface;

public class Equal extends MathBoolCommand {

    public Equal (double[] parameters, EmptyInterface model) {
        super(parameters, model);
    }

    @Override
    public double execute () {
        double first = this.getParams()[0];
        for (double x : this.getParams()){
            if (x != first){
                return 0;
            }
        }
        return 1;
    }
}