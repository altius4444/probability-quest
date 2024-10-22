import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class MCQTestFractions {
    public static void main(String[] args) {
        Scanner Scan = new Scanner(System.in);
        System.out.println("Enter number of iteration");
        int n = Scan.nextInt();
        List<Double> frequency = findCoefficient(n);
        double sum = 0;

        for (int i = 0; i < frequency.size(); i++) {
            System.out.println((i) + " = " + (i * 4 - (n - i)));
            sum += frequency.get(i);
        }

        List<Double> chance = new ArrayList<>();
        for (int i = 0; i < frequency.size(); i++) {
            chance.add(frequency.get(i) * 100.0 / sum);
        }

        double totalPos = 0, totalNeg = 0, totalZero = 0;
        for (int i = 0; i < chance.size(); i++) {
            if ((i * 4 - (n - i)) > 0) {
                totalPos += chance.get(i);
            } else if ((i * 4 - (n - i)) < 0) {
                totalNeg += chance.get(i);
            } else {
                totalZero += chance.get(i);
            }
        }

        System.out.println("Gain chance = " + totalPos + "%");
        System.out.println("Loss chance = " + totalNeg + "%");
        System.out.println("Balanced chance = " + totalZero + "%");
        System.out.println("\n" + chance);
    }

    static List<Double> findCoefficient(int n) {
        List<Double> row = new ArrayList<>();
        row.add(1.0);

        for (int k = 0; k < n; k++) {
            double nextValue = row.get(k) * (n - k) / (k + 1);
            row.add(nextValue);
        }

        return row;
    }
}
