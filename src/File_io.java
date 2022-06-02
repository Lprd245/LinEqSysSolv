import java.io.*;

public class File_io {
    public static void main(String[] args) throws IOException{

        double arr [][];
        arr = new double [7][6];

        for(int i = 0; i < arr[0].length; i++){
            for(int j = 0; j < arr.length; j++){
                arr[j][i] = Math.random();
            }

        }
        writearr("töst.dat", arr);
        arr = readarr("töst.dat");
        Output_Engine_2.print_2d(null, arr, null);


    }

    public static void writearr(String filename, double arr[][]) throws IOException{
        BufferedWriter wrtr = new BufferedWriter(new FileWriter(filename));

        wrtr.write(String.valueOf(arr.length + "/" + arr[0].length));
        System.out.println("Writing to file " + filename + " with size [" + arr.length + "|" + arr[0].length + "]");
        wrtr.newLine();

        for(int i = 0; i < arr[0].length; i++){
            for(int j = 0; j < arr.length; j++){
                wrtr.write(String.valueOf(arr[j][i]) + " ");
            }
            wrtr.newLine();
        }

        wrtr.close();
    }

    public static double[][] readarr(String filename) throws IOException{

        BufferedReader rdr = new BufferedReader(new FileReader(filename));

        //finding size to expect for reading
        String tmpmxinfo [];
        tmpmxinfo = new String [2];
        tmpmxinfo = rdr.readLine().split("/");



        int mxinfo [];
        mxinfo = new int [2];
        mxinfo[0] = Integer.parseInt(tmpmxinfo[0]); //array.length (columns)
        mxinfo[1] = Integer.parseInt(tmpmxinfo[1]); //array[0].length (rows)

        String tmparr [][];
        tmparr = new String [mxinfo[1]][mxinfo[0]];

        double arr [][];
        arr = new double [mxinfo[0]][mxinfo[1]];

        for(int i = 0; i < mxinfo[1]; i++){
            tmparr[i] = rdr.readLine().split(" ");

            for(int j = 0; j < mxinfo[0]; j++){
                arr[j][i] = Double.valueOf(tmparr[i][j]);
            }
            
        }
        


        rdr.close();

        return(arr);
    }
}
