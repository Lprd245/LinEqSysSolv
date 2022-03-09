import java.util.Scanner;

public class Human_Input_Engine {

    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public static void main(String[] args) {
        System.out.println(ANSI_RED + "[WARNING]: " + ANSI_RESET + "don't use main, it doesn't do anything, use another method");
        reader();
    }

    public static String reader() {
        Scanner scnr = new Scanner(System.in);
        String equations = "";

        System.out.print("Enter number of equations: ");
        int num_of_eq = scnr.nextInt();
        scnr.nextLine();
        
        for (int i = 0; i < num_of_eq; i++) {
            System.out.print("Enter " + String.valueOf(i) + ". equation: ");
            String equation = scnr.next();
            scnr.nextLine();
            equations = equations + equation + "\n";
        }
        
        return equations;
    }
}