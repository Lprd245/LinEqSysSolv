import java.util.Scanner;

public class Input {
    public static void main(String[] args){

        int dimensions [];
        dimensions = new int [2];

        dimensions[0] = Integer.valueOf(args[0]);
        dimensions[1] = Integer.valueOf(args[1]);

        if(dimensions[0] == dimensions[1] + 1){

            Double output_arr [][];
            output_arr = new Double [dimensions[0]][dimensions[1]];

            Scanner scnr = new Scanner(System.in);

            for(int i = 0; i < dimensions[1]; i++){

                for(int j = 0; j < dimensions[0]; j++){
                    System.out.print("Enter number for index [ " + j + " | " + i + " ]: ");
                    output_arr[j][i] = scnr.nextDouble();
                }
            
            }

            Determinator.manager(output_arr);


        } else {
            System.out.println("Input is not the correct size (correct size: [ x | x - 1 ])");
        }

    }    
}
