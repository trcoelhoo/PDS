package ex2;
import java.text.Normalizer;
public class NormalizationFilter extends TextReaderDecorator {
    String [] words;
    String finalString = "";

    public NormalizationFilter(TextInterface inf) {
        super(inf);
    }
    
    public String next() {
        this.words = super.next().split("[ .,?;:!]+");
        for (int i = 0; i < words.length; i++) {
            String newString = Normalizer.normalize(words[i], Normalizer.Form.NFD);
            newString = newString.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
            if (i > 0) {
                this.finalString = this.finalString + " " + newString;
            }
            else {
                this.finalString = newString;
            }
        }
        return finalString;
    }
}