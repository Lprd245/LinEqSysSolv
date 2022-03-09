import java.util.Scanner;

public class Input {
    
    public static void main(String[] args){

        System.out.print("Enter the x dimension of your Array: ");
        Scanner scnr = new Scanner(System.in);
        int sizex = scnr.nextInt();

        System.out.print("Enter the y dimension of your Array: ");
        int sizey = scnr.nextInt();
        scnr.nextLine();// to consume the \n that nextInt leaves over, so that the following nextLine won't be skipped

        if(sizex*sizey > 16){
            System.out.print("Are you sure that you want to define an Array with " + sizex*sizey + " cells? (y/n): ");
            Character choice = scnr.nextLine().charAt(0);
            if(choice != 'y'){
                return;
            }
        }

        int arr[][];
        arr = new int [sizex][sizey];
        arr[0][0] = 87653;
        arr[1][0] = 234;
        arr[0][1] = 9;
        arr[1][1] = 5436;

        Output_Engine.print(arr);
    }
}
