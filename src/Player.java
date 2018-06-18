
import java.util.InputMismatchException;

public class Player extends Methods implements Inter{
    private static char[][] arr = {
            {'0','0','0','0','0','0','0','0','0','0','0','0'},
            {'0','0','0','0','0','0','0','0','0','0','0','0'},
            {'0','0','0','0','0','0','0','0','0','0','0','0'},
            {'0','0','0','0','0','0','0','0','0','0','0','0'},
            {'0','0','0','0','0','0','0','0','0','0','0','0'},
            {'0','0','0','0','0','0','0','0','0','0','0','0'},
            {'0','0','0','0','0','0','0','0','0','0','0','0'},
            {'0','0','0','0','0','0','0','0','0','0','0','0'},
            {'0','0','0','0','0','0','0','0','0','0','0','0'},
            {'0','0','0','0','0','0','0','0','0','0','0','0'},
            {'0','0','0','0','0','0','0','0','0','0','0','0'},
            {'0','0','0','0','0','0','0','0','0','0','0','0'}
    };
    private String name;
    public Player (int length, String letter, int number, boolean horizontal) {
        int x = number;
        int z = ((int)letter.charAt(0)) - 96;
        if (horizontal) {
            for (int i = 0; i < length; i++) {
                if (arr[z][x + i] == '0') {
                    arr[z][x + i] = (char)(length + 48);
                }
                else {
                    throw new InputMismatchException();
                }
            }
        }
        else {
            for (int i = 0; i < length; i++) {
                if (arr[z + i][x] == '0') {
                    arr[z + i][x] = (char)(length + 48);
                }
                else {
                    throw new InputMismatchException();
                }
            }
        }
        arr = Methods.updateShip(arr, z - 1, number - 1, length, horizontal, '5');
    }

    public static char[][] getArr() {
        char[][] ar = new char[12][12];
        for (int i = 0; i <= 11; i++)
            for (int j = 0; j <= 11; j++)
                ar[i][j] = arr[i][j];
        arr = Methods.updateMap(arr);
        return ar;
    }

    public static void printArr() {
        System.out.print(" ");
        for (int x = 1; x <= 10; x++)
            System.out.print(" " + x);
        System.out.println();
        for (int i = 1; i <= 10; i++) {
            System.out.print((char)(96 + i) + " ");
            for (int j = 1; j <= 10; j++) {
               if (arr[i][j] == '5' || arr[i][j] == '0')
                    System.out.print("- ");
                else
                    System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void ToMove() {
        char[][] ar = new char[12][12];
        for (int i = 0; i <= 11; i++)
            for (int j = 0; j <= 11; j++)
                ar[i][j] = arr[i][j];
        System.out.println("Sdelano!!!");
    }
}
