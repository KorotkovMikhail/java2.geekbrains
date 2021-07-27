package lesson2;

public class HomeWork {

    public static void main(String[] args) {
        String[][] arr = {  {"1", "2", "3", "4"},
                            {"2", "3", "a", "5"},
                            {"3", "4", "e", "6"},
                            {"4", "5", "!", "7"}
        };


                System.out.println();
        try {
            System.out.println("Сумма целых элементов массива = " + arraySum(arr));
        } catch (MyArraySizeException e) {
            System.out.println("Массив не соответствует тредуемым параметрам");
        }

    }

    public static int arraySum(String[][] arr) throws MyArraySizeException{
        if (arr.length != 4) throw new MyArraySizeException("Неверное количество строк");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) throw new MyArraySizeException("Неверное количество столбцов в строке " + (i-1));
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
               try {
                   try {
                       sum = sum + Integer.parseInt(arr[i][j]);
                   } catch (NumberFormatException e) {
                       throw new MyArrayDataException(i, j);
                   }
               } catch (MyArrayDataException e) {

               }
            }
        }


        return sum;
    }
}
