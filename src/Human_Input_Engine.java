import java.util.Scanner;

public class Human_Input_Engine {

    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public static void main(String[] args) {
        System.out.println(ANSI_RED + "[WARNING]: " + ANSI_RESET + "don't use main, it doesn't do anything, use another method");
        String x = simplify("1 X-3 (4+1)=3");
    }

    public static String reader() {
        Scanner scnr = new Scanner(System.in);
        String equations = "";

        System.out.print("Enter number of equations: ");
        int num_of_eq = scnr.nextInt();
        scnr.nextLine();
        
        for (int i = 0; i < num_of_eq; i++) {
            System.out.print("Enter " + String.valueOf(i + 1) + ". equation: ");
            String equation = scnr.next();
            scnr.nextLine();
            equation = simplify(equation);
            equations = equations +  equation + "|";
        }
        
        return equations;
    }

    public static String simplify(String equation) {

        equation = equation.replaceAll("\\s+", ""); //remove spaces
        equation = equation.toLowerCase(); //lowercase

        
        String left_term = equation.split("=")[0]; 
        String right_term = equation.split("=")[1];

        String new_left_term;
        String new_right_term;

        //solving brackets
        for (int i=0; i<left_term.length(); i++) {
             Boolean closed = true;
            if (left_term.charAt(i) == '(' && closed == true) {
                closed = false;
                String sub_equation = "";
                for (int j=i+1; j<left_term.length(); j++) {
                    if (left_term.charAt(j) == ')') {
                        closed = true;
                        break;
                    } else {
                        sub_equation = sub_equation + left_term.charAt(j);
                    }
                }
            }
        }   

        return equation;
    }
}