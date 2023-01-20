package enums;

public enum Actions {
    EAT{
        @Override
        public String str(){
            return "eat";
        }
    },
    DRINK{
        @Override
        public String str(){
            return "drink";
        }

    },
    SEE{
        @Override
        public String str() {
            return "see";
        }
    },
    LOOK {
        @Override
        public String str() {
            return "look";
        }
    },
    THINK {
        @Override
        public String str() {
            return "think";
        }
    },
    FEEL {
        @Override
        public String str() {
            return "feel";
        }
    },
    DO {
        @Override
        public String str() {
            return "do";
        }
    },
    UNDERSTAND {
        @Override
        public String str() {
            return "understand";
        }
    },
    LIKE {
        @Override
        public String str() {
            return "like";
        }
    },
    ASK{
        @Override
        public String str() {
            return "ask";
        }

    },
    TALK{
        @Override
        public String str() {
            return "talk";
        }
    };



    public abstract String str();
}
