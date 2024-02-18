/*
Feladat:
Írj egy programot, amely bekér egy pozitív egész számot a felhasználótól,
majd meghatározza és kiírja az adott szám prímtényezős felbontását!

A prímtényezős felbontás egy szám összeállítása prímszámok szorzataként.
Például, ha a felhasználó beírja a számot 24, akkor a programnak ki kell írnia az eredményt:
A 24 prímtényezős felbontása: 2 * 2 * 2 * 3.

Példa:
Ha a felhasználó beírja a számot: 56
A programnak ki kell írnia az eredményt: A 56 prímtényezős felbontása: 2 * 2 * 2 * 7.

Tipp:
Az algoritmus hasonló lesz, mint az LNKO feladatban alkalmazott prímtényezős felbontás.
Vizsgáld meg, hogy hány prímszám osztója az adott számnak, majd írd ki az osztókat és szorozd össze őket.
 */

public class PrimDivisors2 {

    public StringBuilder printPrimDivisors(int number) {
        StringBuilder result = new StringBuilder();
        for(int i = 2; i <= number; i++) {
            if(number % i == 0) {
                if (number == i) {
                    result = result.append(i);
                }
                else {
                    result = result.append(i + " * ");
                }
                number = number / i;
                i = 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        PrimDivisors2 pd = new PrimDivisors2();
        System.out.println(pd.printPrimDivisors(24));
    }
}
