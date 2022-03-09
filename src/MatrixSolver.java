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
        arr = new int [1][1][1];
        Determinant(arr);
    }

    public static void Determinant(int arr[][][]){

        System.out.println(ANSI_YELLOW + "[INFO]: " + ANSI_GREEN + "MatrixSolver" + ANSI_RESET + " initalized");

        if(arr[0].length != arr.length){
            System.out.println("not a 'square' matrix");
        }

        int Determinant[];
        Determinant = new int [4];
        Determinant[0] = arr[0][0][0]*arr[0][1][1]*arr[0][2][2] + arr[0][1][0]*arr[0][2][1]*arr[0][0][2] + arr[0][2][0]*arr[0][0][1]*arr[0][1][2] - arr[0][0][2]*arr[0][1][1]*arr[0][2][0] - arr[0][1][2]*arr[0][2][1]*arr[0][0][0] - arr[0][2][2]*arr[0][0][1]*arr[0][1][0];

        System.out.println(ANSI_YELLOW + "[INFO]: " + ANSI_GREEN + "MatrixSolver" + ANSI_RESET + " done");

    }
}
