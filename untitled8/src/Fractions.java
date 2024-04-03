import java.math.BigInteger;

public class Fractions {
    private BigInteger wholePart; // целая часть
    private short fractionalPart; // дробная часть

    public Fractions(BigInteger wholePart, short fractionalPart) {
        this.wholePart = wholePart;
        this.fractionalPart = fractionalPart;
    }

    public Fractions add(Fractions other) {
        BigInteger resultWholePart = this.wholePart.add(other.wholePart);
        short resultFractionalPart = (short) (this.fractionalPart + other.fractionalPart);

        // Проверяем переполнение дробной части
        if (resultFractionalPart > 9999) {
            resultWholePart = resultWholePart.add(BigInteger.ONE);
            resultFractionalPart -= 10000;
        }

        return new Fractions(resultWholePart, resultFractionalPart);
    }

    public Fractions subtract(Fractions other) {
        BigInteger resultWholePart = this.wholePart.subtract(other.wholePart);
        short resultFractionalPart = (short) (this.fractionalPart - other.fractionalPart);

        // Проверяем переполнение дробной части
        if (resultFractionalPart < 0) {
            resultWholePart = resultWholePart.subtract(BigInteger.ONE);
            resultFractionalPart += 10000;
        }

        return new Fractions(resultWholePart, resultFractionalPart);
    }

    public Fractions multiply(Fractions other) {
        BigInteger resultWholePart = this.wholePart.multiply(other.wholePart);
        short resultFractionalPart = (short) (this.fractionalPart * other.fractionalPart);

        // Проверяем переполнение дробной части
        if (resultFractionalPart > 9999) {
            resultWholePart = resultWholePart.add(BigInteger.ONE);
            resultFractionalPart -= 10000;
        }

        return new Fractions(resultWholePart, resultFractionalPart);
    }

    public int compareTo(Fractions other) {
        int wholeComparison = this.wholePart.compareTo(other.wholePart);
        if (wholeComparison != 0) {
            return wholeComparison;
        }
        return Short.compare(this.fractionalPart, other.fractionalPart);
    }

    public void reduce() {
        BigInteger gcd = this.wholePart.gcd(BigInteger.valueOf(this.fractionalPart));
        this.wholePart = this.wholePart.divide(gcd);
        this.fractionalPart = (short) (this.fractionalPart / gcd.shortValue());
    }

    public void print() {
        System.out.println(wholePart + "." + String.format("%04d", fractionalPart));
    }

    public static void main(String[] args) {
        try {
            Fractions fraction1 = new Fractions(new BigInteger("10"), (short) 5000);
            Fractions fraction2 = new Fractions(new BigInteger("5"), (short) 2500);

            Fractions sum = fraction1.add(fraction2);
            System.out.print("Сумма: ");
            sum.print();

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