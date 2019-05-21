import java.util.Scanner;


public class Player {
    String coordinates;
    char coordinateX,coordinateY;
    byte moveCounter=1; //счетчик хода. крестики ходят по четному счетчику


    public byte getMoveCounter(){
        return moveCounter;
    }

    public char[][] update(char gridOfGame[][]) {

        if (moveCounter%2==0){
            System.out.println("\tХод №"+ moveCounter+". Крестики, ваша очередь! Введите координаты хода (пример:a2): ");} else {
            System.out.println("\tХод №"+ moveCounter+". Нолики, ваша очередь! Введите координаты хода (пример:a2): ");
        }
        Scanner scannerOfPlayerMove = new Scanner(System.in);


        coordinates=scannerOfPlayerMove.next();//заполняю строку

        if (coordinates.length()!=2) {
            System.out.println("Вы ввели не верный формат хода. Попробуйте снова (пример: a2)");
            return gridOfGame;
        }//если пользователь ввёл неверное количество символов (!=2)

        coordinateX=coordinates.charAt(0);
        coordinateY=coordinates.charAt(1);

        int x=0,y=0;//переменные для перевода введенных пользователем символов в числа
        switch (coordinateX){
            case 'a':x=0;break;
            case 'b':x=1;break;
            case 'c':x=2;break;
            default:System.out.println("Вы ввели не верный формат хода. Попробуйте снова (пример: a2)\n");
                return gridOfGame;//досрочный выход из ф-ции (чтобы не пойти дальше и не записать х или о в ячейку)
        }
        switch (coordinateY){
            case '1':y=0;break;
            case '2':y=1;break;
            case '3':y=2;break;
            default:System.out.printf("Вы ввели не верный формат хода. Попробуйте снова (пример: a2)\n");
                return gridOfGame;
        }


        if (gridOfGame[x][y]=='-') {
            if ((moveCounter%2==0)&&(gridOfGame[x][y]!='x')&&(gridOfGame[x][y]!='o')){
                gridOfGame[x][y]='x';moveCounter++;
            } else {
                gridOfGame[x][y]='o';moveCounter++;}
        } else {
            System.out.println("Клетка занята,попробуйте снова \t");
        }

        return gridOfGame;
    }
}