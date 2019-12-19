package controllers;

import model.Field;
import model.Figure;
import model.exceptions.InvalidPointException;

import java.awt.*;

public class CurrentMoveController {
    public Figure currentMove(final Field field) throws InvalidPointException {
        int count = 0;

        for (int i = 0;i < field.getSize();i++) {
            for (int j = 0;j < field.getSize();j++) {
                if (field.getFigure(new Point(i,j)) != null) {
                    count++;
                }
            }
        }

        if (count == (field.getSize() * field.getSize())) return null;

        if (count % 2 == 0) {
            return Figure.X;
        }else{
            return Figure.O;
        }
    }
}
