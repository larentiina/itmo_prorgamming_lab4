package notAlive;


import java.util.ArrayList;


    public class BigEarth{
        public Sky sky;
        public static final boolean isHardshell=false;
        public static final String EarthLooksLike="трава, деревья, дома";
        public static class Sky{
            public static final String looksLike="черное со звездами";
            public static final ArrayList<String> stars= new ArrayList<>(){
                {
                    add("Сириус");
                    add("Полярная звезда");
                    add("Бетельгейзе");
                    add("Вега");
                }
            };
            public static final ArrayList<String> constellations= new ArrayList<>(){
                {
                    add("Гидра");
                    add("Дева");
                    add("Геркулес");
                    add("Большая медведица");
                }
            };
            public static final String moonLooksLike = "белый круг с кратерами";
            public static final String sunLooksLike = "большой яркий жёлтый круг";

        }


    }

