package humans;

import enums.Emotions;
import enums.TypeOfShow;
import exceptions.NoFreeTvException;
import humans.Agent;
import humans.Human;
import humans.Lunatic;
import humans.Narrator;
import interfaces.Selling;
import notAlive.Show;

import java.util.ArrayList;
public class TvStudioOwner extends Human implements Selling {
    TvStudio tvStudio;
    ArrayList<Lunatic> renters;

    public TvStudioOwner(String name) {
        super(name);
        this.tvStudio = new TvStudio();
        this.renters = new ArrayList<>();
    }
    public void addParticipant(ArrayList<Human> p, Show s) {
        s.participants.addAll(p);

    }
    public void inviteToShow(Narrator n, Show s) {
        System.out.println(this.getName() + " приглашает на шоу " + s.getTitle() + " рассказчика: " + n.getName());
        Agent agent = n.getAgents().get(0);
        if(this.emotion!= Emotions.FEAR){
        agent.negotiate(Show.price);}
        else{
            agent.negotiate(n.royalty);
        }
        if (agent.getEmotion() == Emotions.DISSATISFACTION) {
            System.out.println(n.getName() + " отказался от участия");
        } else {
            System.out.println(n.getName() + " согласился участвовать");
            this.setAmountOfMoney(this.amountOfMoney-n.royalty);
            this.setEmotion(Emotions.SATISFACTION);
            s.participants.add(n);
        }
    }
    @Override
    public void sell(Lunatic lunatic) throws NoFreeTvException {
        if (!this.tvStudio.TVs.isEmpty()) {
            lunatic.setTv(this.tvStudio.TVs.get(0));
            this.renters.add(lunatic);
            this.tvStudio.TVs.remove(0);
            System.out.println("Телевизор продан " + lunatic.getName());
        } else {
            throw new NoFreeTvException("Свободных телевизоров нет");
        }
    }

    public Show createShow(String title, TypeOfShow type) {
        Show s = new Show(title, type);
        TvStudio.TV.listOFShow.add(s);
        return s;
    }

    public void startShows() {

        for (Lunatic lunatic : this.renters) {
            lunatic.watch();
        }
        for (int i = 0; i < TvStudio.TV.listOFShow.size(); i++) {
            Show show = TvStudio.TV.listOFShow.get(i);
            if (show.isRun) {
                TvStudio.TV.listOFShow.remove(show);
            }
        }
    }

    @Override
    public String getName() {
        return "Хозяин студии " + super.getName();
    }

    @Override
    public void setAmountOfMoney(int amountOfMoney) {
        if(amountOfMoney< this.amountOfMoney){
            System.out.println(this.getName() + " потратил " + (this.amountOfMoney-amountOfMoney));
        } else if(this.amountOfMoney==amountOfMoney & this.emotion!=Emotions.FEAR){
            this.setEmotion(Emotions.FEAR);
        } else {
            System.out.println(this.getName()+ " заработал " + (- this.amountOfMoney + amountOfMoney));
        }
        }

    public static class TvStudio {
        ArrayList<TV> TVs;

        TvStudio() {

            this.TVs = new ArrayList<>() {
                {
                    add(new TV());
                    add(new TV());
                    add(new TV());
                }
            };
        }
        public static class Hall{
            public Show show;
            public Hall(Show show){
                this.show=show;
            }
            static class Table{
                static ArrayList<Human> humans=new ArrayList<>();
            }
        }
        public class TV {
            static int rentalPrice = 100;
            Lunatic ownerTv;
            TV() {
                listOFShow = new ArrayList<>();
            }

            static ArrayList<Show> listOFShow;

            public void setOwnerTv(Lunatic ownerTv) {
                this.ownerTv = ownerTv;
            }
            ArrayList<Show> start() {

                ArrayList<Show> ShowOn = new ArrayList<>();
                for (Show show : listOFShow) {

                    if (!show.getParticipants().isEmpty()) {
                        ShowOn.add(show);
                        show.isRun = true;
                    }
                }

                    return ShowOn;
            }
        }
    }
}


