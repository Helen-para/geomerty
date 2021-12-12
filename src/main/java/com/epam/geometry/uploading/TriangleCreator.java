package com.epam.geometry.uploading;

import com.epam.geometry.core.Verifying;
import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Triangle;
import com.epam.geometry.service.HandledException;

import java.util.Optional;

public class TriangleCreator {
    private final static String DELEMITER_POINTS = " ";
    private final static String DELEMITER_COORDINATE = ";";
    private final static String REGEX_POINTS = "^\\(|\\)$";
    private final Verifying verifying;

    public TriangleCreator(Verifying verifying) {
        this.verifying = verifying;
    }


    public Optional<Triangle> createObject(String line) throws HandledException {
        //Optional<Triangle> triangle = Optional.empty();
        Point[] arrayVertices = parseLine(line);
        Point firstVertex  = arrayVertices[0];
        Point secondVertex = arrayVertices[1];
        Point thirdVertex  = arrayVertices[2];
        if (verifying.isTriangle(firstVertex, secondVertex, thirdVertex)) {
            Triangle triangle = new Triangle(firstVertex, secondVertex, thirdVertex);

            return Optional.of(triangle);
        }
        else {
            return Optional.empty();
            //throw new HandledException("Object not created! The line with vertices + " + line + " is not a triangle.");
        }

    }

    private Point[] parseLine(String line) {
        String[] arrayStrings = line.split(DELEMITER_POINTS);
        Point[] arrayVertices = new Point[3];
        for (int i=0; i<arrayStrings.length; i++) {
            String stringPoint = arrayStrings[i].replaceAll(REGEX_POINTS, "");
            stringPoint = stringPoint.replaceAll("\\s+", "");
            String[] coordinates = stringPoint.split(DELEMITER_COORDINATE);
            double coordinateX = Double.parseDouble(coordinates[0]);
            double coordinateY = Double.parseDouble(coordinates[1]);
            arrayVertices[i] = new Point(coordinateX, coordinateY);
        }

        return arrayVertices;
    }
}
