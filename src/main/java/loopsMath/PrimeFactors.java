/*
Feladat:
Írj egy programot, amely bekér egy pozitív egész számot a felhasználótól,
majd meghatározza és kiírja az adott szám prím faktorait és a faktorizált alakját!

A prím faktorizáció során az adott számot felbontjuk prím faktorok szorzataként.
Például, ha a felhasználó beírja a számot 24, akkor a programnak meg kell határoznia a prím faktorokat (2 és 3),
majd ki kell írnia az eredményt a következő módon: 24 = 2 * 2 * 2 * 3.

Példa:
Ha a felhasználó beírja a számot: 36
A programnak ki kell írnia az eredményt: 36 = 2 * 2 * 3 * 3

Tipp:
Használj egy ciklust, amely végigmegy az 2-től a megadott számig, majd vizsgáld meg,
hogy az adott szám osztója-e a felhasználó által megadott számnak és prím-e! Ha prím faktort találsz,
add hozzá az eredmény sztringhez és csökkentsd az eredeti számot a faktorral.
 */
package loopsMath;
import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {

    public List<Integer> primeFactors(int number) {
        List<Integer> primes = new ArrayList<>();
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
        PrimeFactors pf = new PrimeFactors();
        System.out.println(pf.primeFactors(36));

        // [2, 2, 3, 3]
    }
}
