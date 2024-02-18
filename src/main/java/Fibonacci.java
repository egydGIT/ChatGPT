/*
Feladat:
Írj egy programot, amely kiszámítja egy Fibonacci-sorozat első N elemét!
A Fibonacci-sorozat az előző két elem összegéből áll, és az első két elem általában 0 és 1.
Tehát az N. elemet a (N-1). és (N-2). elem összege adja meg.
A programnak a felhasználótól kell bekérnie egy pozitív egész számot (N), majd ki kell írnia az első N Fibonacci-számot.

Példa:
Ha a felhasználó beírja a számot: 10
A programnak ki kell írnia az eredményt: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34
 */

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

    public List<Integer> fibonacci(int n) {
        List<Integer> numbers = new ArrayList<>();
        if (n == 1) {
            numbers.add(0);
        }
        if (n == 2) {
            numbers.add(0);
            numbers.add(1);
        }
        if (n >= 3) {
            numbers.add(0);
            numbers.add(1);
            for (int i = 0; i < n-2; i++) {
                int newNumber = numbers.get(i) + numbers.get(i+1);
                numbers.add(newNumber);
            }
        }
        return numbers;
    }

    public List<Integer> fibonacciRecursive(int n) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numbers.add(recursive(i));
        }
        return numbers;
    }

    public int recursive(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return recursive(n - 1) + recursive(n - 2);
        }
    }

    public static void main(String[] args) {
        Fibonacci fb = new Fibonacci();

        System.out.println(fb.fibonacci(10));
        System.out.println(fb.fibonacciRecursive(10));

    }
}
