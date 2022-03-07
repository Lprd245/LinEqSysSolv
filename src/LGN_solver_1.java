public class LGN_solver_1{

    public static void main(String[] args) {
        System.out.println("hai\n");

        int x[];
        x = new int [4];

        //input engine
        int exit;
        String input;
        
        for(exit = 0; exit < 1;){
            input = Kon.readString();
            if(input == "done"){
                System.out.println("exitting...");
                exit = 1;
            }
            else{
                int y;
                y = Integer.parseInt(input);
                System.out.println(y+2);
            }

        }

        /* System.out.println("--InArray:");
        System.out.print(x[0]+ " ");
        System.out.print(x[1]+ " ");
        System.out.println(x[2]+ " ");
        System.out.println(x[3]+ " ");
        System.out.println("--InArrayDone"); */

        System.out.println(x.length + "\n"); //checking lenght of array, tmp
        //Array print engine
        int i;
        System.out.print("|");
        for(i = 0; i < x.length; i++){
            System.out.print(" " + x[i] + " |");
        }

    }
}

//class Matrix {
//    public double[][] matrix=new double[0][0];
//
//    public Matrix() {
//        System.out.println("hey");
//    }
//} // no more matrics-claaz