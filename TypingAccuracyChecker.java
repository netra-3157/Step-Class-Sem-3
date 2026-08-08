import java.util.Scanner;

public class TypingAccuracyChecker {

    static void checkTypingAccuracy(String original, String typed) {

        int matched = 0;
        int total = original.length();
        int firstMismatch = -1;

        int minLength = Math.min(original.length(), typed.length());

        // Compare characters
        for (int i = 0; i < minLength; i++) {

            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else {
                if (firstMismatch == -1) {
                    firstMismatch = i + 1;
                }
            }
        }

        double accuracy = (matched * 100.0) / total;

        System.out.println("Matched: " + matched + "/" + total);
        System.out.printf("Accuracy: %.2f%%\n", accuracy);

        if (firstMismatch != -1) {
            System.out.println("First Mismatch at position: " + firstMismatch);
        } else if (original.length() != typed.length()) {
            System.out.println("No character mismatch, but length is different.");
        } else {
            System.out.println("No Mismatches");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter original text: ");
        String original = sc.nextLine();

        System.out.print("Enter typed text: ");
        String typed = sc.nextLine();

        checkTypingAccuracy(original, typed);

        sc.close();
    }
}