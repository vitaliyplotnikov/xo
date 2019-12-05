package controllers;

import model.Field;
import model.Figure;
import model.exceptions.AlreadyOccupiedException;
import model.exceptions.InvalidPointException;

import java.awt.*;

public class MoveContoller {

    public void applyFigure(final Field field,
                            final Figure figure,
                            final Point point) throws AlreadyOccupiedException,
                                                      InvalidPointException {

        if (field.getFigure(point) != null) {
            throw new AlreadyOccupiedException();
        }
        field.setFigure(point,figure);
    }
}
