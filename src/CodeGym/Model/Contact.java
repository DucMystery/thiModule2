package CodeGym.Model;

public  class Contact {
    private String numberPhone;
    private String group;
    private String name;
    private String gender;
    private String address;
    private String date;
    private String email;

    public String getNumberPhone() {
        return numberPhone;
    }

    public String getGroup() {
        return group;
    }

    public Contact setGroup(String group) {
        this.group = group;
        return this;
    }

    public String getName() {
        return name;
    }

    public Contact setName(String name) {
        this.name = name;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public Contact setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Contact setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getDate() {
        return date;
    }

    public Contact setDate(String date) {
        this.date = date;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Contact setEmail(String email) {
        this.email = email;
        return this;
    }

    public Contact(String numberPhone, String group, String name, String gender, String address, String date, String email) {
        this.numberPhone = numberPhone;
        this.group = group;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.date = date;
        this.email = email;
    }

    @Override
    public String toString() {
        return getNumberPhone()+","+getGroup()+","+getName()+","+getGender()+","+getAddress()+","+getDate()+","+getEmail();
    }
}
