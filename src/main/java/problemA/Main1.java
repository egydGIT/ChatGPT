package problemA;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Locale;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try (Scanner sc = new Scanner(Path.of("src/main/java/problemA/input.txt"))) {
            // try-with-resources:  try blokkot elhagyva a Java lezárja a Scanner-t, nem kell sc.close(); metódus
            while (sc.hasNext()) {
                double x1 = sc.nextDouble();
                if (x1 == 0) break;
                double y1 = sc.nextDouble();
                double x2 = sc.nextDouble();
                double y2 = sc.nextDouble();
                double p = sc.nextDouble();

                double distance = Math.pow(Math.pow(Math.abs(x1 - x2), p) + Math.pow(Math.abs(y1 - y2), p), 1.0 / p);
                // (|x1−x2|p+|y1−y2|p)1/p
                System.out.printf("%.10f\n", distance);
                // %f = lebegőpontos szám
                // .10 = tizedespont után 10 számjegy
                // \n = új sor
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
