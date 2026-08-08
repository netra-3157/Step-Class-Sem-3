import java.util.Scanner;

public class BankTransactionReference {

    // Method 1: Normalize the reference
    static String normalizeReference(String raw) {
        if (raw == null) {
            return "";
        }

        // Remove leading and trailing spaces
        raw = raw.trim();

        // If less than 3 characters, return as it is
        if (raw.length() < 3) {
            return raw;
        }

        // Convert only the first 3 characters to uppercase
        String bankCode = raw.substring(0, 3).toUpperCase();
        String remaining = raw.substring(3);

        return bankCode + remaining;
    }

    // Method 2: Validate and format the reference
    static String validateAndFormat(String reference) {

        // Check length
        if (reference.length() != 14) {
            return "Invalid: reference must be exactly 14 characters";
        }

        // Check first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        // Check remaining 11 characters are digits
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: date and sequence must contain digits only";
            }
        }

        // Extract parts
        String bankCode = reference.substring(0, 3);
        String date = reference.substring(3, 9);
        String sequence = reference.substring(9, 14);

        // Format date as DD/MM/YY
        String formattedDate = date.substring(0, 2) + "/"
                + date.substring(2, 4) + "/"
                + date.substring(4, 6);

        // Build output using StringBuilder
        StringBuilder result = new StringBuilder();

        result.append(bankCode)
              .append("/DATE: ")
              .append(formattedDate)
              .append(" | SEQ: ")
              .append(sequence);

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter bank transaction reference: ");
        String input = sc.nextLine();

        // Normalize
        String normalized = normalizeReference(input);

        // Validate and format
        String output = validateAndFormat(normalized);

        System.out.println(output);

        sc.close();
    }
}