package ex2;
public class TextReaderDecorator implements TextInterface {
    private TextInterface reader;
    TextReaderDecorator(TextInterface inf) {
        this.reader = inf;
    }
    public boolean hasNext() {
        return this.reader.hasNext();
    }
    public String next() {
        return this.reader.next();
    }
}