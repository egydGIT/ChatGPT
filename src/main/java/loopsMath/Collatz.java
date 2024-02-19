package loopsMath;/*
Feladat:
Írj egy programot, amely bekér egy pozitív egész számot a felhasználótól,
majd meghatározza és kiírja az adott számhoz tartozó loopsMath.Collatz-sorozat hosszát és a sorozat elemeit!

A loopsMath.Collatz-sorozatot a következő módon hozzuk létre:

Ha a szám páros, akkor a következő szám a szám felosztva 2-vel.
Ha a szám páratlan, akkor a következő szám a szám szorzata 3-mal, majd hozzáadva 1.
A sorozat a 1-nél végződik. Például, ha a felhasználó beírja a számot 6, akkor a programnak ki kell írnia az eredményt:
loopsMath.Collatz-sorozat hossza: 9
loopsMath.Collatz-sorozat elemei: 6, 3, 10, 5, 16, 8, 4, 2, 1

Példa:
Ha a felhasználó beírja a számot: 27
A programnak ki kell írnia az eredményt:
loopsMath.Collatz-sorozat hossza: 111
loopsMath.Collatz-sorozat elemei: 27, 82, 41, 124, 62, 31, 94, 47, 142, 71, 214, 107, 322, 161, 484, 242, 121, 364, 182, 91, 274,
137, 412, 206, 103, 310, 155, 466, 233, 700, 350, 175, 526, 263, 790, 395, 1186, 593, 1780, 890, 445, 1336, 668, 334,
167, 502, 251, 754, 377, 1132, 566, 283, 850, 425, 1276, 638, 319, 958, 479, 1438, 719, 2158, 1079, 3238, 1619, 4858,
2429, 7288, 3644, 1822, 911, 2734, 1367, 4102, 2051, 6154, 3077, 9232, 4616, 2308, 1154, 577, 1732, 866, 433, 1300, 650,
325, 976, 488, 244, 122, 61, 184, 92, 46, 23, 70, 35, 106, 53, 160, 80, 40, 20, 10, 5, 16, 8, 4, 2, 1

Tipp:
Használj egy ciklust a loopsMath.Collatz-sorozat elemeinek meghatározásához.
Az elemeket egy listában tárold, majd a lista elemeit használd a hossz és az elemek kiírásához.
 */

import java.util.ArrayList;
import java.util.List;

public class Collatz {

    public void collatz(int number) {
        List<Integer> results = new ArrayList<>();
        results.add(number);
        while (number > 1) {
            if (number % 2 == 0) {
                number = number / 2;
            } else {
                number = number * 3 + 1;
            }
            results.add(number);
        }
        System.out.println("loopsMath.Collatz-sorozat hossza: " + results.size());
        System.out.println("loopsMath.Collatz-sorozat elemei: " + results);
    }

    public static void main(String[] args) {
        Collatz ctz = new Collatz();
        ctz.collatz(6);
        ctz.collatz(27);
        /*
        loopsMath.Collatz-sorozat hossza: 9
        loopsMath.Collatz-sorozat elemei: [6, 3, 10, 5, 16, 8, 4, 2, 1]

        loopsMath.Collatz-sorozat hossza: 112
        loopsMath.Collatz-sorozat elemei: [27, 82, 41, 124, 62, 31, 94, 47, 142, 71,
        214, 107, 322, 161, 484, 242, 121, 364, 182, 91,
        274, 137, 412, 206, 103, 310, 155, 466, 233, 700,
        350, 175, 526, 263, 790, 395, 1186, 593, 1780, 890,
        445, 1336, 668, 334, 167, 502, 251, 754, 377, 1132,
        566, 283, 850, 425, 1276, 638, 319, 958, 479, 1438,
        719, 2158, 1079, 3238, 1619, 4858, 2429, 7288, 3644, 1822,
        911, 2734, 1367, 4102, 2051, 6154, 3077, 9232, 4616, 2308,
        1154, 577, 1732, 866, 433, 1300, 650, 325, 976, 488,
        244, 122, 61, 184, 92, 46, 23, 70, 35, 106,
        53, 160, 80, 40, 20, 10, 5, 16, 8, 4,
        2, 1]

         */
    }

}
