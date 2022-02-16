package com.codegym;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class PhoneBookManagement {

    private static PhoneBookManagement phoneBookManagement;
    private List<PhoneBook> phoneBookList = new ArrayList<>();


    private PhoneBookManagement() {
    }

    public static PhoneBookManagement getInstance() {
        if (phoneBookManagement == null) {
            phoneBookManagement = new PhoneBookManagement();
        }
        return phoneBookManagement;
    }

    public int size() {
        return phoneBookList.size();
    }


    public void readFileCSV() throws FileNotFoundException {
        try {
            FileReader fileReader = new FileReader("phonebook.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] phonebook = line.split(", ");
                String name = phonebook[0];
                String sex = phonebook[1];
                String phone = phonebook[2];
                String group = phonebook[3];
                String adress = phonebook[4];
                String email = phonebook[5];
                String facebook = phonebook[6];
                String dateOfBirth = phonebook[7];
                PhoneBook phoneBook = new PhoneBook(name, sex, phone, group, adress, email, facebook, dateOfBirth);
                addNewPhoneBook(phoneBook);
            }
            bufferedReader.close();
            fileReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void writeToFileCSV(String s) throws IOException {
        FileWriter fileWriter = new FileWriter("phonebook.csv", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(s);
        bufferedWriter.close();
        fileWriter.close();
    }

    public void showAllPhoneBook() {
        if (size() == 0) {
            System.out.println("Danh sách rỗng");
        } else {
            for (PhoneBook phoneBook : phoneBookList) {
                System.out.println(phoneBook);
            }
        }
    }

    public int findByPhone(String phone) {
        for (int i = 0; i < size(); i++) {
            if (phone.equals(phoneBookList.get(i).getPhone())) ;
            return i;
        }
        return -1;
    }


    public void addNewPhoneBook(PhoneBook phoneBook) {
        phoneBookList.add(phoneBook);
    }

    public void updatePhoneBook(int index, PhoneBook phoneBook) {
        phoneBookList.set(index, phoneBook);
    }

    public void deletePhoneBook(int index) {
        phoneBookList.remove(index);
    }

    public String showPhoneBookWriteToFile(int index) {
        return phoneBookList.get(index).toString();
    }

    public void showPhoneBook(int index) {
        System.out.println(phoneBookList.get(index));
    }

    public boolean isEmail(String email) {
        String regex = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$";
        if (Pattern.matches(regex, email)) return true;
        return false;
    }
}
