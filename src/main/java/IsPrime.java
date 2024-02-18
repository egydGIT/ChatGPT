/*
Feladat:
Írj egy programot, amely bekér egy pozitív egész számot a felhasználótól,
majd meghatározza és kiírja az adott szám prím-e vagy sem!

Egy prím szám olyan pozitív egész szám, amely csak 1-tel és önmagával osztható, és nincs más osztója.
Például, a 2, 3, 5, 7, 11 stb. prím számok, mivel nincsenek más osztóik, csak 1 és önmaguk.

Példa:
Ha a felhasználó beírja a számot: 17
A programnak ki kell írnia az eredményt: 17 egy prím szám.

Ha a felhasználó beírja a számot: 25
A programnak ki kell írnia az eredményt: 25 nem egy prím szám.

Tipp:
Használj egy ciklust, amely végigmegy az 2 és a megadott szám közötti számokon, majd vizsgáld meg,
hogy az adott szám osztható-e más számokkal, kivéve az 1 és önmagát!
 */

public class IsPrime {

    public static boolean isPrime(int number) {
        int counter = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                counter++;
            }
        }
        return counter == 2;
    }

    public static void writeToConsole(int number) {
        if (isPrime(number)) {
            System.out.println(number + " egy prím szám.");
        } else {
            System.out.println(number + " nem egy prím szám.");
        }
    }

    public static void main(String[] args) {
        writeToConsole(10);

    }
}
