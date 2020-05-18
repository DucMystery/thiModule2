package CodeGym.Client;

import CodeGym.ContactList.ContactList;
import CodeGym.Manager.ContactManager;
import CodeGym.Model.Contact;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Client {
    Scanner scanner = new Scanner(System.in);
    ContactList<Contact> contacts;
    ContactManager manager;
    final String NAME_FILE ="Contact.txt";

    public Client() throws IOException {
        this.contacts = new ContactList<Contact>();
        this.manager = new ContactManager(contacts);
        manager.read(NAME_FILE);
    }

    public void menu() throws IOException {
        System.out.println("----CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ------");
        System.out.println("Chọn chức năng theo số (để tiếp tục) :");
        System.out.println("1 .Xem danh sách ");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xóa");
        System.out.println("5. Tìm kiếm");
        System.out.println("6. Đọc từ file");
        System.out.println("7. Ghi  từ file");
        System.out.println("8. Thoát");
        System.out.println("Chọn chức năng :");
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                manager.displayAll();
                menu();
                break;
            case 2:
                System.out.println("Nhập vào số điện thoại :");
                scanner.nextLine();
                String newNumber = scanner.nextLine();
                System.out.println("Nhập vào Nhóm :");
                String newGroup = scanner.nextLine();
                System.out.println("Nhập vào tên  :");
                String newName = scanner.nextLine();
                System.out.println("Nhập vào giới tính :");
                String newGender = scanner.next();
                System.out.println("Nhập vào địa chỉ :");
                scanner.nextLine();
                String newAddress = scanner.nextLine();
                System.out.println("Nhập vào ngày sinh :");
                String newDate = scanner.nextLine();
                System.out.println("Nhập vào email :");
                String newEmail = scanner.nextLine();
                if (manager.checkEmail(newEmail)==false || manager.checkTypeNumberPhone(newNumber) ==false){
                    System.out.println("Email hoặc số điện thoại nhập vào chưa đúng quy định mời chọn lại tác vụ :");
                    menu();
                }else {
                    manager.creatContact(newNumber,newGroup,newName,newGender,newAddress,newDate,newEmail);
                    System.out.println("Done");
                    menu();
                }
                break;
            case 3:
                System.out.println("Mời bạn nhập vào số điện thoại cần sửa tên :");
                scanner.nextLine();
                String phoneInput = scanner.nextLine();
                if (manager.checkNumberPhone(phoneInput)){
                    System.out.println("Mời bạn nhập vào tên cần thay :");
                    String nameChange = scanner.nextLine();
                    manager.editNameByNumberPhone(phoneInput,nameChange);
                    System.out.println("Done !");
                    menu();
                }else {
                    System.out.println("Số điện thoại bạn nhập có lỗi !");
                    menu();
                }
                break;
            case 4:
                System.out.println("Mời bạn nhập vào số điện thoại cần xóa :");
                scanner.nextLine();
                String numberPhoneDelete = scanner.nextLine();
                if (manager.checkNumberPhone(numberPhoneDelete)==false){
                    System.out.println("Số điện thoại không tồn tại .");
                    System.out.println("Mời chọn tác vụ :");
                    menu();
                }else {
                    manager.deleteContactByNumberPhone(numberPhoneDelete);
                    System.out.println("Deleted !");
                    menu();
                }
                break;
            case 5:
                System.out.println("Mời bạn nhập vào số điện thoại cần tìm :");
                scanner.nextLine();
                String numberPhoneSearch = scanner.nextLine();
                if (manager.checkNumberPhone(numberPhoneSearch)== false){
                    System.out.println("Số điện thoại ko tồn tại");
                    System.out.println("Mời nhập tác vụ mới :");
                    menu();
                }else {
                    System.out.println( manager.searchByNumberPhone(numberPhoneSearch));
                    menu();
                }
                break;
            case 6:
                System.out.println("Mời bạn nhập vào file cần đọc :");
                scanner.nextLine();
                String nameFile = scanner.nextLine();
                File file1 = new File(nameFile);
                if (!file1.exists()){
                    System.out.println("File không tồn tại !");
                    menu();
                }else {
                    manager.read(nameFile);
                    manager.displayAll();
                    menu();
                }
                break;
            case 7:
                System.out.println("Mời bạn nhập vào file muốn lưu :");
                scanner.nextLine();
                String fileSave = scanner.nextLine();
                File file = new File(fileSave);
                if (!file.exists()){
                    file.createNewFile();
                }
                manager.save(fileSave);
                System.out.println("Đã lưu thay đổi !");
                menu();
                break;
            case 8:
                System.exit(8);
        }

    }
}
