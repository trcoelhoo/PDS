package ex1;

public class MergeSort implements Strategy  {
    public void sort(SmartPhone[] arr, String set){
        System.out.println("Metodo: mergeSort");
        System.out.println("Ordem: "+set);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}