package obiectesiclase;

public class Person {
    private String name;
    private String phone;
    private String phonejob;
    static int nrPersons;


    public String getName() {
        return name;
    }
    public String getPhone() {
        return phone;
    }

    public String getPhonejob() {
        return phonejob;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPhonejob(String phonejob) {
        this.phonejob = phonejob;
    }

    Person(String name) {
        this.name=name;
        nrPersons++;
    }

    Person(String name, String phone) {
        this.name=name;
        this.phone=phone;
        nrPersons++;
    }
}

