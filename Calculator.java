import java.util.Scanner;

//still needs work
public class Calculator {
    public static void main(String[] args){
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("List of operations: add subtract multiply divide alphabetize");
            System.out.println("Enter an operation:");
            String Operation = input.nextLine().toLowerCase();

            switch (Operation) {
                case "add":
                    System.out.println("Enter two integers:");
                    if (input.hasNextInt()){
                        int value1 = input.nextInt();
                        if (input.hasNextInt()){
                            int value2 = input.nextInt();
                            System.out.println("Answer: " + (value1 + value2));
                        }
                        else{
                            System.out.println("Invalid input entered. Terminating...");
                        }
                    }
                    else{
                        System.out.println("Invalid input entered. Terminating...");
                    }
                break;
                case "subtract":
                    System.out.println("Enter two integers:");
                    if (input.hasNextInt()){
                        int value1 = input.nextInt();
                        if (input.hasNextInt()){
                            int value2 = input.nextInt();
                            System.out.println("Answer: " + (value1 - value2));
                        }
                        else{
                            System.out.println("Invalid input entered. Terminating...");
                        }
                    }
                    else{
                        System.out.println("Invalid input entered. Terminating...");
                    }
                break;
                case "multiply":
                    System.out.println("Enter two doubles:");
                    if (input.hasNextDouble()){
                        double value1 = input.nextDouble();
                        if (input.hasNextDouble()){
                            double value2 = input.nextDouble();
                            System.out.printf("Answer: %.2f\n", value1 * value2);
                        }
                        else{
                            System.out.println("Invalid input entered. Terminating...");
                        }
                    }
                    else{
                        System.out.println("Invalid input entered. Terminating...");
                    }
                break;
                case "divide":
                System.out.println("Enter two doubles:");
                if (input.hasNextDouble()){
                    double value1 = input.nextDouble();
                    if (input.hasNextDouble()){
                        double value2 = input.nextDouble();
                        if (value2 == 0) {
                            System.out.println("Invalid input entered. Terminating...");
                            break;
                        }
                        System.out.printf("Answer: %.2f\n", value1 / value2);
                    }
                    else{
                        System.out.println("Invalid input entered. Terminating...");
                    }
                }
                else{
                    System.out.println("Invalid input entered. Terminating...");
                }
                break;
                case "alphabetize":
                    System.out.println("Enter two words:");
                    String word1 = input.next();
                    String word2 = input.next();
                    if (word1.toLowerCase().equals(word2.toLowerCase())) {
                        System.out.println("Answer: Chicken or Egg.");
                    }
                    else if (word1.toLowerCase().compareTo(word2.toLowerCase()) < 0){
                        System.out.println("Answer: " + word1 + " comes before " + word2 + " alphabetically.");
                    }
                    else if (word1.toLowerCase().compareTo(word2.toLowerCase()) > 0){
                        System.out.println("Answer: " + word2 + " comes before " + word1 + " alphabetically.");
                    }
                break;
                default:
                    System.out.println("Invalid input entered. Terminating...");
                break;
            }
        }
    }
}