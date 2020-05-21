import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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
}
