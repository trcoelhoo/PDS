public  class Dessert_chef extends Chef {
    @Override
    public void responsavel(String pedido){
        if (canHandle(pedido.toLowerCase(), "dessert")){
            System.out.println("DesserChef: Starting to cook " +pedido+". Out in 17 minutes!");
        }
        else{
            System.out.println("DesserChef: I can't cook that.");
            super.responsavel(pedido);
        }
    }
    
}
