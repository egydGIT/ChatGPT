package problemC;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class ChatGPT_main {

    static char[][] table = new char[5][5]; // 2D karakter tömb deklaráció [5sor][5oszlop]
                                            // kezdetben üres: minden elem 0 (vagy null)
                                            // static = osztályszintű és nem példányszintű változó, minden 'ChatGPT_main' osztály példányában ugyanaz az értéke
    static int[] rowOf = new int[26];   // 26 elemű egész számok tömbjei
    static int[] colOf = new int[26];   // sor és oszlop-számok tárolására = hol vannak a betűk a 'table' tömbben

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(Path.of("src/main/java/problemC/input.txt"))) {
            while (true) {                  // amíg 'n' nem = 0-val
                int n = scanner.nextInt();  // 'n' változót az 1. imput sorból olvassuk be -» hány konvertálandó sor van
                if (n == 0) break;          // n = 0 -» program leáll
                scanner.nextLine();         // 'n' utáni white space karakterek beolvasása -» nem mentjük el
                String key = scanner.nextLine().toUpperCase().replaceAll("J", "I"); // következő sor beolvasása, 'key' változóba mentjük
                                                // nagybetűstés // J-t I-re cseréli
                initializeTable(key);       // KULCSSZÓT BEOLVASÓ metódus  -» 'table' táblázat kitöltése
                for (int i = 0; i < n; i++) {
                    String line = scanner.nextLine().toUpperCase().replaceAll("J", "I").replaceAll(" ", "");
                    line = processLine(line); // TITKOSÍTÓ metódus -» beolvasott sorok feldolgozása
                    System.out.println(line); // titkosított sor kiírása
                }
                System.out.println();         // üres sor -» tesztesetek közötti szeparációhoz
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void initializeTable(String key) {   // KULCSSZÓT BEOLVASÓ metódus -» kulcsszó alapján kitölti a 'table' tömböt
                                                        // table[0][0] -» table[0][1] -» .. -» table[0][4]
                                                        // table[1][0] -» table[1][1] -» .. -» table[1][4]
        boolean[] used = new boolean[26];   // 26 elemű logikai tömb -» tárolja, hogy adott betű használatban van-e
        int i = 0, j = 0;                   // aktuális helyet jelölik a táblázatban
        for (char c : key.toCharArray()) {  // 'key' szóban szereplő betűk első előfordulásával tölti fel a 'table' tömböt
                                                // char tömböt ad vissza az eredeti String karaktereivel
                                                // 'key' karakterein végig iterálunk -» c felveszi az aktuális karakter értékét
            if (used[c - 'A']) continue;    // ha adott karakter már előfordult ('used' tömbben true) -» továbblép
                                            // [c - 'A'] -» c változó aktuális értékéből kivonjuk az 'A' karakter ASCII kódjának értékét
                                                // pl: E=69 A=65 -» 69-65=4
                                                // E betűhöz tartozó koordináták: 1.sor 5.oszlop (mivel az ABC 5. betűje..)
            used[c - 'A'] = true;           // adott karaktert jelöljük 'used' tömbben, hogy használtuk
            table[i][j] = c;                // táblázatban az aktuális helyre beírjuk az adott karaktert
            rowOf[c - 'A'] = i;             // eltároljuk az aktuális karakter sor(i) és oszlop(j) számát
            colOf[c - 'A'] = j;
            j++;                            // oszlop szám változót növeljük 1-el
            if (j == 5) {                   // ha az utólsó (5.) oszlophoz érkezünk
                j = 0;                      // akkor az oszlop változót 0-ra állítjuk = következő sorban kezdjük újra
                i++;                        // sor változót növeljük 1-el
            }
        }
        // 'key' szóban ne szereplő karakterekkel tölti fel a 'table' táblázatot, abc sorrendben, sorfolytonosan
        for (char c = 'A'; c <= 'Z'; c++) {             // végigiterálunk A-Z közötti összes karakteren
            if (c == 'J' || used[c - 'A']) continue;    // ha adott karakter J vagy már használtuk -» átugorjuk
            table[i][j] = c;                // táblázatba az aktuális helyre beírjuk az adott karaktert
            rowOf[c - 'A'] = i;             // eltároljuk az aktuális karakter sor(i) és oszlop(j) számát
            colOf[c - 'A'] = j;             // rowOf() colOf() -» adott karakter pozíciójának tárolására szolgál (table tömbbeli)
                                                    // pl: ha E betű a 'table' táblázat 1.sor 2.oszlopában -» table[0][1]
                                                    // E betű az abc 5.betűje (69-65=4) -» rowOf[4]=0; colOf[4]=1; -» used[4]=true;
            j++;
            if (j == 5) {
                j = 0;
                i++;
            }
        }
    }

    private static String processLine(String line) {    // TITKOSÍTÓ metódus -» titkositja a paraméterként kapott sort
        StringBuilder result = new StringBuilder();     // StringBuilder objektum létrehozása - a részeredmények tárlása, összefűzése
        if (line.length() % 2 != 0) {                   // ha bemeneti String hossza nem páros
            line += "X";                                // X karaktert ad hozzá
        }
        for (int i = 0; i < line.length(); i += 2) {    // ciklus, ami végigmegy a bemeneti String karakterein -» 2 karaktert dolgoz fel egyszerre
            char c1 = line.charAt(i);                   // 1. és 2. karakter értékeit változóba menti
            char c2 = line.charAt(i + 1);
            if (c1 == c2) {                             // ha a két karakter azonos
                line = line.substring(0, i + 1) + "X" + line.substring(i + 1);  // akkor X karaktert szúr közé
                c2 = 'X';                               // c2 változót X-re állítjuk
            }
            // a rowOf[] és colOf[] tömböket az előző metódusban inicializáltuk
            int row1 = rowOf[c1 - 'A'];     // c1 változó sor számát elővesszük és változóba mentjük
            int col1 = colOf[c1 - 'A'];                // oszlop
            int row2 = rowOf[c2 - 'A'];     // c2
            int col2 = colOf[c2 - 'A'];
            char newC1, newC2;              // létrehozunk két karakter változót -» ezek fogják tárolni a titkosított karaktereket
            if (row1 == row2) {             // HA a két karakter UGYANABBAN A SORBAN van:
                newC1 = table[row1][(col1 + 1) % 5];    // akkor az új karakterek - ADOTT SOR
                newC2 = table[row2][(col2 + 1) % 5];    // KÖVETKEZŐ OSZLOPBAN tárolt karakterek lesznek
                                                        // +1 -» adott sorban jobbra lépünk
                                                        // %5 -» moduláris aritmetika, sor végére érve előlről kezdi
            } else if (col1 == col2) {      // HA a két karakter AZONOS OSZLOPBAN van:
                newC1 = table[(row1 + 1) % 5][col1];    // akkor az új karakterek - ADOTT OSZLOP
                newC2 = table[(row2 + 1) % 5][col2];    // KÖVETKEZŐ SORÁBAN lévő karakterek lesznek
                                                        // adott oszlopban lefelé lépünk
            } else {                        // EGYÉB esetben: az új karakterek értéke
                newC1 = table[row1][col2];              // ADOTT SOR
                newC2 = table[row2][col1];              // MÁSIK KARAKTER OSZLOP SZÁMA
            }                                           // az eredeti karakterek SOR ÉS OSZLOP METSZETÉBEN lévő karakterek lesznek az új karakterek
            result.append(newC1).append(newC2); // az új karaktereket a 'result' StringBuilderhez fűzi
        }
        return result.toString();           // String objektummal tér vissza a metódus
    }


}