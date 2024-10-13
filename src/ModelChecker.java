public class ModelChecker {
    public int check(char[][] model) {
        int countX = 0;
        int countO = 0;
        char x = 'x';
        char o = 'o';
        boolean winX = false;
        boolean winO = false;
        for (int i = 0; i < model.length; i++) { //Считаем количество крестиков и ноликов
            for (int j = 0; j < model[i].length; j++) {
                if (model[i][j] == x) {
                    countX++;
                }
                if (model[i][j] == o) {
                    countO++;
                }

            }
        }
        if (Math.abs(countX - countO) >= 2 || countO - countX == 1) { //если ноликов больше или кого-то больше на два+, то это невозможный вариант игры
            return -1;
        }
        for (int i = 0; i < model.length; i++) {
            if (model[i][0] == model[i][1] && model[i][1] == model[i][2]) { //проверка ряда по строкам
                if (model[i][0] == x) {
                    winX = true;
                }
                else {
                    winO = true;
                }
            }
        }
        for (int j = 0; j < model.length; j++) {
            if (model[0][j] == model[1][j] && model[1][j] == model[2][j]) { //проверка победного ряда по столбцам
                if (model[0][j] == x) {
                    winX = true;
                }
                else {
                    winO = true;
                }
            }
        }
//        проверка победного ряда по диагоналям
        if (model[0][0] == model[1][1] && model[1][1] == model[2][2]) {
            if (model[0][0] == x) {
                winX = true;
            }
            else {
                winO = true;
            }
        }
        if (model[0][2] == model[1][1] && model[1][1] == model[2][0]) {
            if (model[0][2] == x) {
                winX = true;
            }
            else {
                winO = true;
            }
        }
        if (winX == true && winO == false) {
            return 1;
        }
        else if (winO == true && winX == false) {
            return 0;
        }
        else if (winX == true && winO == true) {
            return -1;
        }
        else {
            if (countX + countO == 9) {
                return 4;
            }
            else {
                if (countX == countO) {
                    return 2;
                }
                else {
                    return 3;
                }
            }
        }
        /*
            Тут надо добавить код, который проанализирует модель и
            примет решение, в каком состоянии игра крестики-нолики,
            выдав один из вариантов ответа:
            0 - выиграли нолики
            1 - выиграли крестики
            2 - игра закончена, ничья
            3 - в других случаях
         */
    }
}