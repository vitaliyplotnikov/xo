package controllers;

import model.Field;
import model.Figure;
import model.exceptions.InvalidPointException;

import java.awt.*;

public class WinnerController {

    public Figure getWinner(final Field field) throws InvalidPointException {
        for (int i = 0;i < field.getSize();i++){
            if (check(field, new Point(i,0), point -> new Point(point.x,point.y + 1)))
                return field.getFigure(new Point(i,0));
        }

        for (int i = 0;i < field.getSize();i++){
            if (check(field, new Point(0,i), point -> new Point(point.x + 1,point.y)))
                return field.getFigure(new Point(0,i));
        }

        if (check(field, new Point(0,0), point -> new Point(point.x + 1,point.y + 1)))
            return field.getFigure(new Point(0,0));

        if (check(field, new Point(0,2), point -> new Point(point.x + 1,point.y - 1)))
            return field.getFigure(new Point(0,2));

        return null;
    }

    private boolean check(Field field, Point currentPoint, IPointChanger pointChanger) {
        Figure currnetFigure;
        Figure nextFigure;
        Point nextPoint = pointChanger.next(currentPoint);
        try {
            currnetFigure = field.getFigure(currentPoint);

            if (currnetFigure == null) return false;

            nextFigure = field.getFigure(nextPoint);
        } catch (InvalidPointException e) {
            return true;
        }


        if (currnetFigure != nextFigure) return false;

        return check(field,nextPoint,pointChanger);
    }


    public interface IPointChanger {
        public Point next(final Point point);
    }

}
