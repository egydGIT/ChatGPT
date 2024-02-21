package problemA;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            double x1 = sc.nextDouble();
            if (x1 == 0) break;
            double y1 = sc.nextDouble();
            double x2 = sc.nextDouble();
            double y2 = sc.nextDouble();
            double p = sc.nextDouble();

            double distance = Math.pow(Math.pow(Math.abs(x1 - x2), p) + Math.pow(Math.abs(y1 - y2), p), 1.0 / p);
            System.out.printf("%.10f\n", distance);
        }
        sc.close();
    }

}
