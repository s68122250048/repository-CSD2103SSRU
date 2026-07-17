import java.util.Scanner;

public class ArrayScore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] score = new int[5];
        int sum = 0;

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter score " + (i+1) + ": ");
            score[i] = sc.nextInt();
            sum += score[i];
        }

        double avg = (double) sum / 5;

        System.out.println("Total score = " + sum);
        System.out.println("Average score = " + avg);
    }
}