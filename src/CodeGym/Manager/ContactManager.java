package CodeGym.Manager;

import CodeGym.ContactList.ContactList;
import CodeGym.Model.Contact;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactManager implements Function {
    final String NAME_FILE ="Contact.txt";
    public final ContactList<Contact>contacts;
    final String REGEX_FILE ="^\\w+\\w.*@[a-z]+(\\.[a-z]+)$";
    final String REGEX_NUMBER_PHONE ="^[0]{1}+[0-9]{9}$";

    public ContactManager(ContactList<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public void displayAll() {
        for (Contact contact : contacts){
            System.out.println(contact.toString());
        }
    }

    @Override
    public void deleteContactByNumberPhone(String numberPhone) {
        for (Contact contact : contacts){
            if (contact.getNumberPhone().equals(numberPhone)){
                contacts.remove(contact);
                return;
            }
        }
    }

    @Override
    public String searchByNumberPhone(String numberPhone) {
        for (Contact contact : contacts){
            if (contact.getNumberPhone().equalsIgnoreCase(numberPhone)){
                return contact.toString();
            }
        }
        return "Không tìm thấy !";
    }

    @Override
    public void addContact(Contact contact) {
        contacts.add(contact);
        System.out.println("Done !");
    }

    public void editNameByNumberPhone(String numberPhone, String newName){
        for (Contact contact : contacts){
            if (contact.getNumberPhone().equals(numberPhone)){
                contact.setName(newName);
                return;
            }
        }
    }

    public void creatContact(String numberPhone, String group, String name, String gender, String address, String date, String email){
        Contact contact = new Contact(numberPhone, group, name, gender, address, date, email);
        contacts.add(contact);
    }

    public void read(String nameFile) throws IOException {
        FileReader reader = new FileReader(nameFile);
        BufferedReader br = new BufferedReader(reader);
        String line;
        while ((line= br.readLine())!=null){
            String[] content = line.split(",");
            creatContact(content[0],content[1],content[2],content[3],content[4],content[5],content[6]);
        }
        br.close();
    }

    public void save(String nameFile) throws FileNotFoundException {
        try {
            FileOutputStream fos = new FileOutputStream(nameFile);
            for (Contact contact : contacts){
                byte[] bytes = contact.toString().getBytes();
                byte[] downLine = "\n".getBytes();
                fos.write(bytes);
                fos.write(downLine);
            }
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean checkEmail(String email){
        Pattern pattern = Pattern.compile(REGEX_FILE);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()){
            return true;
        }else return false;
    }

    public boolean checkNumberPhone(String numberPhone){
        for (Contact contact : contacts){
            if (contact.getNumberPhone().equals(numberPhone)){
                return true;
            }
        }
        return false;
    }
    public boolean checkTypeNumberPhone(String numberPhone){
        Pattern pattern1 = Pattern.compile(REGEX_NUMBER_PHONE);
        Matcher matcher = pattern1.matcher(numberPhone);
        if (matcher.matches()){
            return true;
        }else return false;
    }

}
