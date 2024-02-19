package loopsMath;/*
Feladat:
Írj egy programot, amely bekér egy pozitív egész számot a felhasználótól,
majd meghatározza és kiírja az adott szám legnagyobb közös osztóját (LNKO)!

A legnagyobb közös osztó (LNKO) két vagy több szám közös osztója, amely a lehető legnagyobb. Például,
ha a felhasználó beírja a számokat 12 és 18, akkor a programnak meg kell határoznia az LNKO-t,
ami 6, mivel ez a lehető legnagyobb közös osztó a két szám között.

Tipp:
Használj egy ciklust, amely végigmegy a 2-től a kisebbik számig, majd ellenőrizd,
hogy az adott szám osztója-e mindkét számnak. Ha az adott szám osztója mindkét számnak, 
tárold el az aktuális értékét, majd folytasd a ciklust az összes kisebb számra.
 */

import java.util.ArrayList;
import java.util.List;

public class Lnko {

    public int lnko(int first, int second) {
        int result = 0;
        for (int i = 1; i <= first && i <= second; i++) {
            if ((first % i == 0) && (second % i == 0)) {
                result = i;
            }
        }
        return result;
    }

    public int countGreatestCommonDivisor(int a, int b) {
        List<Integer> divisorsA = new ArrayList<>();
        List<Integer> divisorsB = new ArrayList<>();
        for (int i = 2; i <= a; i++) {      // a szám prímtényezős felbontása
            if (a % i == 0) {
                divisorsA.add(i);
                a = a / i;
                i = 1;
            }
        }
//        System.out.println(divisorsA);

        for (int i = 2; i <= b; i++) {      // b szám prímtényezős felbontása
            if (b % i == 0) {
                divisorsB.add(i);
                b = b / i;
                i = 1;
            }
        }
//        System.out.println(divisorsB);

        List<Integer> intersection = new ArrayList<>();            // két halmaz metszete
        for (int i = 0; i < divisorsA.size(); i++) {
            if (divisorsB.contains(divisorsA.get(i))) {
                intersection.add(divisorsA.get(i));
                divisorsB.remove(divisorsA.get(i));
            }
        }
//        System.out.println(intersection);

        int result = 0;                     // metszet elemeinek szorzata
        if (intersection.size() != 0) {
            int first = intersection.get(0);
            for (int i = 1; i < intersection.size(); i++) {
                result = first * intersection.get(i);
//            System.out.println(result);
                first = result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Lnko lnko = new Lnko();
        System.out.println(lnko.lnko(36, 48));
        System.out.println(lnko.countGreatestCommonDivisor(24, 18));
    }

}