package lesson2;

public class MyArrayDataException extends NumberFormatException{
    public MyArrayDataException(int x, int y){
        System.out.println("В ячейке с кординатами: строка " + (x+1) + ", столбец " + (y+1) + " лежат неверные данные");
    };
}
