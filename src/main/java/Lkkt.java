/*
Feladat:
Írj egy programot, amely bekér két pozitív egész számot a felhasználótól, majd meghatározza és kiírja
a két szám legkisebb közös többszörösét (LKKT)!

A legkisebb közös többszörös (LKKT) az a legkisebb pozitív egész szám, amely osztható mindkét megadott számmal.
Például, ha a felhasználó beírja a számokat 4 és 6, akkor a programnak meg kell határoznia az LKKT-t, ami 12,
mivel ez az a legkisebb pozitív egész szám, amely osztható mindkét számmal.

Példa:
Ha a felhasználó beírja a számokat: 15 és 20
A programnak ki kell írnia az eredményt: A legkisebb közös többszörös: 60

Tipp:
Használj egy ciklust, amely végigmegy a nagyobbik számtól kezdve,
és minden lépésben növeli az aktuális értéket a nagyobbik szám értékével.
Ellenőrizd minden lépésben, hogy az aktuális érték osztható-e mindkét számmal.
Ha igen, akkor ez az LKKT, és kiléphetsz a ciklusból.
 */

public class Lkkt {

    public int lkkt(int first, int second) {
        int result = 0;
        int bigger;
        int smaller;
        if (first < second) {
            bigger = second;
            smaller = first;
        } else {
            bigger = first;
            smaller = second;
        }
        for (int i = smaller; i <= (first * second); i+=smaller) {
            if (i % bigger == 0) {
                result = i;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        Lkkt lkkt = new Lkkt();
        System.out.println(lkkt.lkkt(120, 36));
    }
}
