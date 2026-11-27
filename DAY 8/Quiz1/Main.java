package quiz1;

// Main Class
public class Main {
    public static void main(String[] args) {
        Lecturer e1 = new Lecturer();
        System.out.println("Lecturer in UEU");
        System.out.println("Salary : " + e1.salary + "\nBenefit : " + e1.benefits);
        System.out.println();

        Staff e2 = new Staff();
        System.out.println("Staff in UEU");
        System.out.println("Salary : " + e2.salary + "\nBenefit : " + e2.benefits
                + "\nOvertime : " + e2.overtime);
        System.out.println();

        Manager e3 = new Manager();
        System.out.println("Manager in UEU");
        System.out.println("Salary : " + e3.salary + "\nBenefit : " + e3.benefits
                + "\nBonus : " + e3.bonus);
    }
}