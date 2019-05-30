import java.util.ArrayList;

class ArtificialIntelligence {
    int gameAIAnalyze(String[] allTurns, boolean strategy, int switchSide) {
        String first = "0";
        String second = "X";
        if (switchSide == 1) {
            first = "X";
            second = "0";
        }
        int gameAIAnalyzeResult;
        gameAIAnalyzeResult = checkWinStrategy2InRow(allTurns, first);
        if (gameAIAnalyzeResult != 101)
            return gameAIAnalyzeResult;
        gameAIAnalyzeResult = checkWinStrategy2InRow(allTurns, second);
        if (gameAIAnalyzeResult != 101)
            return gameAIAnalyzeResult;
        if (strategy)
            return winStrategy(allTurns);
        return randomTurn(allTurns);

    }

    private int checkWinStrategy2InRow(String[] aiWin, String turnSide) {

        int[][] combo = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8},
                {2, 4, 6}};
        for (int i = 0; i < 8; i++) {
            if (aiWin[combo[i][0]].equals(turnSide) & aiWin[combo[i][1]].equals(turnSide)
                    || aiWin[combo[i][0]].equals(turnSide) & aiWin[combo[i][2]].equals(turnSide)
                    || aiWin[combo[i][1]].equals(turnSide) & aiWin[combo[i][2]].equals(turnSide)) {
                if (aiWin[combo[i][0]].equals(" "))
                    return combo[i][0];
                else if (aiWin[combo[i][1]].equals(" "))
                    return combo[i][1];
                else if (aiWin[combo[i][2]].equals(" "))
                    return combo[i][2];

            }
        }
        return 101;
    }

    private int winStrategy(String[] allTurns) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            if ((i == 0 || i == 2 || i == 6 || i == 8) && allTurns[i].equals(" ")) {
                list.add(i);
            }
        }
        if (list.size() >= 2) {
            if (allTurns[4].equals(" ")) {
                list.add(4);
            }
            return list.get((int) (Math.random() * ((list.size()))));
        }
        return randomTurn(allTurns);
    }

    private int randomTurn(String[] aiRandom) {
        while (true) {
            int rnd = (int) (Math.random() * 9);
            if (aiRandom[rnd].equals(" ")) {
                return rnd;
            }
        }

    }
}
