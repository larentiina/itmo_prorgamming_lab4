package exceptions;

public class QuestionIsAnswered extends RuntimeException{
    public QuestionIsAnswered(String message) {
        super(message);
    }
}
