package ex2;

public enum Shape {
    Square("Square"),Rectangle("Rectangle"), Circle("Circle");
    private String custom;

        private Shape(String custom) {
            this.custom = custom;
        }

        public String getCustomString() {
            return custom;
        }
}
