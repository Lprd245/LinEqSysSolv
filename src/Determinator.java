public class Determinator {

    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public static void main(String[] args){
        
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
        Output_Engine.print(ret);
        return(ret);
    
}
}
