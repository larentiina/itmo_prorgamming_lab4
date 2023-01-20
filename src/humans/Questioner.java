package humans;

import exceptions.QuestionIsAnswered;
import interfaces.Asking;

abstract class Questioner extends Human implements Asking {

    Question question;
    boolean satisfaction;

    Questioner(String name, Question question) {
        super(name);
        this.question = question;
        question.setQuestioner(this);
        question.setAsked(true);
    }

    public void ask(Question question, Narrator n) {

        if (question.equals(this.question)) {
            System.out.println(this.name + " Задаёт вопрос про объект:" + question.getQuestionsubject());
            System.out.println("Действие совершаемое с объектом вопроса: " + question.getAct().str());

            {
                if (!question.getFeatures().isEmpty()) {
                    System.out.print("а конкретно про: ");
                    for (String s : question.getFeatures()) {
                        System.out.print(s + " ");
                    }
                    System.out.println();

                }
            }

        } else
            System.out.println(this.name + "не может задать этот вопрос");
        if (Math.random() <= 0.9) {
            try {
                n.answer(question);
            } catch (QuestionIsAnswered e) {
                System.out.println("Был ли ответ на вопрос?" + question.isAnswered());
            }
        }

        if(makeSatisfaction()){
            n.theAmountOfUsefullness+=1;
        }
    }
        public boolean makeSatisfaction(){
            if (this.question.isAnswered() && this.question.isAsked()) {
                this.satisfaction = true;
                //System.out.println(this.name + " доволен ответом");
                return true;
            } else if (!this.question.isAnswered() && this.question.isAsked()) {
                //System.out.println(this.name + " недоволен");
                return false;
            }
            return false;
        }
    }


