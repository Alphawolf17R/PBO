import java.util.Scanner;

public class Hitungluasbola{
    public static void main(String[] args){
        Scanner input= new Scanner(System.in);
        double r, luas;
        System.out.print("Masukkan jari jari bola : ");
        r = input.nextDouble();
        luas = 4 * Math.PI * Math.pow(r,2);
        System.out.print("Luas permukaan bola adalah : " + Math.round(luas)); 
        input.close();
    }
}