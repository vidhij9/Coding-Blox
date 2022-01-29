package coding.Blox.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Question {

  private Integer questionNumber;
  private String difficultyLevel;
  private Integer score;

  public void setQuestionNumber(Integer questionNumber) {
    this.questionNumber = questionNumber;
  }

  public void setDifficultyLevel(String difficultyLevel) {
    if (difficultyLevel.compareTo("LOW") == 0
        || difficultyLevel.compareTo("MEDIUM") == 0
        || difficultyLevel.compareTo("HIGH") == 0) {
      this.difficultyLevel = difficultyLevel;
    } else {
      System.out.println("INVALID DIFFICULTY LEVEL");
      this.difficultyLevel = null;
    }
  }

  public void setScore(Integer score) {
    if (score > 0) {
      this.score = score;
    } else {
      System.out.println("SCORE must be a positive value.");
      this.score = 0;
    }
  }
}
