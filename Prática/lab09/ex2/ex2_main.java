public class ex2_main {
    public static void main(String[] args) {
        Chef c = new Sushi_chef().setSucessor(new Pasta_chef().setSucessor(new Burger_chef().setSucessor(new Pizza_chef().setSucessor(new Dessert_chef()))));
        
        System.out.println("Can I please get a veggie burger?");
        c.responsavel("veggie burger");
        System.out.println();
        System.out.println("Can I please get a Pasta Carbonara?");
        c.responsavel("Pasta Carbonara");
        System.out.println();
        System.out.println("Can I please get a PLAIN pizza, no toppings!?");
        c.responsavel("PLAIN pizza, no toppings");
        System.out.println();
        System.out.println("Can I please get a sushi nigiri and sashimi?");
        c.responsavel("sushi nigiri and sashimi");
        
        System.out.println();
        System.out.println("Can I please get a salad with tuna?");
        c.responsavel("salad with tuna");
        System.out.println();
        System.out.println("Can I please get a strawberry ice cream and waffles dessert?");
        c.responsavel("strawberry ice cream and waffles dessert");
    }
}
