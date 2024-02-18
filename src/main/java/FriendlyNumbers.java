/*
Feladat:
Írj egy programot, amely meghatározza, hogy egy adott szám "barátságos szám" vagy sem.

Két szám barátságos számoknak nevezünk, ha az egyik szám összes osztója összeadva megegyezik a másik számmal, és fordítva.
Például, az 220 és 284 barátságos számok, mivel
220 osztói (1, 2, 4, 5, 10, 11, 20, 22, 44, 55, 110) összege 284, és
284 osztói (1, 2, 4, 71, 142) összege 220.

Példa:
Ha az első szám 1184 és a második szám 1210
A programnak ki kell írnia az eredményt:
1184 és 1210 barátságos számok.

Tipp:
Készíts egy metódust, amely számok számjegyeinek összegét számolja ki,
majd ezt használd a barátságos számok ellenőrzéséhez.
 */

import java.util.ArrayList;
import java.util.List;

public class FriendlyNumbers {

    // Eszter
    public boolean isFriendlyNumber(int first, int second) {
        List<Integer> firstDivisors = findDivisors(first);
        List<Integer> secondDivisors = findDivisors(second);
        int firstResult = addDivisors(firstDivisors);
        int secondResult = addDivisors(secondDivisors);
        if(firstResult == second && secondResult == first) {
            System.out.println(first + " és " + second + " barátságos számok.");
        } else {
            System.out.println(first + " és " + second + " NEM barátságos számok.");
        }
        return firstResult == secondResult;
    }

    private int addDivisors(List<Integer> divisors) {
        int result = 0;
        for(int number : divisors) {
            result += number;
        }
        return result;
    }

    private List<Integer> findDivisors(int number) {
        List<Integer> divisors = new ArrayList<>();
        for(int i = 1; i < number; i++) {
            if (number % i == 0) {
                divisors.add(i);
            }
        }
        return divisors;
    }

    // ChatGPT
    public static boolean areFriendlyNumbers(int first, int second) {
        int firstDivisorSum = sumOfDivisors(first);
        int secondDivisorSum = sumOfDivisors(second);

        return firstDivisorSum == second && secondDivisorSum == first;
    }

    private static int sumOfDivisors(int number) {
        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        FriendlyNumbers fn = new FriendlyNumbers();

        // Eszter
        fn.isFriendlyNumber(220, 284);    // 220 és 284 barátságos számok.
        fn.isFriendlyNumber(1184, 1210);  // 1184 és 1210 barátságos számok.

        // ChatGPT
        int num1 = 220;
        int num2 = 284;
        if (areFriendlyNumbers(num1, num2)) {
            System.out.println(num1 + " és " + num2 + " barátságos számok.");
        } else {
            System.out.println(num1 + " és " + num2 + " NEM barátságos számok.");
        }
    }
}
