package ex2;

public enum Topping {
    Fruit("Fruit"),Chocolate("Chocolate");
    private String custom;

        private Topping(String custom) {
            this.custom = custom;
        }

        public String getCustomString() {
            return custom;
        }
}
