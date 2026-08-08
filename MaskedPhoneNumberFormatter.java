import java.util.Scanner;

public class MaskedPhoneNumberFormatter {

    static String maskPhoneNumber(String phone) {

        if (phone.length() != 10) {
            return "Error";
        }

        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Error";
            }
        }

        StringBuilder masked = new StringBuilder();

        masked.append("XXXXXX");
        masked.append("-");
        masked.append(phone.substring(6));

        return masked.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String phone = sc.nextLine();

        String result = maskPhoneNumber(phone);

        if (result.equals("Error")) {
            System.out.println("Error");
        } else {
            System.out.println(result);
        }

        sc.close();
    }
}