public class Pasta_chef extends Chef{
    @Override
    public void responsavel(String pedido){
        if (canHandle(pedido.toLowerCase(), "pasta")){
            System.out.println("PastaCheft: Starting to cook " +pedido+". Out in 14 minutes!");
        }
        else{
            System.out.println("PastaChef: I can't cook that.");
            super.responsavel(pedido);
        }
    }
}
