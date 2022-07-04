package classes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class WordSoup {
  private static boolean isValid(int[][] wordSoup, boolean testMode) {
    // Check if size bigger than max
    if (wordSoup.length > 40) {
      System.err.println("Puzzle demasiado grande!");
      return false;
    }

    for (int[] characters : wordSoup) {
      // Check if any line has different length from the word soup height
      if (characters.length != wordSoup.length) {
        System.err.println("Puzzle não quadrado!");
        return false;
      }

      // Check if all characteres are upper case letters
      for (int character : characters) {
        // Accept only letters or . (representing empty) in test mode
        if (!(testMode && character == '.') && (character < 'A' || character > 'Z')) {
          System.err.println("Puzzle deve ser composto por letras maiúsculas!");
          return false;
        }
      }
    }

    return true;
  }

  // Loads WordSoup from file
  public static HashMap<String, Solution> solve(Path file) {
    List<String> lines;

    try {
      lines = Files.readAllLines(file);
      System.out.println(lines);
    } catch (IOException e) {
      System.err.println("Ficheiro não existe!");
      return null;
    }

    if (lines.isEmpty()) {
      System.err.println("Ficheiro está vazio!");
      return null;
    }

    Integer wordSoupSize = lines.get(0).length();

    if (lines.size() <= wordSoupSize) {
      System.err.println("Ficheiro não tem linhas suficientes!");
      return null;
    }

    int[][] wordSoup = new int[wordSoupSize][wordSoupSize];
    List<String> words = new ArrayList<String>();

    int i;

    for (i = 0; i < wordSoupSize; i++) {

      // Look for empty lines
      if (lines.get(i).length() == 0) {
        System.err.println("Ficheiro não pode ter linhas vazias!");
        return null;
      }

      wordSoup[i] = lines.get(i).chars().toArray();

    }

    for (; i < lines.size(); i++) {

      // Look for empty lines
      if (lines.get(i).length() == 0) {
        System.err.println("Ficheiro não pode ter linhas vazias!");
        return null;
      }

      for (String word : Arrays.asList(lines.get(i).split("[; ]"))) {
        words.add(word);
      }
    }

    return solve(wordSoup, words.toArray(new String[0]));
  }

  // Start solving without testMode and (empty solution Map)
  public static HashMap<String, Solution> solve(int[][] wordSoup, String[] words) {
    if (!isValid(wordSoup, false))
      return null;

    boolean success = true;

    String[] originalWords = words.clone();
    HashMap<String, Solution> solutions = solve(wordSoup, words, false);

    for (String key : solutions.keySet()) {
      if (solutions.get(key) == null) {
        System.out.println(key + " está repetida!");
        success = false;
      }
    }

    if (success) {
      if (solutions == null) {
        System.err.println("Existem palavra(s) inválidas!");
        success = false;
      } else if (solutions.size() != words.length) {
        System.err.println("Não foi possível encontrar todas as palavras!");
        success = false;
      }
    }

    if (success) {
      printSolved(wordSoup.length, originalWords, solutions);
      return solutions;
    }

    return null;
  }

  // Start solving (with empty solution Map)
  public static HashMap<String, Solution> solve(int[][] wordSoup, String[] words, boolean testMode) {
    if (!isValid(wordSoup, testMode))
      return null;

    for (String string : words) {
      if (!string.matches("[A-Z]*[a-z]+[A-Z]*")) {
        return null;
      }
    }

    HashMap<String, Solution> solutions = new HashMap<>();
    solve(wordSoup, words, testMode, solutions);

    for (String key : solutions.keySet()) {
      Solution s = solutions.get(key);
      Position p = s.getLetterPosition();
      findWord(wordSoup, key.toUpperCase(), new Position(p.getX() - 1, p.getY() - 1), s.getDirection());
    }

    for (int i = 0; i < wordSoup.length; i++) {
      for (int j = 0; j < wordSoup.length; j++) {
        for (String word : words) {
          Direction dir = findWord(wordSoup, word.toUpperCase(), new Position(j, i), Direction.None);
          if (dir != Direction.None) {
            solutions.put(word, null);
            unfindWord(wordSoup, word, new Solution(new Position(j + 1, i + 1), dir));
          }
        }
      }
    }

    for (String key : solutions.keySet()) {
      Solution s = solutions.get(key);
      if (s != null)
        unfindWord(wordSoup, key, s);
    }

    return solutions;
  }

  // Recursion, private to enforce starting with empty solution Map
  private static boolean solve(int[][] wordSoup, String[] words, boolean testMode,
      HashMap<String, Solution> solutions) {
    if (words.length == 0)
      return true;

    Arrays.sort(words, (a, b) -> -Integer.compare(a.length(), b.length()));
    String word = words[0].toUpperCase();
    boolean found = false;
    for (int i = 0; i < wordSoup.length && !found; i++) {
      for (int j = 0; j < wordSoup.length && !found; j++) {
        Direction wordDirection = Direction.None;
        wordDirection = findWord(wordSoup, word, new Position(j, i), Direction.None);
        if (wordDirection != Direction.None) {
          solutions.put(words[0], new Solution(new Position(j + 1, i + 1), wordDirection));
          boolean solved = solve(wordSoup, Arrays.copyOfRange(words, 1, words.length), true, solutions);
          unfindWord(wordSoup, words[0], solutions.get(words[0]));

          if (solved)
            found = true;
        }
      }
    }

    return found;
  }

  public static void unfindWord(int[][] wordSoup, String word, Solution solution) {
    Position position = solution.getLetterPosition();
    word = word.toUpperCase();
    for (int i = 0; i < word.length(); i++) {
      wordSoup[position.getY() - 1][position.getX() - 1] = word.charAt(i);
      position = position.nextPosition(solution.getDirection());
    }
  }

  public static Direction findWord(int[][] wordSoup, String word, Position position, Direction direction) {
    if (direction == Direction.None) {
      for (Direction dir : Direction.values()) {
        if (dir != Direction.None) {
          Direction temp = findWord(wordSoup, word, position, dir);

          if (temp != Direction.None)
            return temp;
        }
      }

      return Direction.None;
    }

    if (position.getX() < 0 || position.getY() < 0 || position.getX() >= wordSoup.length
        || position.getY() >= wordSoup.length)
      return Direction.None;

    if (wordSoup[position.getY()][position.getX()] == word.charAt(0)) {
      int temp = wordSoup[position.getY()][position.getX()];
      wordSoup[position.getY()][position.getX()] = '.';

      if (word.length() == 1)
        return direction;

      String missingWord = word.substring(1);
      Direction result = findWord(wordSoup, missingWord, position.nextPosition(direction), direction);

      if (result == Direction.None)
        wordSoup[position.getY()][position.getX()] = temp;

      return result;
    }

    return Direction.None;
  }

  private static void printSolved(int wordSoupSize, String[] words, HashMap<String, Solution> solutions,
      int[][] wordSoup) {
    for (String word : words) {
      Solution s = solutions.get(word);

      Position position = s.getLetterPosition();

      for (int i = 0; i < word.length(); i++) {
        wordSoup[position.getY() - 1][position.getX() - 1] = word.toUpperCase().charAt(i);
        position = position.nextPosition(s.getDirection());
      }

      System.out.println(String.format("%-15s %-5d %-10s %-10s", word, word.length(), s.getLetterPosition().toString(),
          s.getDirection().toString()));
    }

    System.out.println();

    for (int i = 0; i < wordSoupSize; i++) {
      for (int j = 0; j < wordSoupSize; j++) {
        System.out.print(String.format("%c", wordSoup[i][j]));
      }
      System.out.println();
    }

  }

  private static void printSolved(int wordSoupSize, String[] words, HashMap<String, Solution> solutions) {
    int[][] wordSoup = new int[wordSoupSize][wordSoupSize];
    for (int i = 0; i < wordSoupSize; i++)
      for (int j = 0; j < wordSoupSize; j++)
        wordSoup[i][j] = '.';

    printSolved(wordSoupSize, words, solutions, wordSoup);
  }
}
