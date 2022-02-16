package com.codegym;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    PhoneBookManagement phoneBookManagement = PhoneBookManagement.getInstance();

    public void run() {
        int choice = -1;
        do {
            menu();
            System.out.println("Nhập lựa chọn của bạn");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    System.out.println("---Xem danh sách---");
                    phoneBookManagement.showAllPhoneBook();
                    break;
                }
                case 2: {
                    System.out.println("---Thêm mới---");
                    PhoneBook phoneBook = inputPhoneBook();
                    phoneBookManagement.addNewPhoneBook(phoneBook);
                    System.out.println("Thêm thành công");
                    break;
                }
                case 3: {
                    System.out.println("---Cập nhật---");
                    update();
                    break;
                }
                case 4: {
                    System.out.println("---Xóa---");
                    delete();
                    break;
                }
                case 5: {
                    System.out.println("---Tìm kiếm---");
                    search();
                    break;
                }
                case 6: {
                    System.out.println("---Đọc từ file CSV---");
                    try {
                        phoneBookManagement.readFileCSV();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 7: {
                    System.out.println("---Ghi vào file CSV---");
                    for (int i = 0; i < phoneBookManagement.size(); i++) {
                        String phonebook = phoneBookManagement.showPhoneBookWriteToFile(i) + "\n";
                        try {
                            phoneBookManagement.writeToFileCSV(phonebook);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Đã ghi vào file CSV");
                    break;
                }
                case 0: {
                    System.out.println("---Thoát---");
                }
                default: {
                    System.out.println("Nhập lại");
                }
            }

        } while (choice != 0);

    }

    private void search() {
        System.out.println("Nhập số điện thoại cần tìm kiếm");
        String phone = scanner.nextLine();
        int index = phoneBookManagement.findByPhone(phone);
        if (index != -1) {
            phoneBookManagement.showPhoneBook(index);
        } else {
            System.out.println("Số điện thoại vừa nhập không tồn tại trong danh bạ");
        }
    }

    private void delete() {
        System.out.println("Nhập số điện thoại cần xóa");
        String phone = scanner.nextLine();
        int index = phoneBookManagement.findByPhone(phone);
        if (index != -1) {
            phoneBookManagement.deletePhoneBook(index);
            System.out.println("Cập nhật thành công");
        } else {
            System.out.println("Số điện thoại vừa nhập không tồn tại trong danh bạ");
        }
    }

    private void update() {
        System.out.println("Nhập số điện thoại cần sửa");
        String phone = scanner.nextLine();
        int index = phoneBookManagement.findByPhone(phone);
        if (index != -1) {
            System.out.println("Nhập thông tin cần sửa");
            PhoneBook phoneBook = inputPhoneBook();
            phoneBookManagement.updatePhoneBook(index, phoneBook);
            System.out.println("Cập nhật thành công");
        } else {
            System.out.println("Số điện thoại vừa nhập không tồn tại trong danh bạ");
        }
    }

    private PhoneBook inputPhoneBook() {
        System.out.println("Nhập tên");
        String name = scanner.nextLine();
        System.out.println("Nhập giới tính (Nam/Nữ)");
        String sex = scanner.nextLine();
        String phone;
        do {
            System.out.println("Nhập số điện thoại");
            phone = scanner.nextLine();
            if (phone.length() != 10) {
                System.err.println("Số điện thoại phải gồm 10 số");
            }
        } while (phone.length() != 10);
        System.out.println("Nhập nhóm (Bạn bè/Gia đình/Công ty...)");
        String group = scanner.nextLine();
        System.out.println("Nhập địa chỉ");
        String adress = scanner.nextLine();
        String email;
        do {
            System.out.println("Nhập email");
            email = scanner.nextLine();
            if (!phoneBookManagement.isEmail(email)) {
                System.out.println("Email chưa hợp lệ(abc123@gmail.com)");
            }
        } while (!phoneBookManagement.isEmail(email));
        System.out.println("Nhập facebook");
        String facebook = scanner.nextLine();
        System.out.println("Nhập ngày sinh");
        String dateOfBirth = scanner.nextLine();
        return new PhoneBook(name, sex, phone, group, adress, email, facebook, dateOfBirth);
    }

    private void menu() {
        System.out.println("---CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ---");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xóa");
        System.out.println("5. Tìm kiếm");
        System.out.println("6. Đọc từ File");
        System.out.println("7. Ghi vào File");
        System.out.println("8. Thoát");
    }
}
