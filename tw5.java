import java.util.*;

public class tw5 {

    public interface TextTransformer {
        String transform(String text);
    }

    public static void main(String[] args) {
        String result = null;
        Scanner scanner = new Scanner(System.in);

        TextTransformer toUpperCase = (String text) -> {
            StringBuilder up = new StringBuilder();
            for (char ch : text.toCharArray()) {
                if (ch >= 'a' && ch <= 'z') {
                    up.append((char) (ch - 32));
                } else {
                    up.append(ch);
                }
            }
            return up.toString();
        };

        TextTransformer reverseText = (text) -> {
            StringBuilder reversed = new StringBuilder();
            for (int i = text.length() - 1; i >= 0; i--) {
                reversed.append(text.charAt(i));
            }
            return reversed.toString();
        };

        TextTransformer countVowels = (text) -> {
            int count = 0;
            for (char c : text.toLowerCase().toCharArray()) {
                if ("aeiou".indexOf(c) != -1) {
                    count++;
                }
            }
            return "Number of vowels: " + count;
        };

        while (true) {
            System.out.println("\nChoose a transformation:");
            System.out.println("1. Convert to UpperCase");
            System.out.println("2. Reverse Text");
            System.out.println("3. Count Vowels");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            System.out.print("Enter the string: ");
            String input = scanner.nextLine();

            switch (choice) {
                case 1:
                    result = toUpperCase.transform(input);
                    System.out.println("Result: " + result);
                    break;
                case 2:
                    result = reverseText.transform(input);
                    System.out.println("Result: " + result);
                    break;
                case 3:
                    result = countVowels.transform(input);
                    System.out.println("Result: " + result);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

