package com.epam.geometry.core.core;

import com.epam.geometry.core.Verifying;
import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Triangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

public class VerifyingTest {
    private static final Logger LOGGER = LogManager.getLogger(VerifyingTest.class);

    @Test
    public void testIsTriangleWhenPointsNotOneLine() {
        //given
        Verifying verifying = new Verifying();
        Point firstPoint  = new Point(2.1,3.3);
        Point secondPoint = new Point(1.1,4.3);
        Point thirdPoint  = new Point(5.1,2.3);

        //when
        boolean result = verifying.isTriangle(firstPoint, secondPoint, thirdPoint);

        //then
        Assert.assertTrue(result);
    }

    @Test
    public void testIsTriangleWhenPointsOneLine() {
        //given
        Verifying verifying = new Verifying();
        Point firstPoint  = new Point(1,2);
        Point secondPoint = new Point(3,4);
        Point thirdPoint  = new Point(5,6);

        //when
        boolean result = verifying.isTriangle(firstPoint, secondPoint, thirdPoint);

        //then
        Assert.assertFalse(result);
    }

    @Test
    public void testIsEquilateralTriangleWhenSidesNotEqual() {
        //given
        Verifying verifying = new Verifying();
        Triangle triangle = new Triangle(new Point(1,2), new Point(-1,-2), new Point(1,-2));

        //when
        boolean result = verifying.isEquilateralTriangle(triangle);

        //then
        Assert.assertFalse(result);
    }

    @Test
    public void testIsEquilateralTriangleWhenSidesEqual() {
        //given
        Verifying verifying = new Verifying();
        Triangle triangle = new Triangle(new Point(-2,0), new Point(4,0), new Point(1,5.1962));

        //when
        boolean result = verifying.isEquilateralTriangle(triangle);

        //then
        Assert.assertTrue(result);
    }

    @Test
    public void testisIsoscelesTriangleWhenTwoSidesEqual() {
        //given
        Verifying verifying = new Verifying();
        Triangle triangle = new Triangle(new Point(1,2), new Point(2,3), new Point(3,2));

        //when
        boolean result = verifying.isIsoscelesTriangle(triangle);

        //then
        Assert.assertTrue(result);
    }

    @Test
    public void testisIsoscelesTriangleWhenTwoSidesNotEqual() {
        //given
        Verifying verifying = new Verifying();
        Triangle triangle = new Triangle(new Point(-1,2), new Point(2,3), new Point(3,2));

        //when
        boolean result = verifying.isIsoscelesTriangle(triangle);

        //then
        Assert.assertFalse(result);
    }

    @Test
    public void testisIsObtuseTriangleWhenObtuseAngle() {
        //given
        Verifying verifying = new Verifying();
        Triangle triangle = new Triangle(new Point(-2,2), new Point(2,3), new Point(3,2));

        //when
        boolean result = verifying.isObtuseTriangle(triangle);

        //then
       Assert.assertTrue(result);
    }

    @Test
    public void testisIsObtuseTriangleWhenAllAcureAngle() {
        //given
        Verifying verifying = new Verifying();
        Triangle triangle = new Triangle(new Point(1,2), new Point(2,3), new Point(3,2));

        //when
        boolean result = verifying.isObtuseTriangle(triangle);

        //then
        Assert.assertFalse(result);
    }
}
