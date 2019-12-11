package controllers;

import model.Field;
import model.Figure;
import model.exceptions.InvalidPointException;

import java.awt.*;

public class WinnerController {

    public Figure getWinner(final Field field) throws InvalidPointException {

        if (getWinnerHorizontal(field) != null) {
            return getWinnerHorizontal(field);
        }
        if (getWinnerVertical(field) != null) {
            return getWinnerVertical(field);
        }
        if (getWinnerRightDiagonally(field) != null) {
            return getWinnerRightDiagonally(field);
        }
        if (getWinnerLeftDiagonally(field) != null) {
            return getWinnerLeftDiagonally(field);
        }

        return null;

    }

    private Figure getWinnerHorizontal(final Field field) throws InvalidPointException {
        Point point = new Point();
        int countOfX = 0;
        int countOfO = 0;

        for (int i = 0;i < field.getSize();i++) {
            point.x = i;

            for (int j = 0;j < field.getSize();j++) {
                point.y = j;
                if (field.getFigure(point).equals(Figure.X)) {
                    countOfX++;
                }

                if (field.getFigure(point).equals(Figure.O)) {
                    countOfO++;
                }
            }

            if (countOfX == field.getSize()) {
                return Figure.X;
            }else{
                countOfX = 0;
            }
            if (countOfO == field.getSize()) {
                return Figure.O;
            }else{
                countOfO = 0;
            }

        }
        return null;
    }

    private Figure getWinnerVertical(final Field field) throws InvalidPointException {
        Point point = new Point();
        int countOfX = 0;
        int countOfO = 0;

        for (int i = 0;i < field.getSize();i++) {
            point.y = i;

            for (int j = 0;j < field.getSize();j++) {
                point.x = j;
                if (field.getFigure(point).equals(Figure.X)) {
                    countOfX++;
                }

                if (field.getFigure(point).equals(Figure.O)) {
                    countOfO++;
                }
            }

            if (countOfX == field.getSize()) {
                return Figure.X;
            }else{
                countOfX = 0;
            }
            if (countOfO == field.getSize()) {
                return Figure.O;
            }else{
                countOfO = 0;
            }

        }
        return null;
    }

    private Figure getWinnerLeftDiagonally(final Field field) throws InvalidPointException {
        Point point = new Point();
        int countOfX = 0;
        int countOfO = 0;

        for (int i = 0;i < field.getSize();i++) {
            point.x = i;
            point.y = i;

            if (field.getFigure(point).equals(Figure.X)) {
                countOfX++;
            }

            if (field.getFigure(point).equals(Figure.O)) {
                countOfO++;
            }
        }

        if (countOfX == field.getSize()) {
            return Figure.X;
        }

        if (countOfO == field.getSize()) {
            return Figure.O;
        }

        return null;
    }

    private Figure getWinnerRightDiagonally(final Field field) throws InvalidPointException {
        Point point = new Point();
        int countOfX = 0;
        int countOfO = 0;

        for (int i = field.getSize()-1,j = 0;i >= 0;i--,j++) {
            point.x = j;
            point.y = i;

            if (field.getFigure(point).equals(Figure.X)) {
                countOfX++;
            }

            if (field.getFigure(point).equals(Figure.O)) {
                countOfO++;
            }
        }

        if (countOfX == field.getSize()) {
            return Figure.X;
        }

        if (countOfO == field.getSize()) {
            return Figure.O;
        }

        return null;
    }

    public Figure getWinner2(final Field field) throws InvalidPointException {
        for (int i = 0;i < field.getSize();i++){
            if (check(field, new Point(i,0), point -> new Point(point.x,point.y + 1)))
                return field.getFigure(new Point(i,0));
        }

        for (int i = 0;i < field.getSize();i++){
            if (check(field, new Point(0,i), point -> new Point(point.x + 1,point.y)))
                return field.getFigure(new Point(i,0));
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
            nextFigure = field.getFigure(nextPoint);
        } catch (InvalidPointException e) {
            return true;
        }

        if (currnetFigure == null) return false;
        if (currnetFigure != nextFigure) return false;

        return check(field,nextPoint,pointChanger);
    }


    public interface IPointChanger {
        public Point next(final Point point);
    }

}
