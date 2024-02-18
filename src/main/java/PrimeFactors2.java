/*
Feladat:
Írj egy programot, amely bekér egy pozitív egész számot a felhasználótól,
majd meghatározza és kiírja az adott szám prím faktorait!

A prím faktorok azok a prím számok, amelyek szorzataként az adott számot felírhatjuk.
Például, ha a felhasználó beírja a számot 24, akkor a programnak ki kell írnia az eredményt:
Prím faktorok: 2, 3

Példa:
Ha a felhasználó beírja a számot: 56
A programnak ki kell írnia az eredményt:
Prím faktorok: 2, 7

Tipp:
Használj egy ciklust a prím faktorok meghatározásához.
Vizsgáld meg, hogy a szám osztható-e a ciklus aktuális értékével.
Ha osztható, akkor a ciklusban folyamatosan oszd el a számot és tárolj el minden osztót.
 */

import java.util.HashSet;

public class PrimeFactors2 {

    public HashSet<Integer> primeFactors(int number) {
        HashSet<Integer> primes = new HashSet<>();
        for (int i = 1; i <= number; i++) {
            if (isPrime(i) && (number % i == 0)) {
                primes.add(i);
                number /= i;
                i = 1;
            }
        }
        return primes;
    }

    public boolean isPrime(int number) {
        int counter = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                counter++;
            }
        }
        return counter == 2;
    }

    public static void main(String[] args) {
        PrimeFactors2 pf = new PrimeFactors2();
        System.out.println(pf.primeFactors(56));

        // [2, 7]
    }
}
