import java.util.ArrayList;
import java.util.Scanner;

class Game {
    static ArrayList<String> stat = new ArrayList<>();

    static void start() {
        int series = 0;
        boolean isPlay = true;
        boolean strategy = false;
        int switchSide;
        Scanner input = new Scanner(System.in);
        System.out.println("Добро пожаловать в Крестики-нолики");
        while (isPlay) {
            try {
                System.out.println("Игра идёт сериями из трех раундов");
                System.out.println(
                        "Введите:\n1. Для игры вдвоём\n2. Для игры с компьютером\n3. Посмотреть статистику\n9. Выход");

                String gameMode = input.nextLine();
                int gameMode2 = Integer.parseInt(gameMode);
                if (gameMode2 == 1) {
                    while (series < 3) {
                        switchSide = 0;
                        System.out.format("Начнём игру. Раунд %d\n", series + 1);
                        series += newRound(false, switchSide, strategy);
                    }
                    series = 0;
                } else if (gameMode2 == 2) {
                    while (series < 3) {
                        strategy = ((int) (Math.random() * 2)) != 0;
                        System.out.format("Начнём игру. Раунд %d\n", series + 1);
                        System.out.print("В это раз игрок ходит ");
                        switchSide = (int) (Math.random() * 2);
                        System.out.println(switchSide == 0 ? "крестиками" : "ноликами");
                        series += newRound(true, switchSide, strategy);
                    }
                    series = 0;

                } else if (gameMode2 == 3) {
                    statisticChange();
                } else if (gameMode2 == 9) {
                    System.out.println("Конец игры");
                    isPlay = false;
                } else {
                    System.out.println("Вы ввели цифру не из диапазона 1 -3 . Введите цифру от 1 до 2");
                }
            } catch (NumberFormatException exc) {
                System.out.println("Вы ввели не числовое значение. Введите цифру от 1 до 2");
            }
            if (series == 2)
                stat.add("Серия закончена");
        }

        input.close();
    }

    private static void statisticChange() {
        for (String a : stat) {
            System.out.println(a);
        }
    }

    private static int newRound(boolean aiPlay, int switchSide, boolean strategy) {
        Grid newGame = new Grid();
        newGame.startGame(aiPlay, switchSide, strategy);
        return 1;
    }
}
