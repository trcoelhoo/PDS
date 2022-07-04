public class Burger_chef extends Chef {
    @Override
    public void responsavel(String pedido){
        if (canHandle(pedido.toLowerCase(), "burger")){
            System.out.println("BurgerChef: Starting to cook " +pedido+". Out in 19 minutes!");
        }
        else{
            System.out.println("BurgerChef: I can't cook that.");
            super.responsavel(pedido);
        }
    }
    
    
}
