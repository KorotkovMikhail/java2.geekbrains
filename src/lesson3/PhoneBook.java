package lesson3;
import java.util.*;
public class PhoneBook {
    private Map<String, List<String>> phoneBook_hm = new HashMap<>();
    private List<String> phone_number_list;

    public void add(String surname, String phone_number) {
        if (phoneBook_hm.containsKey(surname)) {
            phone_number_list = phoneBook_hm.get(surname);
            phone_number_list.add(phone_number);
            phoneBook_hm.put(surname, phone_number_list);
        } else {
            phone_number_list = new ArrayList<>();
            phone_number_list.add(phone_number);
            phoneBook_hm.put(surname, phone_number_list);
        }
    }

    public List<String> get(String surname) {
        return phoneBook_hm.get(surname);
    }
}
