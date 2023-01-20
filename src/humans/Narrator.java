package humans;

import enums.*;

import exceptions.*;
import interfaces.*;
import notAlive.*;
import java.util.ArrayList;
import java.util.Objects;

public class Narrator extends Human implements Talking {


    private ArrayList<Agent> agents;
    public int royalty = 150;
    public int theAmountOfUsefullness=0;

    public Narrator(String name){
        super(name);
        this.agents= new ArrayList<>();
    }


    @Override
    public void talk(String s) {
        System.out.println(this.name + " рассказывает про " + s);

    }

    @Override
    public void answer(Question q) throws QuestionIsAnswered{
        if (!q.isAnswered()) {
            q.setAnswered(true);
            System.out.println(this.name + " отвечает на вопрос про: " + q.getQuestionsubject());
            if (q.getQuestionsubject().equals("The BigEarth")) {
                BigEarth b = new BigEarth();
                if (q.getAct() == Actions.LOOK) {
                    if (q.getFeatures().isEmpty())
                        System.out.println("Вот так выглядит Земля: " + b.EarthLooksLike);
                    for (String s : q.getFeatures()) {

                        switch (s) {

                            case "Sky" -> System.out.println("Земля выглядит:" + BigEarth.Sky.looksLike);
                            case "Shell" -> {
                                if (!b.isHardshell) {
                                    System.out.println("Оболочка не твёрдая");
                                    q.getQuestioner().setEmotion(Emotions.SURPRISE);
                                } else {
                                    System.out.println("Оболочка твёрдая");
                                }
                            }
                            case "Moon" -> System.out.println("Луна выглядит: " + BigEarth.Sky.moonLooksLike);
                            case "Sun" -> System.out.println("Солнце выглядит: " + BigEarth.Sky.sunLooksLike);
                            case "Stars" -> {
                                System.out.print("Вот такие звёзды есть: ");
                                for (String st : BigEarth.Sky.stars) {
                                    System.out.print(st + ' ');
                                }
                                System.out.println();
                            }
                            case "Constellations" -> {
                                System.out.print("Вот такие созвездия есть: ");
                                for (String st : BigEarth.Sky.constellations) {
                                    System.out.print(st + ' ');
                                }
                                System.out.println();
                            }
                            default -> System.out.println();
                        }
                    }
                }
            }
        } else {
            throw new QuestionIsAnswered("Вопрос уже был");
        }
    }
    public void setAgents(Agent agent) {
        agents.add(agent);
    }
    public ArrayList<Agent> getAgents() {
        return agents;
    }

    @Override
    public String toString() {
        return "Рассказчик по имени" + this.name;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj ==this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Narrator n = (Narrator) obj;
        return this.name.equals(n.name);

    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
