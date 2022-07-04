package lab01;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.io.PrintWriter;

public class WSSolver {
    
    private static char[][] matrix = new char[40][40];
    private static List<String> words = new ArrayList<String>(); 
    private static char[][] solutionMatrix = new char[40][40];
    //o primeiro valor é a direção e os seguintes são todas as coordenadas que a palavra ocupa
    private static ArrayList<ArrayList<Integer>> wordsPositions = new ArrayList<ArrayList<Integer>>();

    public static void main(String[] args) throws Exception {
        
        int matrixRow = 0;
        int soupLines = 0;
        int soupRowSize = 0;

        try {
            File file = new File(args[0]);
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                //Isto verifica um dos pontos a alínea a)
                if (line.length() == 0) {
                    System.out.println("Linha vazia");
                    System.exit(1);
                } else if( line.matches("^[A-Z]*$")) {
                    //Isto verifica um dos pontos a alínea a)
                    if(line.length() > 40) {
                        System.err.println("A Sopa tem dimensão maior do que 40.");
                        System.exit(1);
                    }
                    soupLines++;
                    soupRowSize = line.length();
                    for(int i = 0; i < line.length(); i++) {
                        //Isto verifica um dos pontos a alínea a)
                        if(Character.isUpperCase(line.charAt(i))) {
                            matrix[matrixRow][i] = line.charAt(i);
                        } else {
                            System.err.println("A Sopa não está em maiúsculas.");
                            System.exit(1);
                        }
                    }
                    matrixRow++;
                } else {
                    //Isto verifica um dos pontos a alínea a)
                    if(soupLines != soupRowSize) {
                        System.err.println("A Sopa não é quadrada.");
                        System.exit(1);
                    }
                    String[] splited = line.split("(\\s+|;|,)");
                    for(int i = 0; i < splited.length; i++) { 
                        //Isto verifica um dos pontos a alínea a)
                        if(!splited[i].matches("^[a-zA-Z]*$")) {
                            System.out.println("Palavra tem caracters que não são letras");
                            System.exit(1);
                        }
                        words.add(splited[i].toUpperCase());
                    }
                }
            }
            sc.close();

        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro não encontrado");
            System.exit(1);
        } 


        for (int i = 0; i < matrixRow; i++) {
            for (int j = 0; j < matrixRow; j++) {
                solutionMatrix[i][j] = '.';
            }
        }

        words.sort( (String s1, String s2) -> { return s2.length() - s1.length(); });
        for(String word : words) { 
            findWord(word);
        }
        
        System.out.println("");
        for (int i = 0; i < matrixRow; i++) {
            for (int j = 0; j < matrixRow; j++) {
                System.out.printf("%c ", solutionMatrix[i][j]);
            }
            System.out.println("");
        }

