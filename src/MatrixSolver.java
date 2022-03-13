public class MatrixSolver {

    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static void main(String[] args){
        System.out.println(ANSI_RED + "[WARNING]: " + ANSI_RESET + "don't use main, it doesn't do anything, use another method");
        //ONLY USE MAIN METHOD FOR TESTING!!!
        int arr [][][];
        arr = new int [1][3][3];

        //example equation system array:
        //String varnames []
        //varnames = new String [4]
        //varnames[0] = N
        //varnames[1] = x
        //varnames[2] = y
        //varnames[3] = z
        //arr[0][0][0] = 9;
        //arr[0][1][0] = 7;
        //arr[0][2][0] = 3;
        //arr[0][0][1] = 1;
        //arr[0][1][1] = 8;
        //arr[0][2][1] = 6;
        //arr[0][0][2] = 4;
        //arr[0][1][2] = 2;
        //arr[0][2][2] = 11;

        Determinant(arr);
    }

    public static void Determinant(int arr[][][]){

        // 3-dimensional Array of strings with y being the variable to be found for each "layer", form arr[3][4][x]
        // [x][x][x]
        // [x][x][x]
        // [x][x][x]
        // parallel 1-dimensional Array that stores the variable name (var_names[x] = arr[x][][])

        System.out.println(ANSI_YELLOW + "[INFO]: " + ANSI_GREEN + "MatrixSolver" + ANSI_RESET + " initalized");

        int Determinant[][];
        Determinant = new int [1][3];
        Determinant[0][0] = arr[0][0][3]; 
        Determinant[0][1] = arr[0][0][0]*arr[0][1][1]*arr[0][2][2] + arr[0][1][0]*arr[0][2][1]*arr[0][0][2] + arr[0][2][0]*arr[0][0][1]*arr[0][1][2] - arr[0][0][2]*arr[0][1][1]*arr[0][2][0] - arr[0][1][2]*arr[0][2][1]*arr[0][0][0] - arr[0][2][2]*arr[0][0][1]*arr[0][1][0];

        Output_Engine.print(Determinant);

        System.out.println(ANSI_YELLOW + "[INFO]: " + ANSI_GREEN + "MatrixSolver" + ANSI_RESET + " done");

    }
}
