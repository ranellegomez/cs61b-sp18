import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
            int planetCount = 0;
            String fileLine = Files.readAllLines(Paths.get(filePath)).get(lineNumber);
            planetArray = new Planet[5];
            HashMap<String, Planet> planetHashMap = new HashMap<>();

            while (fileLine != null && isNumeric((fileLine.trim().split(
                    "\\s+")[0]))) {

                fileLine = fileLine.trim();
                String[] planetInfo = fileLine.split("\\s+");
                Planet p = new Planet(Double.parseDouble(planetInfo[0]),
                                      Double.parseDouble(planetInfo[1]),
                                      Double.parseDouble(planetInfo[2]),
                                      Double.parseDouble(planetInfo[3]),
                                      Double.parseDouble(planetInfo[4]),
                                      planetInfo[5]);
                planetHashMap.put(planetInfo[5], p);
                fileLine =
                        Files.readAllLines(Paths.get(filePath)).get(lineNumber++);
                planetCount++;
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
}