        PrintWriter writer = new PrintWriter("Pratica1/out1.txt");
        for (int i = 0; i < matrixRow; i++) {
            for (int j = 0; j < matrixRow; j++) {
                writer.printf("%c ", solutionMatrix[i][j]);
            }
            writer.println("");
        }
        writer.close();

    }

    public static void findWord(String word) {

        int[] result;
        ArrayList<Integer> thisWord = new ArrayList<Integer>();
        int numberOfOcurrencies = 0;
        result = findHorizontal(word);
        if(result[0] != -1) {
            int i = 0;
            thisWord.add(0);
            while (i < word.length()) {
                solutionMatrix[result[1]][result[0]] = word.charAt(i++);
                thisWord.add(result[1]);
                thisWord.add(result[0]++);
            }
            if(!findSameDirectionCollisions(thisWord)) {
                System.out.printf("%-20s%2d\t%d,%d\tRIGHT\n", word, word.length(), result[1] + 1, result[0] + 1);
                numberOfOcurrencies++;
            }
            return;
        }
        result = findHorizontalReverse(word);
        if(result[0] != -1) {
            int i = 0;
            thisWord.add(0);
            while (i < word.length()) {
                solutionMatrix[result[1]][result[0]] = word.charAt(i++);
                thisWord.add(result[1]);
                thisWord.add(result[0]--);
            }
            if(!findSameDirectionCollisions(thisWord)) {
                System.out.printf("%-20s%2d\t%d,%d\tLEFT\n", word, word.length(), result[1] + 1, result[0] + 1);
                numberOfOcurrencies++;
            }
            return;
        }
        result = findVertical(word);
        if(result[0] != -1) {
            int i = 0;
            thisWord.add(1);
            while (i < word.length()) {
                solutionMatrix[result[1]][result[0]] = word.charAt(i++);
                thisWord.add(result[1]++);
                thisWord.add(result[0]);
            }
            if(!findSameDirectionCollisions(thisWord)) {
                System.out.printf("%-20s%2d\t%d,%d\tDOWN\n", word, word.length(), result[1] + 1, result[0] + 1);
                numberOfOcurrencies++;
            }
            return;
        }
        result = findVerticalReverse(word);
        if(result[0] != -1) {
            int i = 0;
            thisWord.add(1);
            while (i < word.length()) {
                solutionMatrix[result[1]][result[0]] = word.charAt(i++);
                thisWord.add(result[1]--);
                thisWord.add(result[0]);
            }
            if(!findSameDirectionCollisions(thisWord)) {
                System.out.printf("%-20s%2d\t%d,%d\tUP\n", word, word.length(), result[1] + 1, result[0] + 1);
                numberOfOcurrencies++;
            }
            return;
        }
        result = findDiagonalBackslash(word);
        if(result[0] != -1) {
            int i = 0;
            thisWord.add(2);
            while (i < word.length()) {
                solutionMatrix[result[1]][result[0]] = word.charAt(i++);
                thisWord.add(result[1]++);
                thisWord.add(result[0]++);
            }
            if(!findSameDirectionCollisions(thisWord)) {
                System.out.printf("%-20s%2d\t%d,%d\tDOWN_RIGHT\n", word, word.length(), result[1] + 1, result[0] + 1);
                numberOfOcurrencies++;
            }
            return;
        }
        result = findDiagonalBackslashReverse(word);
        if(result[0] != -1) {
            int i = 0;
            thisWord.add(2);
            while (i < word.length()) {
                solutionMatrix[result[1]][result[0]] = word.charAt(i++);
                thisWord.add(result[1]--);
                thisWord.add(result[0]--);
            }
            if(!findSameDirectionCollisions(thisWord)) {
                System.out.printf("%-20s%2d\t%d,%d\tUP_LEFT\n", word, word.length(), result[1] + 1, result[0] + 1);
                numberOfOcurrencies++;
            }
            return;
        }
        result = findDiagonalForwardslash(word);
        if(result[0] != -1) {
            int i = 0;
            thisWord.add(3);
            while (i < word.length()) {
                solutionMatrix[result[1]][result[0]] = word.charAt(i++);
                thisWord.add(result[1]++);
                thisWord.add(result[0]--);
            }
            if(!findSameDirectionCollisions(thisWord)) {
                System.out.printf("%-20s%2d\t%d,%d\tDOWN_LEFT\n", word, word.length(), result[1] + 1, result[0] + 1);
                numberOfOcurrencies++;
            }
            return;
        }
        result = findDiagonalForwardslashReverse(word);
        if(result[0] != -1) {
            int i = 0;
            thisWord.add(3);
            while (i < word.length()) {
                solutionMatrix[result[1]][result[0]] = word.charAt(i++);
                thisWord.add(result[1]--);
                thisWord.add(result[0]++);
            }
            if(!findSameDirectionCollisions(thisWord)) {
                System.out.printf("%-20s%2d\t%d,%d\tUP_RIGTH\n", word, word.length(), result[1] + 1, result[0] + 1);
                numberOfOcurrencies++;
            }
            return;
        }
        if(numberOfOcurrencies == 0) {
            System.out.printf("%-20s not found!\n", word);
        } else if(numberOfOcurrencies > 1) {
            System.out.printf("%-20s found more thant 1 time!\n", word);
            System.exit(1);
        }

    }

    public static int[] findHorizontal(String word) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if(matrix[i][j] == word.charAt(0)) {
                    boolean match = true;
                    for (int k = 0; k < word.length(); k++) {
                        //System.out.printf("Checking, line " + i + "  " + (j + k) +  "\n");
                        if(k + j >= matrix.length || matrix[i][k + j] != word.charAt(k)) {
                            match = false;
                            break;
                        }
                    }
                    if(match) { 
                        //System.out.printf("Returning, line " + i + "  " + j +  "\n");
                        return new int[] {j, i};
                    }
                }
            }
            //System.out.println("");
        }
        return new int[] {-1, -1};
    }

    public static int[] findHorizontalReverse(String word) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = matrix.length - 1; j >= 0; j--) {
                if(matrix[i][j] == word.charAt(0)) {
                    //System.out.printf("Match, line " + i + "\n");
                    boolean match = true;
                    int k;
                    for (k = 0; k < word.length(); k++) {
                        if(j - k < 0 || matrix[i][j - k] != word.charAt(k)) {
                            match = false;
                            break;
                        }
                    }
                    if(match) { 
                        return new int[] {i, j};
                    }
                }
            }
            //System.out.println("");
        }
        return new int[] {- 1, -1};
    }

    public static int[] findVertical(String word) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if(matrix[j][i] == word.charAt(0)) {
                    //System.out.printf("Match, line " + i);
                    boolean match = true;
                    int k;
                    for (k = 0; k < word.length(); k++) {
                        if(j + k >= matrix.length || matrix[k + j][i] != word.charAt(k)) {
                            match = false;
                            break;
                        }
                    }
                    if(match) { 
                        return new int[] {i, j};
                    }
                }
            }
            //System.out.println("");
        }
        return new int[] {-1, -1};
    }

    public static int[] findVerticalReverse(String word) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = matrix.length - 1; j >= 0; j--) {
                if(matrix[j][i] == word.charAt(0)) {
                    //System.out.printf("Match, line " + i);
                    boolean match = true;
                    int k;
                    for (k = 0; k < word.length(); k++) {
                        if(j - k < 0 || matrix[j - k][i] != word.charAt(k)) {
                            match = false;
                            break;
                        }
                    }
                    if(match) { 
                        return new int[] {i, j};
                    }
                }
            }
            //System.out.println("");
        }
        return new int[] {-1, -1};
    }

    public static int[] findDiagonalBackslash(String word) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if(matrix[i][j] == word.charAt(0)) {
                    //System.out.printf("Match, line " + i + "\n");
                    boolean match = true;
                    int k = 0;
                    while (k < word.length()) {
                        if(i + k >= matrix.length || k + j >= matrix.length || matrix[i + k][k + j] != word.charAt(k)) {
                            match = false;
                            break;
                        }
                        k++;
                    }
                    if(match) { 
                        return new int[] {i, j};
                    }
                }
            }
            //System.out.println("s");
        }
        return new int[] {-1, -1};
    }

    public static int[] findDiagonalBackslashReverse(String word) {
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix.length - 1; j >= 0; j--) {
                if(matrix[i][j] == word.charAt(0)) {
                    //System.out.printf("Match, line " + i + "\n");
                    boolean match = true;
                    int k = 0;
                    while (k < word.length()) {
                        if(i - k < 0 || j - k < 0 || matrix[i - k][j - k] != word.charAt(k)) {
                            match = false;
                            break;
                        }
                        k++;
                    }
                    if(match) { 
                        return new int[] {i, j};
                    }
                }
            }
            //System.out.println("s");
        }
        return new int[] {-1, -1};
    }

    public static int[] findDiagonalForwardslash(String word) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if(matrix[i][j] == word.charAt(0)) {
                    //System.out.printf("Match, line " + i + "\n");
                    boolean match = true;
                    int k = 0;
                    while (k < word.length()) {
                        if(i + k >= matrix.length || j - k < 0 || matrix[i + k][j - k] != word.charAt(k)) {
                            match = false;
                            break;
                        }
                        k++;
                    }
                    if(match) { 
                        return new int[] {j, i};
                    }
                }
            }
            //System.out.println("s");
        }
        return new int[] {-1, -1};
    }

    public static int[] findDiagonalForwardslashReverse(String word) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if(matrix[i][j] == word.charAt(0)) {
                    //System.out.printf("Match, line " + i + "\n");
                    boolean match = true;
                    int k = 0;
                    while (k < word.length()) {
                        if(i - k < 0 || k + j >= matrix.length || matrix[i - k][k + j] != word.charAt(k)) {
                            match = false;
                            break;
                        }
                        k++;
                    }
                    if(match) { 
                        return new int[] {j, i};
                    }
                }
            }
            //System.out.println("s");
        }
        return new int[] {-1, -1};
    }

    private static boolean findSameDirectionCollisions(ArrayList<Integer> compareTo) {
        
        for (int i = 0; i < wordsPositions.size(); i++) {
            if(wordsPositions.get(i).get(0) == compareTo.get(0)) {
                for(int j = 1; j < wordsPositions.get(i).size(); j += 2) {
                    for(int jc = 1; jc < compareTo.size(); jc += 2) {
                        if(wordsPositions.get(i).get(j) == compareTo.get(jc) &&
                           wordsPositions.get(i).get(j + 1) == compareTo.get(jc + 1)) {
                            return true;
                        }
                    }
                }
            }
        }   
        return false;
    }
}
