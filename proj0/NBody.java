import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

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
     *                   String img) */
    public static Planet[] readPlanets(String filePath) {
        try {
            Planet[] planetArray;
            int lineNumber = 2;
            String fileLine = Files.readAllLines(Paths.get(filePath)).get(lineNumber);
            planetArray = new Planet[5];
            HashMap<String, Planet> planetHashMap = new HashMap<String, Planet>();
            HashSet<Planet> planetSet = new HashSet<>();

            while (fileLine != null && isNumeric((fileLine.trim().split(
                    "\\s+")[0]))) {

                fileLine = fileLine.trim();
                System.out.println(fileLine);
                String[] planetInfo = fileLine.split("\\s+");
                System.out.println(Arrays.toString(planetInfo));
                Planet p = new Planet(Double.parseDouble(planetInfo[0]),
                                      Double.parseDouble(planetInfo[1]),
                                      Double.parseDouble(planetInfo[2]),
                                      Double.parseDouble(planetInfo[3]),
                                      Double.parseDouble(planetInfo[4]),
                                      planetInfo[5]);
                if (!planetSet.contains(p)) {
                    planetSet.add(p);
                }
                for (Planet pep: planetSet) {
                    System.out.println(pep.imgFileName);

                    // need to debug this. Puts venus 5x.
                    /**
                    venus.gif
                    venus.gif
                    venus.gif
                    venus.gif
                    venus.gif
                     */

                }
                fileLine =
                        Files.readAllLines(Paths.get(filePath)).get(lineNumber++);
            }
            int i = 0;
            for (Planet p: planetHashMap.values()) {
                planetArray[i] = p;
                i++;
            }
            return planetArray;
        } catch (IOException e) {
            return null;
        }
    }

    /** Takes a String S and returns whether it is a number. */
    public static boolean isNumeric(String s) {
        if (s == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(s);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    /** Stores the first two command-line arguments respectively as doubles
     * T  and DT and the third argument as a String FILENAME.
     */
    public static void main(String[] args) {
        //String commandLine = args.trim();
        //String[] commands = commandLine.split("\\s+");
        //assert (isNumeric(commands[0]) && isNumeric(commands[1]));
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
            StdDraw.picture(p.xxPos, p.yyPos, "images/" + p.imgFileName);
        }
        StdDraw.show();
    }
}
