package humans;
import interfaces.*;
import enums.*;
import java.util.Objects;

public class Journalist extends Questioner {

    public TypeOfPress press;
    public Journalist(String name, Question question, TypeOfPress press){
        super(name,question);
        this.press=press;

    }

    @Override
    public void ask(Question question, Narrator n) {
        super.ask(question, n);
    }

    @Override
    public String toString() {
        return "журналист по имени" + this.name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj ==this) {
        return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Journalist j = (Journalist) obj;
        return this.name.equals(j.name) && this.question.equals(j.question) || (this.name != null && this.name.equals(j.name) && this.question.equals(j.question)) || (this.question!= null && this.name.equals(j.name) && this.question.equals(j.question) ) ;

        }

    @Override
    public int hashCode() {
        return Objects.hash(name, question);
    }

    @Override
    public boolean makeSatisfaction() {
        return super.makeSatisfaction();
    }
}

