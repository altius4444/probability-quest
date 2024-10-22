import java.util.Scanner;

public class MCQTestMarks {
    public static void main(String[] args) {
        Scanner Scan = new Scanner(System.in);
        System.out.println("Enter number of iterations (1,000,000 questions per iteration)");
        int n = Scan.nextInt();
        System.out.println("Do you want to see result of each iteration? (Yes/No)");
        boolean show = Scan.next().equalsIgnoreCase("Yes");
        int totalCorrect = 0, totalWrong = 0;
        for (int i = 1; i <= n; i++) {
            String result = MCQTestMarks.run(i, show);
            int curCount = Integer.parseInt(result.substring(0, result.indexOf(' ')));
            int curWrong = Integer.parseInt(result.substring(
                    (result.indexOf(' ') + 1)));
            totalCorrect += curCount;
            totalWrong += curWrong;
        }
        System.out.println("\n\n\n");
        System.out.println("Average correct % = " + (totalCorrect * 100.0 / (n * 1000000)));
        System.out.println("Average wrong % = " + (totalWrong * 100.0 / (n * 1000000)));
        System.out.println("Average correct = " + (totalCorrect / n));
        System.out.println("Average wrong = " + (totalWrong / n));
        System.out.println("Average marks per question = " + (
                ((4.0 * totalCorrect) - totalWrong) / (n * 1000000)
                ));
    }

    static String run(int iteration, boolean show) {
        double guess = (int) (Math.random() * 4);
        int count = 0;
        int wrongCount = 0;
        int total = 1000000;
        for (int i = 1; i <= total; i++) {
            int currentAnswer = (int) (Math.random() * 4);
            if (guess == currentAnswer) {
                count++;
            } else {
                wrongCount++;
            }
        }
        if (show) {
            System.out.println("\nIteration " + iteration);
            System.out.println(count);
            System.out.println(wrongCount);
            System.out.println("Correct % = " + (count * 100.0 / total));
            System.out.println("Wrong % = " + (wrongCount * 100.0 / total));
            System.out.println("Gross marks = " + ((4 * count) - wrongCount));
        }
        return count + " " + wrongCount;
    }
}
