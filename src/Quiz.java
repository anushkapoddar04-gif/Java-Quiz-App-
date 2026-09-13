import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Quiz {

    private ArrayList<Question> questions;
    private int score;

    public Quiz() {

        questions = new ArrayList<>();
        score = 0;

        addQuestions();
    }

    private void addQuestions() {

        // Java Questions

        questions.add(new Question(
                "Which keyword is used to create a class in Java?",
                new String[]{
                        "A. object",
                        "B. class",
                        "C. create",
                        "D. new"
                },
                'B',
                "Java"
        ));

        questions.add(new Question(
                "Which method is the starting point of a Java program?",
                new String[]{
                        "A. start()",
                        "B. run()",
                        "C. main()",
                        "D. begin()"
                },
                'C',
                "Java"
        ));

        questions.add(new Question(
                "Which data type is used to store whole numbers?",
                new String[]{
                        "A. float",
                        "B. String",
                        "C. boolean",
                        "D. int"
                },
                'D',
                "Java"
        ));

        questions.add(new Question(
                " Which access modifier makes a member accessible from classes in the same package and also from subclasses outside the package?,",
                new String[]{
                        "A. private",
                        "B. protected",
                        "C. public",
                        "D. default"
                },
                'B',
                "Java"
        ));

        // Python Questions

        questions.add(new Question(
                " If int[] arr = {10, 20, 30, 40, 50}, what is the value of arr[arr.length - 2]?",
                new String[]{
                        "A. 30",
                        "B. 40",
                        "C. 50",
                        "D. 20"
                },
                'B',
                "Java"
        ));

        questions.add(new Question(
                "What is the main purpose of an interface in java? ",
                new String[]{
                        "A.To create objects directly without a class ",
                        "B. To replace every use of inheritance",
                        "C. To store only private instance variables",
                        "D. To provide a contract that implementing classes on follow"
                },
                'D',
                "Java"
        ));

        questions.add(new Question(
                "Which of the following are true about the final keyword in Java?" ,
                new String[]{
                    "A. A final variable can be assigned only once.",
                    "B. A final class cannot be inherited.",
                    "C. A final method cannot be overridden.",
                    "D. A final object reference makes the referenced object immutable."
                },
                'B',
                "Python"
        ));

        // DSA Questions

        questions.add(new Question(
                "Which data structure follows FIFO?",
                new String[]{
                        "A. Stack",
                        "B. Queue",
                        "C. Tree",
                        "D. Graph"
                },
                'B',
                "DSA"
        ));

        questions.add(new Question(
                "Which data structure follows LIFO?",
                new String[]{
                        "A. Queue",
                        "B. Array",
                        "C. Stack",
                        "D. Graph"
                },
                'C',
                "DSA"
        ));

        questions.add(new Question(
                "What is the time complexity of binary search?",
                new String[]{
                        "A. O(n)",
                        "B. O(n²)",
                        "C. O(log n)",
                        "D. O(1)"
                },
                'C',
                "DSA"
        ));
    }

    public void startQuiz() {

        Scanner scanner = new Scanner(System.in);

        // Shuffle questions
        Collections.shuffle(questions);

        System.out.println("\n================================");
        System.out.println("        QUIZ STARTED");
        System.out.println("================================");

        int questionNumber = 1;

        for (Question question : questions) {

            question.displayQuestion(questionNumber);

            char answer;

            while (true) {

                System.out.print("Enter your answer (A/B/C/D): ");

                String input = scanner.next().toUpperCase();

                if (input.length() == 1 &&
                    (input.charAt(0) == 'A' ||
                     input.charAt(0) == 'B' ||
                     input.charAt(0) == 'C' ||
                     input.charAt(0) == 'D')) {

                    answer = input.charAt(0);
                    break;

                } else {

                    System.out.println(
                            "Invalid input! Please enter A, B, C or D."
                    );
                }
            }

            if (question.checkAnswer(answer)) {

                System.out.println("✓ Correct!");
                score++;

            } else {

                System.out.println("✗ Wrong!");
                System.out.println(
                        "Correct answer: " +
                        question.getCorrectAnswer()
                );
            }

            questionNumber++;
        }

        showResult();

        scanner.close();
    }

    private void showResult() {

        int totalQuestions = questions.size();

        double percentage =
                ((double) score / totalQuestions) * 100;

        System.out.println("\n================================");
        System.out.println("          QUIZ RESULT");
        System.out.println("================================");

        System.out.println(
                "Total Questions: " + totalQuestions
        );

        System.out.println(
                "Correct Answers: " + score
        );

        System.out.println(
                "Wrong Answers: " + (totalQuestions - score)
        );

        System.out.printf(
                "Percentage: %.2f%%\n",
                percentage
        );

        if (percentage == 100) {

            System.out.println(
                    "Excellent! Perfect Score!"
            );

        } else if (percentage >= 70) {

            System.out.println(
                    "Great Job! Keep it up!"
            );

        } else if (percentage >= 50) {

            System.out.println(
                    "Good! But keep practicing."
            );

        } else {

            System.out.println(
                    "Keep practicing. You can do better!"
            );
        }

        System.out.println("================================");
    }
}