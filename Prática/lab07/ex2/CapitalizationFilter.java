package ex2;
public class CapitalizationFilter extends TextReaderDecorator {
    String [] words;
    String finalString = "";
    public CapitalizationFilter(TextInterface inf) {
        super(inf);
    }

    public String next() {
        this.words = super.next().split("[ ]+");
        String firstWord = words[0];
        String lastWord = words[words.length - 1];
        char firstChar = Character.toUpperCase((firstWord.charAt(0)));
        firstWord = firstChar + firstWord.substring(1);
        this.words[0] = firstWord;
        int id = 0;
        String newLastWord = "";
        while (isAlpha(String.valueOf(lastWord.charAt(id)))) {
            newLastWord = newLastWord + Character.toLowerCase((lastWord.charAt(id)));
            id++;
        }
        char lastChar = Character.toUpperCase(newLastWord.charAt(newLastWord.length()-1));
        lastWord = newLastWord.substring(0, newLastWord.length()-1) + lastChar;
        this.words[words.length-1] = lastWord;

        for (int i = 0; i < words.length; i++) {
            if (i == 0) {
                finalString = firstWord;
            }
            else if (i == words.length-1) {
                finalString = finalString + " " + lastWord;
            }
            else {
                String lowerWord = words[i].toLowerCase();
                finalString = finalString + " " + lowerWord;
            }
        }
        return finalString;
    }

    public boolean isAlpha(String name) {
        return name.matches("[a-zA-Z]+");
    }

}