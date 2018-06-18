import java.util.*;
import java.util.concurrent.TimeUnit;
public class ForInput {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        Scanner in = new Scanner(System.in);
        String[] words = {"Good", "Nice", "Awesome", "Awful", "Very good"};
        char[][] arr1 = new char[0][0];
        char[][] arr2 = new char[0][0];
        boolean h = false;
        String[] name = new String[2];
        System.out.println("Welcome to SeaBattle v1.0 (alpha)!!!");
        for (int x = 0; x < 2; x++) {
            System.out.printf("%d Player's name: ", x + 1);
            name[x] = in.next();
            for (int i = 4; i > 0; i--) {
                for (int j = 1; j <= 5 - i; j++) {
                    System.out.println(name[x] + "'s map: ");
                    Player.printArr();
                    while (true) {
                        String let = null, s = null;
                        int n = 0;
                        Scanner input = new Scanner(System.in);
                        boolean ok = true;
                        try {
                            System.out.printf("Please enter %d, %d size ship(Only first coordinate):\n" +
                                    "Row side - Letter(a - j): ", j, i);
                            let = input.next();
                            System.out.print("Column side - Number(1 - 10): ");
                            n = input.nextInt();
                            if (i != 1) {
                                System.out.print("Is your ship horizontal:(Y/N): ");
                                s = input.next();
                                if (s.equals("Y") || s.equals("y"))
                                    h = true;
                                else if (s.equals("N") || s.equals("n"))
                                    h = false;
                                else {
                                    throw new InputMismatchException();
                                }
                            }
                        } catch (InputMismatchException ex) {
                            ok = false;
                            System.out.println("There is some error in input. Please be careful!!!");
                        }
                        if (ok)
                        {
                            try {
                                new Player(i, let, n, h);
                                break;
                            } catch (IndexOutOfBoundsException ex) {
                                System.out.println("Please enter numbers in given range!!!");
                            } catch (InputMismatchException ex) {
                                System.out.println("Your ship is too close to other!!!");
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 20; j++)
                    System.out.print("0 1 ");
                System.out.println();
            }
            if (x == 0)
                arr1 = Player.getArr();
            else
                arr2 = Player.getArr();

        }
        //Махач
        Methods.print01();
        System.out.print("Choosing who will start randomly");
        TimeUnit.SECONDS.sleep(1);
        System.out.print(".");
        TimeUnit.SECONDS.sleep(1);
        System.out.print(".");
        TimeUnit.SECONDS.sleep(1);
        System.out.println(".");
        int x = random.nextInt(2), cory, F = 0, S = 0;
        String corx;
        boolean ok = true;
        char[][] en1 = new char[12][12];
        char[][] en2 = new char[12][12];
        en1 =  Methods.idealMap(Methods.updateMap(en1));
        en2 =  Methods.idealMap(Methods.updateMap(en2));
        System.out.println(x + 1 + " player will start");
        arr1 = Methods.idealMap(arr1);
        arr2 = Methods.idealMap(arr2);
        while (true) {
            ok = true;
            do {
                char[][] map, enemy;
                if (x == 0) map = arr2;
                else map = arr1;
                if (x == 0) enemy = en1;
                else enemy = en2;
                System.out.println(name[x] + " enemy's map:");
                Methods.printMap(enemy);
                System.out.println(name[x] + "'s turn");
                while (true) {
                    try {
                        System.out.print("Row side - Letter(a - j): ");
                        corx = in.next();
                        System.out.print("Column side - Number(1 - 10): ");
                        cory = in.nextInt();
                        break;
                    } catch (InputMismatchException ex) {
                        System.out.println("Error in input");
                    }
                }
                if (Methods.check(map, corx, cory)) {
                    int z = random.nextInt(5);
                    System.out.println(words[z]);
                    enemy = Methods.upMap(enemy, map, corx, cory, true);
                    if (x == 0) F++;
                    else S++;
                }
                else {
                    ok = false;
                    enemy = Methods.upMap(enemy, map, corx, cory, false);
                }
                System.out.println(name[x] + " enemy's map:");
                Methods.printMap(enemy);
            }
            while (ok && (F != 20 && S != 20));
            if (x == 0) x = 1;
            else x = 0;
            if (F == 20) {System.out.println(name[0] + " wins"); break;}
            else if (S == 20) {System.out.println(name[1] + " wins"); break;}
        }
        System.out.println("Thanks for playing!!!\n" +
                "There will be new updates!\nSee you soon!");
        //Methods.printMap(arr1);
        //Methods.printMap(arr2);
    }
}
