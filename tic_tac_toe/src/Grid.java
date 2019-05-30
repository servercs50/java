import java.util.Scanner;

class Grid {
    private boolean whoseTurn = false;
    private boolean winner = false;
    private int cellCounter = 9;

    void startGame(boolean aiPlay, int switchSide, boolean strategy) {
        Scanner input = new Scanner(System.in);

        ArtificialIntelligence newAI = new ArtificialIntelligence();

        String[] allTurns = new String[9];
        for (int x = 0; x < 9; x++) {
            allTurns[x] = " ";
        }
        while (!winner) {
            if (aiPlay & whoseTurn & switchSide == 0) {
                allTurns[newAI.gameAIAnalyze(allTurns, strategy, switchSide)] = "0";
            } else if (aiPlay & !whoseTurn & switchSide == 1) {
                allTurns[newAI.gameAIAnalyze(allTurns, strategy, switchSide)] = "X";
            } else {
                try {
                    gameMenu(allTurns);

                    String playerTurn = input.nextLine();
                    int playerTurn2 = Integer.parseInt(playerTurn) - 1;
                    while (!allTurns[playerTurn2].equals(" ")) {
                        drawGrid(allTurns);
                        System.out.println("Выбранная вами клетка занята, попробуйте ещё раз ");
                        playerTurn = input.nextLine();
                        playerTurn2 = Integer.parseInt(playerTurn) - 1;
                    }
                    if (!whoseTurn)
                        allTurns[playerTurn2] = "X";
                    else
                        allTurns[playerTurn2] = "0";
                } catch (Exception exc) {
                    if (exc instanceof ArrayIndexOutOfBoundsException) {

                        System.out.println("Вы ввели не верное числовое значение. Введите цифру от 1 до 9");
                        whoseTurn = !whoseTurn;
                    } else if (exc instanceof NumberFormatException) {
                        System.out.println("Вы ввели не числовое значение. Введите цифру от 1 до 9");
                        whoseTurn = !whoseTurn;
                    } else {
                        throw new RuntimeException(exc);
                    }
                }

            }
            cellCounter--;
            winner = checkPlayerWin(allTurns, aiPlay, switchSide);
            whoseTurn = !whoseTurn;
        }
    }

    private boolean checkPlayerWin(String[] playerWin, boolean aiPlay, int switchSide) {

        boolean result = false;
        int[][] combo = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8},
                {2, 4, 6}};
        for (int i = 0; i < 8; i++) {
            if (playerWin[combo[i][0]].equals("X") & playerWin[combo[i][1]].equals("X") & playerWin[combo[i][2]].equals("X")) {
                drawGrid(playerWin);
                if (aiPlay && switchSide == 1) {
                    System.out.println("Победил компьютер");
                    Game.stat.add("Победил компьютер");
                } else {
                    System.out.println("Победил игрок Крестик");
                    Game.stat.add("Победил игрок Крестик");
                }
                return true;
            } else if (playerWin[combo[i][0]].equals("0") & playerWin[combo[i][1]].equals("0") & playerWin[combo[i][2]].equals("0")) {
                drawGrid(playerWin);
                if (aiPlay && switchSide == 0) {
                    System.out.println("Победил компьютер");
                    Game.stat.add("Победил компьютер");
                } else {
                    System.out.println("Победил игрок Нолик");
                    Game.stat.add("Победил игрок Нолик");
                }
                return true;
            }

        }
        if (cellCounter == 0) {
            drawGrid(playerWin);
            System.out.println("Ничья. Закончились ходы");
            Game.stat.add("Ничья. Закончились ходы");
            result = true;
        }

        return result;
    }

    private void gameMenu(String[] allTurns) {
        if (!whoseTurn)
            System.out.println("Сейчас ходит Крестик");
        else
            System.out.println("Сейчас ходит Нолик");
        System.out.println("Введите свободное для хода поле используя цифры от 1 до 9");
        drawGrid(allTurns);
        if (!whoseTurn)
            System.out.println("Крестик вводит значение");
        else
            System.out.println("Нолик вводит значение");
    }

    private void drawGrid(String[] allTurns) {

        for (int i = 0; i < 9; i += 3) {
            System.out.println("|" + allTurns[i] + "|" + allTurns[i + 1] + "|" + allTurns[i + 2]
                    + "|  - поле для ввода " + (i + 1) + " " + (i + 2) + " " + (i + 3));
        }

    }

}
