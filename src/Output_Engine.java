import java.util.Arrays;

public class Output_Engine {
    
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public static void main(String[] args){
        
    }

    public static void print(int arr[][]){
        
        System.out.println(ANSI_YELLOW + "[INFO]: " + ANSI_GREEN + "output engine" + ANSI_RESET + " initalized");

        for(int y = 0; y < arr[0].length; y++){
            for(int x = 0; x < arr.length; x++){

                System.out.print("|");

                //"formula": Math.ceil((float) (String.valueOf(Arrays.stream(arr[x]).max().getAsInt()).length() - String.valueOf(arr[x][y]).length()) / 2)
                for(int spcs = 0; spcs < Math.floor((float) (String.valueOf(Arrays.stream(arr[x]).max().getAsInt()).length() - String.valueOf(arr[x][y]).length()) / 2); spcs++){
                    System.out.print(" ");
                }

                System.out.print(" " + arr[x][y] + " ");

                //"formula": Math.ceil((float) (String.valueOf(Arrays.stream(arr[x]).max().getAsInt()).length() - String.valueOf(arr[x][y]).length()) / 2)
                for(int spcs = 0; spcs < Math.ceil((float) (String.valueOf(Arrays.stream(arr[x]).max().getAsInt()).length() - String.valueOf(arr[x][y]).length()) / 2); spcs++){
                    System.out.print(" ");
                }

            }
            System.out.println("|");
            
        }

        System.out.println(ANSI_YELLOW + "[INFO]: " + ANSI_GREEN + "output engine" + ANSI_RESET + " done");

    }

}
