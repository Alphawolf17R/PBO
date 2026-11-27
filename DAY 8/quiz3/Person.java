package quiz3;

public class Person {
    protected String name;
    protected int age;
    protected String address;

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public void info() {
        System.out.println("Nama   : " + name);
        System.out.println("Umur   : " + age + " tahun");
        System.out.println("Alamat : " + address);
    }

    public void work() {
        System.out.println("Aktivitas : -");
    }
}