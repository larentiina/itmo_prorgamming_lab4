package interfaces;
import humans.*;
import exceptions.*;
public interface Talking {
    void talk(String s);
    void answer(Question q) throws QuestionIsAnswered;
}
