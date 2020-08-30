import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;


public class NBody {

    /** Returns the radius of the inputed universe file. */
    public static double readRadius(String filePath) {
        try {
            return Double.parseDouble(
                    Files.readAllLines(Paths.get(filePath)).get(1));
        } catch(IOException e) {
            return 0;
        }
    }

    /** Given a String FILEPATH, returns an array of planets inside the file.
     * public Planet(double xP, double yP, double xV, double yV, double m,
     *                   String img)
     */
    public static Planet[] readPlanets(String filePath) {
        In fileContent = new In(filePath);

        int numBodies = fileContent.readInt();

        /** Advances the iterator past line 1. */
        fileContent.readDouble();

        Planet[] bodyArray = new Planet[numBodies];

        for (int i = 0; i < numBodies; i+= 1) {
            double xxPos = fileContent.readDouble();
            double yyPos = fileContent.readDouble();
            double xxVel = fileContent.readDouble();
            double yyVel = fileContent.readDouble();
            double mass = fileContent.readDouble();
            String imgFileName = fileContent.readString();
            bodyArray[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass,
                                    imgFileName);
        }
        return bodyArray;
    }

    /** Stores the first two command-line arguments respectively as doubles
     * T  and DT and the third argument as a String FILENAME.
     */
    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String fileName = args[2];
        Planet[] planets = readPlanets(fileName);
        double radius = readRadius(fileName);

        StdDraw.setScale(-radius, radius);
        StdDraw.clear();

        StdDraw.picture(-radius, radius, "images/starfield.jpg");
        StdDraw.picture(radius, radius, "images/starfield.jpg");
        StdDraw.picture(-radius, -radius, "images/starfield.jpg");
        StdDraw.picture(radius, -radius, "images/starfield.jpg");

        for (Planet p: planets) {
            p.draw();
        }

        StdDraw.show();
        StdDraw.enableDoubleBuffering();

        for (int t = 0; t < T; t += dt) {
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];

            for (int i = 0; i < planets.length; i++) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }

            for (int j = 0; j < planets.length; j++) {
                planets[j].update(dt, xForces[j], yForces[j]);
            }

            StdDraw.setScale(-radius, radius);
            StdDraw.clear();

            StdDraw.picture(-radius, radius, "images/starfield.jpg");
            StdDraw.picture(radius, radius, "images/starfield.jpg");
            StdDraw.picture(-radius, -radius, "images/starfield.jpg");
            StdDraw.picture(radius, -radius, "images/starfield.jpg");

            for (Planet p: planets) {
                StdDraw.picture(p.xxPos, p.yyPos, "images/" + p.imgFileName);
            }

            StdDraw.show();
            StdDraw.pause(10);
        }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                          planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                          planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    }
}
