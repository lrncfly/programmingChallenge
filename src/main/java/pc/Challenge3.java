package pc;

public class Challenge3 {
    private int travellers;

    public static void main(String[] args) {
        double[] expenses = new double[] { 10.00, 20.00, 30.00 };
        Challenge3 c = new Challenge3(3);
        double exchange = c.difference(expenses, c.average(expenses));
        System.out.println(exchange);
        expenses = new double[] { 15.00, 15.01, 3.00, 3.01 };
        c = new Challenge3(4);
        exchange = c.difference(expenses, c.average(expenses));
        System.out.println(exchange);
        expenses = new double[] { 9999.10, 9999.1, 9999.00, 9999.1 };
        c = new Challenge3(4);
        exchange = c.difference(expenses, c.average(expenses));
        System.out.println(exchange);
    }

    public Challenge3(int travellers) {
        this.travellers = travellers;
    }

    public double average(double[] values) {
        double total = 0;
        for (double value : values) {
            total = Math.round((total + value) * 100) / 100d;
        }
        return ((int) ((total / this.travellers) * 100)) / 100d;
    }

    public double difference(double[] expenses, double average) {
        double total = 0;
        for (double expense : expenses) {
            if (expense < average)
                total = ((int) ((total + average - expense) * 100)) / 100d;
        }
        return total;
    }
}
