public class Output_Engine_2 {
    public static void main(String args){

    }

    public static void print_2d(String str, double dbl, int nt){

    }

    public static void print_1d(String str [], double dbl [], int nt []){
        String arr [];
        if(str != null){
            arr = new String [str.length];
            for(int i = 0; i < str.length; i++){
                arr[i] = str[i];
            }
            for(int i = 0; i < arr.length; i++){
                System.out.print("| " + arr[i] + " ");
            }
            System.out.println("|");
        }else if(dbl != null){
            arr = new String [dbl.length];
            for(int i = 0; i < dbl.length; i++){
                arr[i] = String.valueOf(dbl[i]);
            }
            for(int i = 0; i < arr.length; i++){
                System.out.print("| " + arr[i] + " ");
            }
            System.out.println("|");
        }else if(nt != null){
            arr = new String [nt.length];
            for(int i = 0; i < nt.length; i++){
                arr[i] = String.valueOf(nt[i]);
            }
            for(int i = 0; i < arr.length; i++){
                System.out.print("| " + arr[i] + " ");
            }
            System.out.println("|");
        }
    }

    

    public static void print_2d(String str [][], double dbl [][], int nt [][]){
        String arr [][];
        if(str != null){
            arr = new String [str.length][str[0].length];
            for(int j = 0; j < str[0].length; j++){
                for(int i = 0; i < str.length; i++){
                    arr[i][j] = str[i][j];
                }
            }
            prnt_str(arr);
        }else if(dbl != null){
            arr = new String [dbl.length][dbl[0].length];
            for(int j = 0; j < dbl[0].length; j++){
                for(int i = 0; i < dbl.length; i++){
                    arr[i][j] = String.valueOf(dbl[i][j]);
                }
            }
            prnt_str(arr);
        }else if(nt != null){
            arr = new String [nt.length][nt[0].length];
            for(int j = 0; j < nt[0].length; j++){
                for(int i = 0; i < nt.length; i++){
                    arr[i][j] = String.valueOf(nt[i][j]);
                }
            }
            prnt_str(arr);
        }
    }

    public static void prnt_str(String arr [][]){
        for(int y = 0; y < arr[0].length; y++){
            for(int x = 0; x < arr.length; x++){

                System.out.print("|");

                int maxlength = 0;

                for(int i = 0; i < arr[x].length; i++){
                    if(String.valueOf(arr[x][i]).length() > maxlength){
                        maxlength = String.valueOf(arr[x][i]).length();
                    }
                }

                for(int i = 0; i < Math.floor((float) (maxlength - arr[x][y].length()) / 2); i++){
                    System.out.print(" ");
                }

                System.out.print(" " + arr[x][y] + " ");

                for(int i = 0; i < Math.ceil((float) (maxlength - arr[x][y].length()) / 2); i++){
                    System.out.print(" ");
                }

            }
            System.out.println("|");
            
        }
    }
}
