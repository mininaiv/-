import java.math.BigInteger;
import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        //Money
      try {
            Scanner input = new Scanner(System.in);
            Money money1 = new Money(25, 50);
            Money money2 = new Money(10, 50);

            String sum = money1.add(money2);
            System.out.println("Сумма: " + sum);
            Money dif = money1.minus(money2);
            System.out.println("Разница: " + dif);
            Money division = money1.divide(2);
           System.out.println("Деление на 5: " + division + "\n\n");
      }catch(ArithmeticException e){
           System.out.println("Ошибка: " + e.getMessage());
       }

       //Vector
        int x1 = 1;
        int y1 = 2;
        int z1 = 3;
        int x2 = 3;
        int y2 = 2;
        int z2 = 1;
        Vector vector1 = new Vector(x1, y1, z1, x2, y2, z2);

        int x3 = 2;
        int y3 = 3;
        int z3 = 1;
        int x4 = 4;
        int y4 = 2;
        int z4 = 1;
        Vector vector2 = new Vector(x3, y3, z3, x4, y4, z4);

        Vector sum = vector1.add(vector2);
        System.out.println("Summ: " + sum);
        Vector sub = vector1.subtract(vector2);
        System.out.println("Subtract: " + sub);
        double lenght = vector1.lenght();
        double lenght2 = vector2.lenght();
        System.out.println("Lenght of vector1: " + lenght);
        System.out.println("Lenght of vector2: " + lenght2 + "\n\n");

        //Drob
        try {
            Fractions fraction1 = new Fractions(new BigInteger("10"), (short) 5000);
            Fractions fraction2 = new Fractions(new BigInteger("5"), (short) 2500);

            Fractions sumDr = fraction1.add(fraction2);
            System.out.print("Сумма: ");
            sumDr.print();

            Fractions difference = fraction1.subtract(fraction2);
            System.out.print("Разность: ");
            difference.print();

            Fractions product = fraction1.multiply(fraction2);
            System.out.print("Произведение: ");
            product.print();

            int comparison = fraction1.compareTo(fraction2);
            System.out.println("Сравнение: " + comparison);

            System.out.print("Исходная дробь 1: ");
            fraction1.print();
            System.out.print("Исходная дробь 2: ");
            fraction2.print();

            System.out.println("Сокращение дроби 1:");
            fraction1.reduce();
            fraction1.print();

            System.out.println("Сокращение дроби 2:");
            fraction2.reduce();
            fraction2.print();
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }


    }
}
