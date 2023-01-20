package enums;

public enum Emotions {
    SURPRISE{
        @Override
        public String str() {
            return "удивлён";
        }
    },
    ANGER{
        @Override
        public String str() {
            return "злится";
        }
    },
    FEAR{
        @Override
        public String str() {
            return "напуган";
        }
    },
    NORMAL{
        @Override
        public String str() {
            return "спокоен";
        }
    },
    DISSATISFACTION{
        @Override
        public String str() {
            return "неудовлетворён";
        }
    },
    SATISFACTION{
        @Override
        public String str() {
            return "удовлетворён";
        }
    };
    public abstract String str();

}
