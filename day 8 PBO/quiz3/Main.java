package quiz3;

public class Main {
    public static void main(String[] args) {
        Person[] people = {
            new Student("Micael", 20, "Jakarta", "20250801139", "Teknik Informatika"),
            new Teacher("SuperDhafaAlghiphari", 41, "Bandung", "198501012010", "Rekayasa Perangkat Lunak"),
            new Employee("AxelJehoue", 32, "Surabaya", "Staff IT", 7500000)
        };

        for (Person p : people) {
            p.info();
            p.work();
            System.out.println("------------------------");
        }
    }
}