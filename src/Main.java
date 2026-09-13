import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("       JAVA QUIZ APPLICATION");
        System.out.println("================================");

        System.out.println("\nWelcome to the Quiz!");

        System.out.print("\nEnter your name: ");

        String name = scanner.nextLine();

        System.out.println(
                "\nHello, " + name + "!"
        );

        System.out.println(
                "Test your knowledge with this quiz."
        );

        System.out.print(
                "\nPress Enter to start..."
        );

        scanner.nextLine();

        Quiz quiz = new Quiz();

        quiz.startQuiz();
    }
}