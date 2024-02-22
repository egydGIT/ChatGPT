package problemC;

public class resultChecker {

    ChatGPT_main chatGPT_main = new ChatGPT_main();

    public static void main(String[] args) {
        String sample = "IUQABLDPPVUNQV\n" +
                "AQKRBFVTDOHICGFASMVOIY\n" +
                "QKSZNFSQLCWBDOATODNZLZ\n" +
                "TPPUSZEUQDYSOHQGVOZY";

        String result = "IUQABLDPPVUNQV\n" +
                "AQKRBFVTDOHICGFASMVOIY\n" +
                "QKSZNFSQLCWBDOATODNZLZ\n" +
                "TPPUSZEUQDYSOHQGVOZY";

        boolean isTheSame = sample.equals(result);
        System.out.println(isTheSame);              // true

    }
}
