import java.util.Arrays;

public class LGN_solver_oe0 {
    
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public static void main(String[] args){
        
        System.out.println(ANSI_YELLOW + "[INFO]: " + ANSI_RESET + "program initalized");

        int arr[][];
        arr = new int [2][2];
        arr[0][0] = 3;
        arr[1][0] = 197;
        arr[0][1] = 983249;
        arr[1][1] = 5;

        // System.out.println("00: " + arr[0][0]);
        // System.out.println("10: " + arr[1][0]);
        // System.out.println("01: " + arr[0][1]);
        // System.out.println("11: " + arr[1][1]);

//        for(int x = 0; x < arr.length; x++){
//            System.out.println("lenghty");
//        }

        for(int y = 0; y < arr[0].length; y++){
            for(int x = 0; x < arr.length; x++){

                System.out.print("| ");

                for(int spcs = 0; spcs < Math.floor((float) (String.valueOf(Arrays.stream(arr[x]).max().getAsInt()).length() - String.valueOf(arr[x][y]).length()) / 2); spcs++){
                    System.out.print(" ");
                }

                System.out.print(arr[x][y] + " ");

                //"formula" for max number length in arr[x]: Math.ceil((float) (String.valueOf(Arrays.stream(arr[x]).max().getAsInt()).length() - String.valueOf(arr[x][y]).length()) / 2)
                for(int spcs = 0; spcs < Math.ceil((float) (String.valueOf(Arrays.stream(arr[x]).max().getAsInt()).length() - String.valueOf(arr[x][y]).length()) / 2); spcs++){
                    System.out.print(" ");
                }
                //System.out.print(Math.ceil((float) (String.valueOf(Arrays.stream(arr[x]).max().getAsInt()).length() - String.valueOf(arr[x][y]).length()) / 2));

            }
            System.out.println("|");
            
        }

        System.out.println(ANSI_YELLOW + "[INFO]: " + ANSI_RESET + "program done");

    }

}
