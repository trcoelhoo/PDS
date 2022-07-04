package ex2;
import java.io.*;
import java.util.*;

public class TextReader implements TextInterface {
    File file;
    int p_cnt;
    public TextReader(String f) {
        try {
            this.file = new File(f);
            this.p_cnt = 0;
        }
        catch (Exception e) {
            System.out.println("File not found, please try again.");
            System.exit(0);
        }
    }

    public boolean hasNext() {
        try {
            Scanner reader = new Scanner(this.file);
            for (int i = 0; i < this.p_cnt; i++) { // recover last paragraph
                reader.nextLine();
            }
            if (reader.nextLine() != null) { // check if there's a next paragraph
                reader.close();
                return true;
            }
            reader.close();
            this.p_cnt = 0; // if the program reaches this state, it means that there's nothing more in the
            return false;                   // file to be read, so we reset the p_cnt
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found, please try again.");
            System.exit(0);
            return false;
        }
    }

    public String next() {
        if (hasNext()) {
            try {
                Scanner reader = new Scanner(this.file);
                for (int i = 0; i < this.p_cnt; i++) { // recover last paragraph
                    reader.nextLine();
                }
                this.p_cnt++;
                String nextLine = reader.nextLine();
                reader.close();
                return nextLine;
            }
            catch (FileNotFoundException e) {
                System.out.println("File not found, please try again.");
            }
        }
        return null;
    }
}