import humans.*;
import enums.*;

import exceptions.*;
import notAlive.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws NoFreeTvException {


        Narrator n1 = new Narrator("Незнайка");
        Agent a1= new Agent("Мига",n1);
        Agent a2 = new Agent("Жулио",n1);
        n1.setAgents(a1);
        n1.setAgents(a2);


        HotelOwner h1=new HotelOwner("господин Хапс");
        a1.negotiate(h1);
        a2.negotiate(h1);

        Lunatic l1=new Lunatic("Kate");
        Lunatic l2 = new Lunatic("Masha");
        Lunatic l3 = new Lunatic("Козлик");


        TvStudioOwner t1 = new TvStudioOwner("Mike");
        l1.buy(t1);
        l2.buy(t1);




        Show sh1=t1.createShow("Космическая Конференция", TypeOfShow.CONFERENCE);
        t1.inviteToShow(n1,sh1);
        t1.createShow("Спектакль",TypeOfShow.PERFORMANCE);

        t1.startShows();
        l1.negotiate(t1);
        l2.negotiate(t1);
        t1.inviteToShow(n1,sh1);

        t1.startShows();


        Question q3 = new Question("food", Actions.EAT);
        Journalist j1 = new Journalist("Журналист 1",q3, TypeOfPress.MAGAZINE);
        Question q4 = new Question("drinks",Actions.DRINK);
        Journalist j2 = new Journalist("Журналист 2",q4,TypeOfPress.MAGAZINE);
        Question q5 = new Question("dreams",Actions.SEE);
        Journalist j3 = new Journalist("Журналист 3",q5,TypeOfPress.NEWSPAPER);
        Question q1 = new Question("Davilon city",Actions.LIKE);
        q1.setFeatures("citizens");
        Journalist j4 = new Journalist("Журналист 4",q1,TypeOfPress.NEWSPAPER);
        Question q6 = new Question("space travel",Actions.SEE);
        Scientist s1 = new Scientist("Учёный 1",q6, Sciences.CHEMISTRY);
        Question q2 = new Question("moon",Actions.SEE);
        q2.setFeatures("surface");
        Scientist s3 = new Scientist("Учёный 3",q2,Sciences.ASTRONOMY);
        Question q7 = new Question("The BigEarth",Actions.LOOK);
        Scientist s2 = new Scientist("Учёный 2",q7,Sciences.MATHEMATICS);

        t1.addParticipant(new ArrayList<>(){
            {
                add(j1);
                add(j2);
                add(j3);
                add(j4);
                add(s1);
                add(s2);
                add(s3);
            }
        }, sh1);
        t1.startShows();
        TvStudioOwner.TvStudio.Hall hall=new TvStudioOwner.TvStudio.Hall(sh1);
        a1.sit(t1);
        a2.sit(t1);
        n1.sit(t1);
        l3.sit(t1);


        Rocket rocket = new Rocket();
        n1.talk(rocket.device);
        n1.talk(rocket.management);
        j1.ask(q3,n1);
        j2.ask(q4,n1);
        j3.ask(q5,n1);
        j4.ask(q1,n1);
        s1.ask(q6,n1);
        s3.ask(q2,n1);
        s2.ask(q7,n1);

        Show sh3 = t1.createShow("Беседа",TypeOfShow.CONFERENCE);
        Question q8 = new Question("The BigEarth",Actions.LOOK);
        q8.setFeatures("Sky");
        q8.setFeatures("Stars");
        q8.setFeatures("Constellations");
        Question q9 = new Question("The BigEarth", Actions.LOOK);
        q9.setFeatures("Sun");
        q9.setFeatures("Moon");
        Scientist s4 = new Scientist("Альфа",q8,Sciences.ASTRONOMY);
        Scientist s5 = new Scientist("Мемега",q9,Sciences.LUNOLOGY);
        t1.addParticipant(new ArrayList<>(){
            {
                add(n1);
                add(s4);
                add(s5);
            }
        }, sh3);
        t1.startShows();
        s4.ask(q8,n1);
        s5.ask(q9,n1);
        s4.appeal(new ArrayList<>(){{add(l1);add(l2);}},n1);

    }
}