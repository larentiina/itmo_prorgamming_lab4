package notAlive;

import enums.*;
import humans.*;
import interfaces.*;

import java.util.ArrayList;

public class Show{
    public static int price=75;
    public String title;
    public TypeOfShow type;
    public ArrayList<Human> participants;
    public boolean isRun;


    public Show(String title, TypeOfShow type){
        this.type=type;
        this.title=title;
        this.participants=new ArrayList<>();
        if(type==TypeOfShow.PERFORMANCE){
            class Actor extends Human{
                Actor(String name){
                    super(name);
                }
            }
            class Dancer extends Human{
                Dancer(String name){
                    super(name);
                }
            }
            this.participants.add(new Actor("Lena"));
            this.participants.add(new Dancer("Sveta"));
            }

        }



    public String getTitle() {
        return title;
    }

    public ArrayList<Human> start(){
        return participants;
    }

    public ArrayList<Human> getParticipants() {
        return participants;
    }
}