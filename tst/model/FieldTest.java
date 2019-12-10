package model;

import model.exceptions.AlreadyOccupiedException;
import model.exceptions.InvalidPointException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class FieldTest {

    @Test
    public void getSize() {
        final Field field = new Field(3);

        assertEquals(3,field.getSize());

    }

    @Test
    public void setFigure() throws AlreadyOccupiedException, InvalidPointException {
        final Field field = new Field(3);
        final Point inputPoint = new Point(0,0);
        final Figure inputFigure = Figure.O;

        field.setFigure(inputPoint,inputFigure);

        final Figure actualFigure = field.getFigure(inputPoint);

        assertEquals(inputFigure,actualFigure);
    }

    @Test
    public void getFigureWhenXIsLessThenZero() throws AlreadyOccupiedException, InvalidPointException {
        final Field field = new Field(3);
        final Point inputPoint = new Point(-1,0);

        try{
            field.getFigure(inputPoint);
            fail();
        }catch(InvalidPointException e) {}
    }
    @Test
    public void getFigureWhenYIsLessThenZero() throws AlreadyOccupiedException, InvalidPointException {
        final Field field = new Field(3);
        final Point inputPoint = new Point(0,-1);

        try{
            field.getFigure(inputPoint);
            fail();
        }catch(InvalidPointException e) {}
    }
    @Test
    public void getFigureWhenXIsMoreThenSize() throws AlreadyOccupiedException, InvalidPointException {
        final Field field = new Field(3);
        final Point inputPoint = new Point(4,0);

        try{
            field.getFigure(inputPoint);
            fail();
        }catch(InvalidPointException e) {}
    }
    @Test
    public void getFigureWhenYIsMoreThenSize() throws AlreadyOccupiedException, InvalidPointException {
        final Field field = new Field(3);
        final Point inputPoint = new Point(0,4);

        try{
            field.getFigure(inputPoint);
            fail();
        }catch(InvalidPointException e) {}
    }
}