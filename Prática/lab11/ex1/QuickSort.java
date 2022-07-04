package ex1;

public class QuickSort implements Strategy  {
    
    public void sort(SmartPhone[] arr, String set){
        System.out.println("Metodo: QuickSort");
        System.out.println("Ordem: "+set);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}

