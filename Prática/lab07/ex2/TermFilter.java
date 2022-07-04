package ex2;
public class TermFilter extends TextReaderDecorator {
    String [] words;
    int word;
    public TermFilter(TextInterface inf) {
        super(inf);
        this.words = new String [0];
        this.word = 0;
    }
    public String next() {
        if (words.length == word) {
            this.words = super.next().split("[ .,]+");
            this.word = 0;
        }
        
        String nextWord = words[word];
        this.word++;

        return nextWord;
    }
}