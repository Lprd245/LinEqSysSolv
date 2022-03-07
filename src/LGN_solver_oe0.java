public class LGN_solver_oe0 {
    
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public static void main(String[] args){
        
        System.out.println(ANSI_YELLOW + "[INFO]: " + ANSI_RESET + "program initalized");

        int arr0[][];
        arr0 = new int [2][2];
        arr0[0][0] = 3;
        arr0[1][0] = 7;
        arr0[0][1] = 9;
        arr0[1][1] = 5;

        System.out.println("00: " + arr0[0][0]);
        System.out.println("10: " + arr0[1][0]);
        System.out.println("01: " + arr0[0][1]);
        System.out.println("11: " + arr0[1][1]);

        for(int x = 0; x < arr0.length; x++){
            System.out.println("lenghty");
        }

        System.out.println(ANSI_YELLOW + "[INFO]: " + ANSI_RESET + "program done");

    }

}
