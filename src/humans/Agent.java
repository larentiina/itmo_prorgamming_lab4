package humans;

import enums.Emotions;
import interfaces.BeingOnTv;

public class Agent extends Human {
    private Narrator employer;


    public Agent(String name, Narrator employer){
        super(name);
        this.employer=employer;
        this.emotion= Emotions.DISSATISFACTION;
    }


    public void negotiate(HotelOwner h){
        System.out.println(this.getName()+" договоривается с владельцем отеля "+h.getName());
        if((this.emotion==Emotions.DISSATISFACTION | this.emotion==Emotions.ANGER) & h.getEmotion()!=Emotions.FEAR){
            h.setEmotion(Emotions.FEAR);
        }
        h.giveAprice();
        if (h.giveAprice()==0){
            System.out.println(this.getName() + " cэкономил");
            this.setEmotion(Emotions.SATISFACTION);

        }
        else {System.out.println(this.getName() + " не cэкономил");
        this.setEmotion(Emotions.DISSATISFACTION);}
       h.checkInto(this);
        if(!h.hotel.getResidents().contains(this.employer)) {
            h.checkInto(employer);
        }
   }

    public void negotiate(int royalty){

        if(this.employer.royalty>royalty){
            this.setEmotion(Emotions.DISSATISFACTION);
            BeingOnTv poodle= () -> System.out.println( "Пудель не может быть на тв");
            BeingOnTv Alien= () -> System.out.println( "Пришелец из космоса не может быть на тв");
            Alien.beOnTv();
            poodle.beOnTv();

        }
        else{
            this.setEmotion(Emotions.SATISFACTION);

            employer.setAmountOfMoney(employer.amountOfMoney+ employer.royalty);

        }

    }


}
