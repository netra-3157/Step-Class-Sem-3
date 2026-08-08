import java.util.Scanner;

public class TrafficSignalStreak {

    static void findLongestStreak(String signalLog) {

        char longestChar = signalLog.charAt(0);
        int longestLength = 1;

        int currentLength = 1;

        for (int i = 1; i < signalLog.length(); i++) {

            if (signalLog.charAt(i) == signalLog.charAt(i - 1)) {
                currentLength++;
            } else {
                currentLength = 1;
            }

            if (currentLength > longestLength) {
                longestLength = currentLength;
                longestChar = signalLog.charAt(i);
            }
        }

        System.out.println("Longest Streak: '" + longestChar +
                           "' repeated " + longestLength + " times");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter signal sequence: ");
        String signalLog = sc.nextLine();

        findLongestStreak(signalLog);

        sc.close();
    }
}