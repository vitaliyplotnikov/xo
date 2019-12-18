package controllers;

import model.Field;
import model.Figure;
import model.exceptions.InvalidPointException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class WinnerControllerTest {

    @Test
    public void getWinnerHorizontal() throws InvalidPointException {
        for (int i = 0;i < 3;i++) {
            Field field = new Field(3);

            field.setFigure(new Point(i,0), Figure.X);
            field.setFigure(new Point(i,1), Figure.X);
            field.setFigure(new Point(i,2), Figure.X);

            WinnerController winnerController = new WinnerController();
            Figure winner = winnerController.getWinner(field);

            assertEquals(Figure.X, winner);
        }
    }

    @Test
    public void getWinnerHorizontalWhenNoWinner() throws InvalidPointException {
        for (int i = 0;i < 3;i++) {
            Field field = new Field(3);

            field.setFigure(new Point(i,0), Figure.X);
            field.setFigure(new Point(i,1), Figure.X);
            field.setFigure(new Point(i,2), Figure.O);

            WinnerController winnerController = new WinnerController();
            Figure winner = winnerController.getWinner(field);

            assertNull(winner);
        }
    }

    @Test
    public void getWinnerVertical() throws InvalidPointException {
        for (int i = 1;i < 3;i++) {
            Field field = new Field(3);

            field.setFigure(new Point(0,i), Figure.X);
            field.setFigure(new Point(1,i), Figure.X);
            field.setFigure(new Point(2,i), Figure.X);

            WinnerController winnerController = new WinnerController();
            Figure winner = winnerController.getWinner(field);

            assertEquals(Figure.X, winner);
        }
    }

    @Test
    public void getWinnerVerticalWhenNoWinner() throws InvalidPointException {
        for (int i = 1;i < 3;i++) {
            Field field = new Field(3);

            field.setFigure(new Point(0,i), Figure.X);
            field.setFigure(new Point(1,i), Figure.X);
            field.setFigure(new Point(2,i), Figure.O);

            WinnerController winnerController = new WinnerController();
            Figure winner = winnerController.getWinner(field);

            assertNull(winner);
        }
    }

    @Test
    public void getWinnerDagonal1() throws InvalidPointException {
            Field field = new Field(3);

            field.setFigure(new Point(0,0), Figure.X);
            field.setFigure(new Point(1,1), Figure.X);
            field.setFigure(new Point(2,2), Figure.X);

            WinnerController winnerController = new WinnerController();
            Figure winner = winnerController.getWinner(field);

            assertEquals(Figure.X,winner);
    }

    @Test
    public void getWinnerDagonal1WhenNoWinner() throws InvalidPointException {
            Field field = new Field(3);

            field.setFigure(new Point(0,0), Figure.X);
            field.setFigure(new Point(1,1), Figure.X);
            field.setFigure(new Point(2,2), Figure.O);

            WinnerController winnerController = new WinnerController();
            Figure winner = winnerController.getWinner(field);

            assertNull(winner);
    }

    @Test
    public void getWinnerDagonal2WhenNoWinner() throws InvalidPointException {
            Field field = new Field(3);

            field.setFigure(new Point(0,2), Figure.X);
            field.setFigure(new Point(1,1), Figure.X);
            field.setFigure(new Point(2,0), Figure.O);

            WinnerController winnerController = new WinnerController();
            Figure winner = winnerController.getWinner(field);

            assertNull(winner);
    }

    @Test
    public void getWinnerDagonal2() throws InvalidPointException {
            Field field = new Field(3);

            field.setFigure(new Point(0,2), Figure.X);
            field.setFigure(new Point(1,1), Figure.X);
            field.setFigure(new Point(2,0), Figure.X);

            WinnerController winnerController = new WinnerController();
            Figure winner = winnerController.getWinner(field);

            assertEquals(Figure.X, winner);
    }
}