package humans;

import enums.*;
import interfaces.*;

public abstract class Human implements Sittable {
    public String name;
    public Emotions emotion;
    public int amountOfMoney=200;

    public Human(String name){
        this.name=name;
    }
    public Emotions getEmotion() {
        return emotion;
    }

    public String getName() {
        return name;
    }

    public void setEmotion(Emotions emotion) {
        this.emotion = emotion;
        System.out.println(this.getName()+" "+ emotion.str());
    }
    @Override
    public void sit(TvStudioOwner t) {
        TvStudioOwner.TvStudio.Hall.Table.humans.add(this);
        System.out.println(this.getName() + " сидит за столом");

    }

    public int getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(int amountOfMoney) {
        if(amountOfMoney< this.amountOfMoney){
            System.out.println(this.name + " потратил " + (this.amountOfMoney-amountOfMoney));
        } else if (amountOfMoney == this.amountOfMoney) {
            System.out.println("Денежное состояние " + this.name + " не изменилось");
        } else {
            System.out.println(this.name + " заработал " + ( amountOfMoney - this.amountOfMoney));
        }
        this.amountOfMoney = amountOfMoney;
    }
}
