package humans;

import enums.Emotions;
import exceptions.NoFreeTvException;
import notAlive.*;

public class Lunatic extends Human {
    TvStudioOwner.TvStudio.TV tv;
    public Lunatic(String name) {
        super(name);
    }
    public void buy(TvStudioOwner t) {
        try {
            t.sell(this);
        } catch (NoFreeTvException e){
            System.out.println("Есть ли свободные телевизоры? " + !t.tvStudio.TVs.isEmpty());
        }
    }
    public void setTv(TvStudioOwner.TvStudio.TV tv) {
        this.tv = tv;
        tv.setOwnerTv(this);
    }
   public void watch() {
        boolean isNarrator = false;
        for (Show show : tv.start()) {
            System.out.println(this.name + " cмотрит " + show.getTitle());
            for (Human human : show.start()) {
                if (human.getClass() == Narrator.class) {
                    isNarrator = true;
                    break;
                }
            }

            if (isNarrator)
                this.emotion = Emotions.SATISFACTION;

            else {
                System.out.println("Передачи с рассказчиком не было");
                this.setEmotion(Emotions.SURPRISE);
                this.setEmotion(Emotions.ANGER);
            }

        }
    }
        public void pay (TvStudioOwner t){
        int rentalPrice;
        if(this.emotion!=Emotions.ANGER){
            rentalPrice = TvStudioOwner.TvStudio.TV.rentalPrice;
        }
        else{
            rentalPrice=0;
        }
        System.out.println(this.name + " заплатила " + t.getName() + " " + rentalPrice);
            this.amountOfMoney+=rentalPrice;
            t.setAmountOfMoney(amountOfMoney + rentalPrice);
    }
        public void negotiate (TvStudioOwner h){
                this.pay(h);
            }
        }



