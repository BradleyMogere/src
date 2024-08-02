import java.text.DecimalFormat;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Comparator;

public class Transactions {

    static class Transaction {
        double amount;

        private static final DecimalFormat df = new DecimalFormat("0.00");

        Transaction(double amount) {
            this.amount = amount;
        }

        public double getAmount() {
            return amount;
        }

        @Override
        public String toString() {
            return "Transaction{amount=" + df.format(amount) + "}";
        }
    }

    public static Transaction[] findTop10Transactions(Transaction[] transactions) {
        PriorityQueue<Transaction> minHeap = new PriorityQueue<>(Comparator.comparingDouble(Transaction::getAmount));

        for (Transaction transaction : transactions) {
            if (minHeap.size() < 10) {
                minHeap.offer(transaction);
            } else if (transaction.getAmount() > minHeap.peek().getAmount()) {
                minHeap.poll();
                minHeap.offer(transaction);
            }
        }

        Transaction[] top10Transactions = new Transaction[minHeap.size()];
        for (int k = minHeap.size() - 1; k >= 0; k--) {
            top10Transactions[k] = minHeap.poll();
        }
        Arrays.sort(top10Transactions, Comparator.comparingDouble(Transaction::getAmount).reversed());
        return top10Transactions;
    }

    public static void main(String[] args) {
        Transaction[] transactions = new Transaction[100];
        for (int k = 0; k < 10; k++) {
            transactions[k] = new Transaction(Math.random() * 1000);
        }

        Transaction[] top10Transactions = findTop10Transactions(transactions);
        System.out.println("Top 10 Transactions are as follows: ");
        for (Transaction transaction : top10Transactions) {
            System.out.println(transaction);
        }
    }
}
