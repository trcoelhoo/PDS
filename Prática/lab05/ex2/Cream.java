package ex2;

public enum Cream {
    Whipped_cream("Whipped cream"),Red_Berries("Red_Berries"),Vanilla("Vanilla"),Lemon("Lemon");
    
    private String custom;

        private Cream(String custom) {
            this.custom = custom;
        }

        public String getCustomString() {
            return custom;
        }
}
