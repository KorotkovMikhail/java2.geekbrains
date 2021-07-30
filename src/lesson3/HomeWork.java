package lesson3;
import java.util.*;
public class HomeWork {

    public static void main(String[] args) {
        Map<String, Integer> hm = new HashMap<>();
        String[] words = {
                "Апельсин", "Стол", "Кабель",
                "Вася", "Стул", "Апельсин",
                "Стол", "Жизнь", "Стол",
                "Верно", "Вверх", "Апельсин",
                "Собака", "Глаз", "Том",
                "Стол", "Смерть", "Тип", "Лень",
                "Глаз",  "Тень", "Ткач", "Крюк"
        };

        for (String word : words) {
            if (hm.containsKey(word))
                hm.put(word, hm.get(word) + 1);
            else
                hm.put(word, 1);
        }
        System.out.println(hm);


        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Коротков", "8999123321");
        phoneBook.add("Иванов", "8912155326");
        phoneBook.add("Петров", "8917155552");
        phoneBook.add("Сидоров", "899111111");
        phoneBook.add("Иванов", "89923231999");
        phoneBook.add("Иванов", "8888123113");
        phoneBook.add("Васюков", "8324325234");

        System.out.println(phoneBook.get("Иванов"));
        System.out.println(phoneBook.get("Сидоров"));
    }


}

