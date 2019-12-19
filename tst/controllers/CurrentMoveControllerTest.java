package controllers;

import model.Field;
import model.Figure;
import model.exceptions.InvalidPointException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class CurrentMoveControllerTest {

    @Test
    public void currentMove() throws InvalidPointException {
        Field field = new Field(3);
        field.setFigure(new Point(0,0), Figure.X);
        field.setFigure(new Point(0,2), Figure.X);
        field.setFigure(new Point(1,0), Figure.O);
        field.setFigure(new Point(1,1), Figure.O);

        CurrentMoveController currentMoveController = new CurrentMoveController();
        Figure currentFigure = currentMoveController.currentMove(field);

        assertEquals(Figure.X,currentFigure);
    }
    @Test
    public void currentMoveBeforeFirstStep() throws InvalidPointException {
        Field field = new Field(3);

        CurrentMoveController currentMoveController = new CurrentMoveController();
        Figure currentFigure = currentMoveController.currentMove(field);

        assertEquals(Figure.X,currentFigure);
    }

    @Test
    public void currentMoveLastStep() throws InvalidPointException {
        Field field = new Field(3);

        field.setFigure(new Point(0,0), Figure.X);
        field.setFigure(new Point(0,1), Figure.O);
        field.setFigure(new Point(0,2), Figure.X);
        field.setFigure(new Point(1,0), Figure.O);
        field.setFigure(new Point(1,1), Figure.X);
        field.setFigure(new Point(1,2), Figure.O);
        field.setFigure(new Point(2,0), Figure.X);
        field.setFigure(new Point(2,1), Figure.O);
//        field.setFigure(new Point(2,2), Figure.X);

        CurrentMoveController currentMoveController = new CurrentMoveController();
        Figure currentFigure = currentMoveController.currentMove(field);

        assertEquals(Figure.X,currentFigure);
    }

    @Test
    public void currentMoveAllFieldsAreOccupied() throws InvalidPointException {
        Field field = new Field(3);

        field.setFigure(new Point(0,0), Figure.X);
        field.setFigure(new Point(0,1), Figure.O);
        field.setFigure(new Point(0,2), Figure.X);
        field.setFigure(new Point(1,0), Figure.O);
        field.setFigure(new Point(1,1), Figure.X);
        field.setFigure(new Point(1,2), Figure.O);
        field.setFigure(new Point(2,0), Figure.X);
        field.setFigure(new Point(2,1), Figure.O);
        field.setFigure(new Point(2,2), Figure.X);

        CurrentMoveController currentMoveController = new CurrentMoveController();
        Figure currentFigure = currentMoveController.currentMove(field);

        assertNull(currentFigure);
    }


}