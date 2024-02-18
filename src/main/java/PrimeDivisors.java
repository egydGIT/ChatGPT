/*
Feladat:
Írj egy programot, amely bekér egy pozitív egész számot a felhasználótól,
majd meghatározza és kiírja az adott szám prím faktorait!

A prím faktorok egy adott szám pozitív osztói, amelyek önmaguk is prím számok.
Például, ha az adott szám 12, akkor a prím faktorai: 2 és 3, mert ezek a pozitív osztói, és mindkettő prím szám.

Példa:
Ha a felhasználó beírja a számot: 36
A programnak ki kell írnia az eredményt: 36 prím faktorai: 2, 3

Tipp:
Használj egy ciklust, amely végigmegy az 2-től a megadott számig, majd vizsgáld meg,
hogy az adott szám osztója-e a felhasználó által megadott számnak és prím-e!
 */

import java.util.ArrayList;
import java.util.List;

public class PrimeDivisors {

    public List<Integer> primFactors(int number) {
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            if (0 == number % i) {
                divisors.add(i);
            }
        }
        List<Integer> primDivisors = new ArrayList<>();
        for (Integer d : divisors) {
            if (isPrime(d)) {
                primDivisors.add(d);
            }
        }
        return primDivisors;
    }

    public boolean isPrime(Integer divisor) {
        int counter = 0;
        for (int i = 1; i <= divisor; i++) {
            if (divisor % i == 0) {
                counter++;
            }
        }
        return (counter == 2);
    }

    public static void main(String[] args) {
        PrimeDivisors pf = new PrimeDivisors();
        System.out.println(pf.primFactors(36));
    }
}
