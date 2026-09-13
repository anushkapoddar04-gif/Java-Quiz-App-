public class Question {

    private String question;
    private String[] options;
    private char correctAnswer;
    private String category;

    public Question(String question, String[] options,
                    char correctAnswer, String category) {

        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
        this.category = category;
    }

    public void displayQuestion(int number) {

        System.out.println("\nQuestion " + number + ": " + question);

        for (String option : options) {
            System.out.println(option);
        }

        System.out.println("Category: " + category);
    }

    public boolean checkAnswer(char answer) {
        return Character.toUpperCase(answer) == correctAnswer;
    }

    public char getCorrectAnswer() {
        return correctAnswer;
    }
}