package Quiz1;
// superclass
public class Employee {
   int salary = 40000;

   public static void main(String[] args) {
      Lecturer lecturer = new Lecturer();
      System.out.println("Lecturer Salary");
      System.out.println("Salary: " + lecturer.salary + "\nBenefits: " + lecturer.benefits);
   }
}

// subclass
class Lecturer extends Employee {
   int benefits = 10000;
}

class Staff extends Employee {
   int benefits = 5000;
   public void display() {
      System.out.println("Salary: " + salary);
      System.out.println("Benefits: " + benefits);
   }
}
 class Manager extends Staff {
   int benefitsManager = 20000;
}

class Director extends Manager {
   int benefitsDirector = 30000;
}