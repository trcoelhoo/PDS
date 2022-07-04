package ex2;
public class main2 {
    public static void main(String [] args) {
        TextReader reader = new TextReader("test.txt");
        System.out.println(reader.next());

        TermFilter t_reader = new TermFilter(new TextReader("test.txt"));
        System.out.println(t_reader.next());

        NormalizationFilter normReader = new NormalizationFilter(new TextReader("test.txt"));
        System.out.println(normReader.next());

        VowellFilter v_reader = new VowellFilter(new TextReader("test.txt"));
        System.out.println(v_reader.next());
        
        CapitalizationFilter c_reader = new CapitalizationFilter(new TextReader("test.txt"));
        System.out.println(c_reader.next());
        System.out.println(c_reader.next());
    } 
}