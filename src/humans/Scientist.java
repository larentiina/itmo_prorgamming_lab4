package humans;

import enums.*;
import interfaces.*;
import notAlive.*;
import java.util.ArrayList;
import java.util.Objects;

public class Scientist extends Questioner implements Appeable {

    public Sciences sciences;

    public Scientist(String name, Question question, Sciences sciences){
        super(name,question);
        this.sciences=sciences;
        question.setAsked(true);
    }

    @Override
    public void ask(Question question, Narrator n) {
        super.ask(question, n);
    }

    @Override
    public String toString() {
        return "учёный по имени" + this.name;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj ==this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Scientist s = (Scientist) obj;
        return this.name.equals(s.name) && this.question.equals(s.question) || (this.name.equals(s.name) && this.question.equals(s.question)) || (this.question!= null && this.name.equals(s.name) && this.question.equals(s.question) );

    }
    public int hashCode() {
        return Objects.hash(name, question);
    }

    @Override
    public boolean makeSatisfaction() {
        return super.makeSatisfaction();
    }

    @Override
    public void appeal(ArrayList<Lunatic> toApplied, Narrator aboutWhom) {
        System.out.println(this.getName()+" обращается к телезрителям с тем, что");
        if(aboutWhom.theAmountOfUsefullness>5)
        {
            System.out.println(aboutWhom.getName()+ " внёс большой вклад в развитие науки");
        }
        else
            System.out.println(aboutWhom.getName()+ " не внёс ощутимый вклад в развитие науки");

    }

    @Override
    public void sit(TvStudioOwner t) {

    }
}


