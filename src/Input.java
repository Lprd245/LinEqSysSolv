import java.io.IOException;
import java.util.Scanner;

public class Input {
    public static void main(String[] args) throws IOException{

        boolean save = false;
        String filename = "";

        if(args.length >= 3 && args[2].equals("save")){
            System.out.println("saving");
            save = true;
            filename = args[3];
        }

        if(args[0].equals("load")){
            Determinator.manager(File_io.readarr(args[1]));
        }else{


        int dimensions [];
        dimensions = new int [2];

        dimensions[0] = Integer.valueOf(args[0]);
        dimensions[1] = Integer.valueOf(args[1]);

        if(dimensions[0] == dimensions[1] + 1){

            double output_arr [][];
            output_arr = new double [dimensions[0]][dimensions[1]];

            Scanner scnr = new Scanner(System.in);

            for(int i = 0; i < dimensions[1]; i++){

                for(int j = 0; j < dimensions[0]; j++){
                    System.out.print("Enter number for index [ " + j + " | " + i + " ]: ");
                    output_arr[j][i] = scnr.nextDouble();
                }
            
            }

            scnr.close();

            if(save){
                File_io.writearr(filename, output_arr);
            }

            Determinator.manager(output_arr);
        } else {
            System.out.println("Input is not the correct size (correct size: [ x | x - 1 ])");
        }

        }  //end of else in case of not-loading

        

    }    
}
