public class Methods {
    public static char[][] updateShip(char[][] arr, int x, int y, int length, boolean horizontal, char c) {
        if (horizontal) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < length + 2; j++) {
                    if (arr[x + i][y + j] != (char)(length + 48))
                        arr[x + i][y + j] = c;
                }
            }
        } else {
            for (int i = 0; i < length + 2; i++) {
                for (int j = 0; j < 3; j++) {
                    if (arr[x + i][y + j] != (char)(length + 48))
                        arr[x + i][y + j] = c;
                }
            }
        }
        return arr;
    }
    public static char[][] updateMap(char[][] arr) {
        for (int i = 0; i <= 11; i++)
            for (int j = 0; j <= 11; j++)
                arr[i][j] = '0';
        return arr;
    }
    public static boolean check(char[][] arr, String xx, int y) {
        int x = (int)(xx.charAt(0)) - 96;
        if (arr[x][y] == '-' || arr[x][y] == '5') return false;
        else return true;
    }
    public static char[][] upMap(char[][] arr, char[][] ar, String xx, int y, boolean popad) {
        int x = (int)(xx.charAt(0)) - 96;
        if (popad) {
            arr[x][y] = 'X';
        }
        else
            arr[x][y] = 'O';
        return arr;
    }
    public static char[][] idealMap(char[][] arr) {
        for (int i = 0; i <= 11; i++)
            for (int j = 0; j <= 11; j++)
                if (arr[i][j] == '0')
                    arr[i][j] = '-';
        return arr;
    }
    public static void printMap(char[][] arr) {
        System.out.print(" ");
        for (int x = 1; x <= 10; x++)
            System.out.print(" " + x);
        System.out.println();
        for (int i = 1; i <= 10; i++) {
            System.out.print((char)(96 + i) + " ");
            for (int j = 1; j <= 10; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void print01() {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 20; j++)
                System.out.print("0 1 ");
            System.out.println();
        }
    }
}
