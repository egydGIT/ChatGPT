package loopsMath;/*
Feladat: Írj egy programot, amely bekér egy pozitív egész számot a felhasználótól,
majd meghatározza és kiírja az adott szám négyzetgyökét, ha az egy pozitív egész szám!

Egy pozitív egész szám négyzetgyöke az a szám, amelyet négyzetre emelve az eredeti számot kapjuk vissza.
Például, ha a felhasználó beírja a számot 25, akkor a programnak ki kell írnia az eredményt:
A négyzetgyök: 5, mivel 5 * 5 = 25.

Példa:
Ha a felhasználó beírja a számot: 36
A programnak ki kell írnia az eredményt: A négyzetgyök: 6

Tipp:
Használj egy megfelelő metódust, például a Math.sqrt() metódust, amely meghatározza a négyzetgyöket.
Ellenőrizd azt is, hogy a négyzetgyök eredménye egész szám-e, és csak akkor írd ki az eredményt, ha az egész szám.
 */

public class SquareRoot {

    public int square(double number) {
        double result = 0.0;
        result = Math.sqrt(number);
        int integerResult = (int) result;
        if(result == integerResult) {
            return integerResult;
        }
        return 0;
    }

    public int square2(double number) {
        double result = 0.0;
        result = Math.sqrt(number);
        if (Math.floor(result) == result) {
            return (int) result;
        }
        return 0;
    }

    public static void main(String[] args) {

        SquareRoot sr = new SquareRoot();
        System.out.println(sr.square(25));
        System.out.println(sr.square(25));
    }
}
