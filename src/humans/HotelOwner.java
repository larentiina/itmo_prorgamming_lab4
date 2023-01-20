package humans;

import enums.Emotions;
import humans.Human;

import java.util.ArrayList;

public class HotelOwner extends Owner {
    Hotel hotel;

    public HotelOwner(String name){
        super(name);
        this.hotel=new Hotel();
    }

    int giveAprice(){
        if(this.emotion== Emotions.FEAR){
            return 0;
        }
        else{
            return this.hotel.getPrice();
        }
    }
    void checkInto(Human h){
        this.hotel.addResidents(h);
        System.out.println(h.getName()+ " заселился в отель");
        h.setAmountOfMoney(h.getAmountOfMoney()-giveAprice());
        this.setAmountOfMoney(h.getAmountOfMoney()+giveAprice());
    }

    public static class Hotel {
        private int price=50;
        Hotel(){
            this.residents= new ArrayList<>();
        }
        private ArrayList<Human> residents;
        public int getPrice() {
            return price;
        }

        public void addResidents(Human h){

            this.residents.add(h);
        }

        public ArrayList<Human> getResidents() {
            return residents;
        }
    }
}
