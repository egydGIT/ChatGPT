/*
Feladat:
Írj egy programot, amely bekér egy pozitív egész számot a felhasználótól,
majd meghatározza és kiírja az adott szám osztóit!

Példa:
Ha a felhasználó beírja a számot: 12
A programnak ki kell írnia az eredményt: 1, 2, 3, 4, 6, 12

Tipp:
Használj egy ciklust, amely végigmegy az 1 és a megadott szám közötti számokon, majd vizsgáld meg,
hogy az adott szám osztója-e a felhasználó által megadott számnak!
 */
package loopsMath;
import java.util.ArrayList;
import java.util.List;

public class DivisorFinder {

    public List<Integer> divisorFinder(int number) {
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            if (0 == number % i) {
                divisors.add(i);
            }
        }
        return divisors;
    }

    public static void main(String[] args) {

        DivisorFinder dv = new DivisorFinder();
        System.out.println(dv.divisorFinder(12));
    }
}
