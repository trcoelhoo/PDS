package ex1;

public class ex1 {
    public static void main(String[] args) {
        SmartPhone[] array = new SmartPhone[5];
        array[0] = new SmartPhone("Iphone", "Iphone", 1000.0, 4, "8mp");
        array[1] = new SmartPhone("Samsung", "Samsung", 2000.0, 8, "12mp");
        array[2] = new SmartPhone("Xiaomi", "Xiaomi", 3000.0, 16, "16mp");
        array[3] = new SmartPhone("Huawei", "Huawei", 4000.0, 32, "20mp");
        array[4] = new SmartPhone("Oppo", "Oppo", 5000.0, 64, "24mp");
        

        Revista revista = new Revista(new InsertionSort(), array);
        revista.sort(new InsertionSort(), "processador");
        revista.sort(new MergeSort(), "nome");
        revista.sort(new QuickSort(), "memoria");
    }
}
