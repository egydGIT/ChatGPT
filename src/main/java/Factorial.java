/*
Feladat:
Írj egy programot, amely bekér egy pozitív egész számot a felhasználótól,
majd kiszámítja és kiírja az adott szám faktoriálisát!

A faktoriális egy szám minden pozitív egész számra értelmezett faktoraiból áll,
és jelölése n! Az n! értéke az n számot az 1-től n-ig terjedő egész számok szorzataként adja meg.

Példa:
Ha a felhasználó beírja a számot: 5
A programnak ki kell írnia az eredményt: 5! = 120

Tipp:
Használj egy ciklust, amely végigmegy az 1-től a megadott számig,
majd kiszámítja az egész számok szorzatát a faktoriális meghatározásához!
 */

public class Factorial {

    public int factorial(int number) {
        int result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        Factorial fr = new Factorial();
        System.out.println(fr.factorial(5));
    }
}
