import java.util.Scanner;

public class program {
    public static long[][] desk;
    public static int xw, yw;
    public static int m = 0;
    public static int n = 0;
    public static int x = 0;
    public static int y = 0;
    public static int xe = 0;
    public static int ye = 0;

    public static void main(String[] args) {
        printmenu();
        int choice = inputint("\nВведите номер выбранной операции...   ");
        switch (choice) {
            case (1):
                desksize();
                main(args);
            case (2):
                startpos();
                main(args);
            case (3):
                endpoint();
                main(args);
            case (4):
                wall();
                main(args);
            case (5):
                start();
                main(args);
            case (6):
                System.exit(0);
        }
        // long result = paths(x, y);
        // System.out.println(result);
    }

    public static void start() {
        if (m == 0 | n == 0) {
            System.out.println("Сначала укажите размер сетки.");
            desksize();
            start();
        } else {
            if (x == 0 | y == 0) {
                x = 1;
                y = 1;
            }
            if (xe == 0 | ye == 0) {
                xe = m;
                ye = n;
            }
            long result = paths(x, y);
            System.out.println(result);
            System.out.println("Чтобы продолжнить ENTER");
            try {
                System.in.read();
            } catch (Exception e) {
            }
        }
    }

    public static void printmenu() {
        System.out.print("\033[H\033[J");
        System.out.println("Выберите действие:\n");
        System.out.println("1. Ввести размер сетки.");
        System.out.println("2. Ввести начальную точку.");
        System.out.println("3. Ввести конечную точку.");
        System.out.println("4. Ввести координаты стены.");
        System.out.println("5. расчитать количество ходов.");
        System.out.println("6. Выход.");
    }

    public static void desksize() {
        m = inputint("Укажите размерность m  -> ");
        n = inputint("Укажите размерность n  -> ");
        desk = new long[m][n];
    }

    public static void startpos() {
        x = inputint("Укажите начальные координаты по 'x'  -> ");
        y = inputint("Укажите начальные координаты по 'y'  -> ");
    }

    public static void endpoint() {
        xe = inputint("Укажите конечные координаты по 'x'  -> ");
        ye = inputint("Укажите конечные координаты по 'y'  -> ");
    }

    public static void wall() {
        xw = inputint("Укажите координаты стены по 'x'  -> ");
        yw = inputint("Укажите координаты стены по 'y'  -> ");
    }

    public static long paths(int x, int y) {
        for (int i = 0; i < xe; i++) {
            for (int j = 0; j < ye; j++) {
                if (i == x - 1 | j == y - 1) {
                    desk[i][j] = (long) 1;
                } else if (i == xw - 1 & j == yw - 1 | i < x | j < y) {
                    desk[i][j] = 0;
                } else {
                    desk[i][j] = desk[i - 1][j] + desk[i][j - 1];
                }
            }
        }
        long res = desk[desk.length - 1][desk[0].length - 1];
        return res;
    }

    public static int inputint(String Text) {
        Scanner in = new Scanner(System.in);
        System.out.print(Text);
        int res = 0;
        try {
            res = in.nextInt();
        } catch (Exception e) {
            System.out.println("ошибка ввода!\n\nВы ввели не число!\nПОВТОРИТЕ ПОПЫТКУ...");
            main(null);
        }
        return res;
    }
}