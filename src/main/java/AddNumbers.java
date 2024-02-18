/*
Feladat:
Írj egy programot, amely egy adott számnak meghatározza a számjegyeinek összegét!

A programnak először be kell kérnie egy pozitív egész számot a felhasználótól,
majd meghatároznia és kiírnia annak a számnak a számjegyeinek összegét. Például,
ha a felhasználó beírja a számot 12345, akkor a programnak ki kell írnia az eredményt:
A számjegyek összege: 15

Példa:
Ha a felhasználó beírja a számot: 9876
A programnak ki kell írnia az eredményt:
A számjegyek összege: 30

Tipp:
A számjegyek összegét egy ciklussal számolhatod össze, amely végigmegy a számjegyeken
és az összegzést frissíti a jelenlegi számjegy értékével.
 */

public class AddNumbers {

    public int addNumbers(int number) {
        int result = 0;
        while (number != 0) {
            result += number % 10;
            number = number / 10;
        }
        return result;
    }

    public static void main(String[] args) {
        AddNumbers an = new AddNumbers();
        System.out.println(an.addNumbers(9876));    // 30
        System.out.println(an.addNumbers(12345));   // 15
    }

}
