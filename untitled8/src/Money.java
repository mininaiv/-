public class Money {
    private long rubls;
    private byte kopecs;

    public Money(long rubls, byte kopecs) {
        this.rubls = rubls;
        this.kopecs = kopecs;
    }

    public Money(long rubls, int kopecs) {
    }

    public String add(Money other) {
        long sumR = this.rubls + other.rubls;
        int sumK = this.kopecs + other.kopecs;

        if (sumK >= 100) {
            sumK -= 100;
            sumR++;
        }
        String str = sumR + "." + sumK;

        return str;
    }
    
    public Money minus(Money other){
        long deltRubls = this.rubls - other.rubls;
        int deltKopecs = this.kopecs - other.kopecs;
        
        if(deltKopecs < 0){
            deltKopecs += 100;
            deltRubls--;
        }

        return new Money(deltRubls, (byte)deltKopecs);
    }
    
    public Money divide(double delitel){
        double generalMoney = this.rubls + (double)this.kopecs/100;
        generalMoney /= delitel;
        long resultRubls = (long)generalMoney;
        byte resultKopecs = (byte)((generalMoney - resultRubls)*100);
        if(delitel == 0){
            throw new ArithmeticException("Деление на 0");
        }
        return new Money(resultRubls, resultKopecs);
    }
    @Override
    public String toString(){
        return rubls + "." + String.format("%02d",kopecs);
    }
}