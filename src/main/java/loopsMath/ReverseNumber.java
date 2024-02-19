/*
Feladat:
Írj egy programot, amely megfordítja egy adott számjegyeket tartalmazó számot!
A programnak a felhasználótól kell bekérnie egy pozitív egész számot, majd meg kell fordítania annak számjegyeit,
és ki kell írnia az eredményt!

Példa:
Ha a felhasználó beírja a számot: 12345
A programnak ki kell írnia az eredményt: 54321

Tipp:
A számjegyek megfordításához konvertáld a számot stringgé, majd alakítsd vissza szám típusra és fordítsd meg a sorrendet!
 */
package loopsMath;

public class ReverseNumber {

    public void transfer(int number) {
        String converted = "" + number;
        String[] split = converted.split("");
        String result = "";
        for (int i = split.length-1; i >= 0; i--) {
            result += split[i];
        }
        System.out.println(result);
    }

    public int reverseNumber(int number) {
        int reversedNumber = 0;
        while (number != 0) {
            int digit = number % 10;
            // System.out.println(digit);
            reversedNumber = reversedNumber * 10 + digit;
            // System.out.println(reversedNumber);
            number /= 10;
            // System.out.println(number);
        }
        return reversedNumber;
    }

    public static void main(String[] args) {
        ReverseNumber rn = new ReverseNumber();
        rn.transfer(12345);
        System.out.println(rn.reverseNumber(12345));
    }
}
