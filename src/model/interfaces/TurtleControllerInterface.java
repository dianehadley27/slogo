package model.interfaces;

import java.util.Collection;

/**
 * Created by Brian on 11/1/2016.
 */
public interface TurtleControllerInterface {

    void removeTellTurtle (Object ID);

    void clearTellTurtles ();

    void addTurtle(Object ID);

    Collection<Object> getTurtlesToModify ();

    void addNestedAsk ();

    void subtractNestedAsk ();
}
