public class MatrixSolver {

    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static void main(String[] args){
        System.out.println(ANSI_RED + "[WARNING]: " + ANSI_RESET + "don't use main, it doesn't do anything, use another method");
        //ONLY USE MAIN METHOD FOR TESTING!!!
        Double arr [][];
        arr = new Double [4][3];

        //example equation system array:
        String varnames [];
        varnames = new String [4];
        varnames[0] = "N";
        varnames[1] = "x";
        varnames[2] = "y";
        varnames[3] = "z";
        arr[0][0] = 9.0;
        arr[1][0] = 7.0;
        arr[2][0] = 3.0;
        arr[3][0] = 15.0;
        arr[0][1] = 1.0;
        arr[1][1] = 8.0;
        arr[2][1] = 6.0;
        arr[3][1] = 6.0;
        arr[0][2] = 4.0;
        arr[1][2] = 2.0;
        arr[2][2] = 11.0;
        arr[3][2] = 9.0;
    
        threex(arr, varnames);
    }

    public static void twox(Double arr[][], String varnames[]){
        
        System.out.println(ANSI_YELLOW + "[INFO]: " + ANSI_GREEN + "MatrixSolver" + ANSI_RESET + " initalized");

        Double sol_arr [];
        sol_arr = new Double [3];

        //calculation of the Determinant divident
        sol_arr[0] = arr[0][0] * arr[1][1] - arr[1][0] * arr[0][1];
        
        //calculation of the Determinant divisor for each variable
        sol_arr[1] = arr[2][0] * arr[1][1] - arr[1][0] * arr[2][1];
        sol_arr[2] = arr[0][0] * arr[2][1] - arr[2][0] * arr[0][1];

        //checking for special cases
        if(sol_arr[0] == 0){
            if(sol_arr[1] == 0 && sol_arr[2] == 0){
                System.out.println("Inifinte solution possibilities");
            }
            else{
                System.out.println("No possible solutions");
            }
        }
        else{
            //doing all the divisions
            sol_arr[1] = (Double) sol_arr[1] / sol_arr[0];
            sol_arr[2] = (Double) sol_arr[2] / sol_arr[0];

            merge(sol_arr, varnames);
        }

        System.out.println(ANSI_YELLOW + "[INFO]: " + ANSI_GREEN + "MatrixSolver" + ANSI_RESET + " done");
    }

    public static void threex(Double arr[][], String varnames[]){

        System.out.println(ANSI_YELLOW + "[INFO]: " + ANSI_GREEN + "MatrixSolver" + ANSI_RESET + " initalized");

        Double sol_arr [];
        sol_arr = new Double [4];

        //calculation of the Determinant divident
        sol_arr[0] = arr[0][0] * arr[1][1] * arr[2][2] + arr[1][0] * arr[2][1] * arr[0][2] + arr[2][0] * arr[0][1] * arr[1][2];
        sol_arr[0] = sol_arr[0] - arr[2][0] * arr[1][1] * arr[0][2] - arr[1][0] * arr[0][1] * arr[2][2] - arr[0][0] * arr[2][1] * arr[1][2];

        //calculation of the Determinant divisor for each variable
        sol_arr[1] = arr[3][0] * arr[1][1] * arr[2][2] + arr[1][0] * arr[2][1] * arr[3][2] + arr[2][0] * arr[3][1] * arr[1][2];
        sol_arr[1] = sol_arr[1] - arr[2][0] * arr[1][1] * arr[3][2] - arr[1][0] * arr[3][1] * arr[2][2] - arr[3][0] * arr[2][1] * arr[1][2];
        sol_arr[2] = arr[0][0] * arr[3][1] * arr[2][2] + arr[3][0] * arr[2][1] * arr[0][2] + arr[2][0] * arr[0][1] * arr[3][2];
        sol_arr[2] = sol_arr[2] - arr[2][0] * arr[3][1] * arr[0][2] - arr[3][0] * arr[0][1] * arr[2][2] - arr[0][0] * arr[2][1] * arr[3][2];
        sol_arr[3] = arr[0][0] * arr[1][1] * arr[3][2] + arr[1][0] * arr[3][1] * arr[0][2] + arr[3][0] * arr[0][1] * arr[1][2];
        sol_arr[3] = sol_arr[3] - arr[3][0] * arr[1][1] * arr[0][2] - arr[1][0] * arr[0][1] * arr[3][2] - arr[0][0] * arr[3][1] * arr[1][2];

        //checking for special cases
        if(sol_arr[0] == 0){
            if(sol_arr[1] == 0 && sol_arr[2] == 0 && sol_arr[3] == 0){
                System.out.println("Infinite solution possibilities");
            }
            else{
                System.out.println("No possilbe solutions");
            }
        }
        else{
            //doing all the divisions
            sol_arr[1] = (Double) sol_arr[1] / sol_arr[0];
            sol_arr[2] = (Double) sol_arr[2] / sol_arr[0];
            sol_arr[3] = (Double) sol_arr[3] / sol_arr[0];
 
            merge(sol_arr, varnames);
        }
        
        System.out.println(ANSI_YELLOW + "[INFO]: " + ANSI_GREEN + "MatrixSolver" + ANSI_RESET + " done");

    }

    public static void large(Double inputarr[][], String varnames[]){
        if(inputarr.length > 3){
            //Double arr[][];
            //arr = new Double [inputarr.length - 1][inputarr[0].length - 1];
            for(int i = 0; i < inputarr.length - 1; i++){
                
            }

        }
    }

    public static void merge(Double input_arr[], String varnames[]){

        String arr [][];
        arr = new String [input_arr.length][2];

        for(int x = 0; x < input_arr.length; x++){
            arr[x][0] = varnames[x];
            arr[x][1] = String.valueOf(input_arr[x]);
        }

        Output_Engine.print_str(arr);
    }
}
