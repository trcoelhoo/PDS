package classes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class SoupMaker {
  public static int[][] make(Path file, int size) {
    List<String> lines;

    try {
      lines = Files.readAllLines(file);
    } catch (IOException e) {
      System.err.println("Ficheiro não existe!");
      return null;
    }

    if (lines.isEmpty()) {
      System.err.println("Ficheiro está vazio!");
      return null;
    }

    ArrayList<String> words = new ArrayList<String>();

    for (String line : lines) {
      for (String word : Arrays.asList(line.split("[; ]"))) {
        words.add(word);
      }
    }

    return make(size, words);
  }

  public static int[][] make(int size, ArrayList<String> words) {
    int[][] grid = new int[size][size];

    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        grid[i][j] = '.';
      }
    }

    String[] wordsArray = words.toArray(new String[0]);
    Arrays.sort(wordsArray, (a, b) -> -Integer.compare(a.length(), b.length()));

    placeWords(grid, new ArrayList<String>(Arrays.asList(wordsArray)));
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if (grid[i][j] == '.') {
          grid[i][j] = randomLetterPermutation().get(0);
        }
        System.out.print(String.format("%c", grid[i][j]));
      }
      System.out.println();
    }

    System.out.println(String.join(";", wordsArray));

    return grid;
  }

  public static boolean placeWords(int[][] wordSoup, List<String> words) {
    if (words.size() == 0)
      return true;

    String word = words.get(0).toUpperCase();
    Solution solution = null;
    for (Position position : randomPositionPermutation(wordSoup.length)) {
      for (Direction dir : randomDirectionPermutation()) {
        if (placeWord(wordSoup, word, position, dir)) {
          solution = new Solution(position, dir);
          if (placeWords(wordSoup, words.subList(1, words.size())))
            return true;
          else
            unplaceWord(wordSoup, word, solution);
        }
      }

    }
    return false;
  }

  public static int num = 0;

  public static ArrayList<Integer> randomLetterPermutation() {
    ArrayList<Integer> letters = new ArrayList<>();
    for (int i = 'A'; i <= 'Z'; i++)
      letters.add(i);

    Collections.shuffle(letters);

    return letters;
  }

  public static ArrayList<Position> randomPositionPermutation(int size) {
    ArrayList<Position> positions = new ArrayList<>();
    for (int i = 0; i < size; i++)
      for (int j = 0; j < size; j++)
        positions.add(new Position(i, j));

    Collections.shuffle(positions);

    return positions;
  }

  public static ArrayList<Direction> randomDirectionPermutation() {
    ArrayList<Direction> directions = new ArrayList<>();

    for (Direction direction : Direction.values())
      if (direction != Direction.None)
        directions.add(direction);

    Collections.shuffle(directions);

    return directions;
  }

  public static void unplaceWord(int[][] wordSoup, String word, Solution sol) {
    Position letterPosition = sol.getLetterPosition();
    for (int i = 0; i < word.length(); i++) {
      wordSoup[letterPosition.getY()][letterPosition.getX()] = '.';
      letterPosition = letterPosition.nextPosition(sol.getDirection());
    }
  }

  public static boolean placeWord(int[][] wordSoup, String word, Position position, Direction direction) {
    if (position.getX() < 0 || position.getY() < 0 || position.getX() >= wordSoup.length
        || position.getY() >= wordSoup.length)
      return false;

    if (word.length() == 0)
      return true;

    if (wordSoup[position.getY()][position.getX()] == '.') {

      wordSoup[position.getY()][position.getX()] = word.charAt(0);

      String missingWord = word.substring(1);

      if (!placeWord(wordSoup, missingWord, position.nextPosition(direction), direction)) {
        wordSoup[position.getY()][position.getX()] = '.';
        return false;
      }

      return true;
    }

    return false;
  }
}
