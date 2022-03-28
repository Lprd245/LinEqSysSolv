public class Determinator {

    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public static void main(String[] args){
        
    }

    public static void manager(Double arr[][]){ //extension with String varnames[]
        Double sol_arr [];
        sol_arr = new Double [arr[0].length + 1];

        Double matrix_arr [][][];
        matrix_arr = new Double [arr.length - 1][arr[0].length][arr.length];

        if(arr.length == arr[0].length + 1){
            //making 3dimensional array with matrix for each variable
            for(int i = 0; i < arr[0].length; i++){
                for(int j = 0; j < arr.length - 1; j++){
                    for(int l = 0; l < arr[0].length; l++){
                        if(i != j){
                            matrix_arr[j][l][i + 1] = arr[j][l];
                        } else {
                            matrix_arr[j][l][i + 1] = arr[arr.length - 1][l];
                        }
                    }
                }
            }
            //filling first array with denominator-matrix
            for(int i = 0; i < arr.length - 1; i++){
                for(int j = 0; j < arr[0].length; j++){
                    matrix_arr[i][j][0] = arr[i][j];
                }
            }


            //getting determinant for each array layer
            for(int i = 0; i < matrix_arr[0][0].length; i++){
                Double determine [][];
                determine = new Double [matrix_arr.length][matrix_arr[0].length];

                for(int j = 0; j < matrix_arr.length; j++){
                    for(int l = 0; l < matrix_arr[0].length; l++){
                        determine[j][l] = matrix_arr[j][l][i];
                    }
                }

                sol_arr[i] = determine(determine);
            }

            Output_Engine.print_ln(sol_arr);


            //checking for special cases
            if(sol_arr[0] == 0){
                boolean isInfinite = true;

                for(int i = 0; i < sol_arr.length; i++){
                    if(sol_arr[i] != 0){
                        isInfinite = false;
                    }
                }

                if(isInfinite == true){
                    System.out.println("Infinite solution possibilities");
                } else {
                    System.out.println("No possible solutions");
                }
            } else {
                //doing all the divisions to get the actual results
                for(int i = 0; i < sol_arr.length - 1; i++){
                    sol_arr[i + 1] = sol_arr[i + 1] / sol_arr[0];
                }

                Output_Engine.print_ln(sol_arr);
            }


        } else {
            System.out.println("Input is not the correct size (correct size: [ x | x - 1 ])");
        }
    }
    
    public static Double determine(Double arr[][]){

        Double ret = 0.0;

        if(arr.length == arr[0].length){

            if (arr[0].length > 0) {
                int add = 1;
                ret = 0.0;

                if(arr[0].length == 1){
                    return(arr[0][0]);
                }

                else if(arr[0].length == 2){
                    return(arr[0][0] * arr[1][1] - arr[1][0] * arr[0][1]);
                }

                else if(arr[0].length == 3){
                    return(arr[0][0] * arr[1][1] * arr[2][2] + arr[1][0] * arr[2][1] * arr[0][2] + arr[2][0] * arr[0][1] * arr[1][2] - arr[2][0] * arr[1][1] * arr[0][2] - arr[1][0] * arr[0][1] * arr[2][2] - arr[0][0] * arr[2][1] * arr[1][2]);
                }

                else{
                    for (int j = 0; j < arr.length; j++) {
                        ret = ret + add * arr[0][j] * determine(compress(arr,0,j));
                        add = - add;
                    }
                }
            }
        }
        return ret;

}



public static Double[][] compress(Double arr[][], int coordy, int coordx){

        Double ret [][];
        ret = new Double [arr.length - 1][arr[0].length - 1];

        int n = 0;
        int k = 0;
        
        for (int i = 0; i < arr[0].length; i++){

            if (i != coordy){
                k=0;
                for(int j = 0; j < arr.length; j++){

                    if(j != coordx){

                        ret[n][k] = arr[i][j];
                        k++;
                    }
                }
                
                ++n;
            }
        }
        return(ret);
    
}
}
