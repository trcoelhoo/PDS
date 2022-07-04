package classes;

public class Solution {
  private Position fisrtLetterPosition;
  private Direction direction;

  public Solution(Position fisrtLetterPosition, Direction dir) {
    this.direction = dir;
    this.fisrtLetterPosition = fisrtLetterPosition;
  }

  public Position getLetterPosition() {
    return fisrtLetterPosition;
  }

  public Direction getDirection() {
    return direction;
  }
}
