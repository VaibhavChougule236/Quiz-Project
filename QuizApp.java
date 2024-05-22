//package Project2;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question {
    private String questionText;
    private String[] options;
    private int correctAnswerIndex;

    public Question(String questionText, String[] options, int correctAnswerIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }

    
    public boolean isCorrect(int answerIndex) {
        return answerIndex == correctAnswerIndex;
    }

    public void displayQuestion() {
        System.out.println(questionText);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ": " + options[i]);
        }
    }
}

class Quiz {
    private List<Question> questions;
    private int score;

    public Quiz() {
        this.questions = new ArrayList<>();
        this.score = 0;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public Question getQuestion(int index) {
        if (index >= 0 && index < questions.size()) {
            return questions.get(index);
        }
        return null;
    }

    public int getNumberOfQuestions() {
        return questions.size();
    }

    
    public void incrementScore() {
        score++;
    }

    public int getScore() {
        return score;
    }

}


 public class QuizApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Quiz quiz = new Quiz();

        String questionText1 = "Who is king of forest?";
        String[] options1 = {"Lion", "Tiger", "Monkey", "Elephant"};
        int correctAnswerIndex1 = 0;

        String questionText2 = "capital of India?";
        String[] options2 = {"Mumbai", "Chennai", "Dheli", "Hydrabad"};
        int correctAnswerIndex2 = 2;

        quiz.addQuestion(new Question(questionText1, options1, correctAnswerIndex1));
        quiz.addQuestion(new Question(questionText2, options2, correctAnswerIndex2));

        for (int i = 0; i < quiz.getNumberOfQuestions(); i++) {
            Question question = quiz.getQuestion(i);
            question.displayQuestion();
            int userAnswer = -1;

            while (userAnswer < 1 || userAnswer > question.getOptions().length) {
                System.out.print("Your answer (1-" + question.getOptions().length + "): ");
                if (scanner.hasNextInt()) {
                    userAnswer = scanner.nextInt();
                } else {
                    System.out.println("Invalid input.");
                    scanner.next(); 
                }
            }

            if (question.isCorrect(userAnswer - 1)) {
                System.out.println("Correct!");
                quiz.incrementScore();
            } else {
                System.out.println("Incorrect. The correct answer is: " + (question.getCorrectAnswerIndex() + 1));
            }
            System.out.println();
        }

        System.out.println(" Your score: " + quiz.getScore() + "/" + quiz.getNumberOfQuestions());
    }
}
