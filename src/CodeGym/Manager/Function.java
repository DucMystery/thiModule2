package CodeGym.Manager;

import CodeGym.ContactList.ContactList;
import CodeGym.Model.Contact;

public interface Function {

    void displayAll();
    void deleteContactByNumberPhone(String numberPhone);
    String searchByNumberPhone(String numberPhone);
    void addContact(Contact contact);


}
