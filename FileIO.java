import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileIO {
    public static void main(String[] args) {
        // 1 & 2. Initialize File object and open input.txt
        File inputFile = new File("input.txt");
        int sum = 0; // set sum = 0

        // 3. Initialize Scanner object
        try (Scanner sc = new Scanner(inputFile)) {
            // While sc has next line
            while (sc.hasNextLine()) {
                String numStr = sc.nextLine().trim();
                if (numStr.isEmpty()) {
                    continue;
                }

                // Try converting line to integer and sum
                try {
                    int num = Integer.parseInt(numStr);
                    sum += num;
                } catch (NumberFormatException e) {
                    // Catch exception if string/float conversion fails
                    System.out.println(numStr + " is invalid");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: input.txt file not found.");
            return;
        }

        // Display total sum in console
        System.out.println(sum);

        // Open output.txt and write the sum
        try (PrintWriter writer = new PrintWriter("output.txt")) {
            writer.println(sum);
        } catch (FileNotFoundException e) {
            System.out.println("Error writing to output.txt");
        }
    }
}