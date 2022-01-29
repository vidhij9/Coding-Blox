package coding.Blox.Service;

import coding.Blox.Models.CodingBlox;
import coding.Blox.Models.Question;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class QuestionService {

  private final CodingBlox codingBlox;

  public QuestionService(CodingBlox codingBlox) {
    this.codingBlox = codingBlox;
  }

  public void createQuestion(String difficultyLevel, Integer score) {
    Question question = new Question(1, difficultyLevel, score);
    if (codingBlox.getQuestions() == null) {
      List<Question> questionList = new ArrayList<>();
      questionList.add(question);
      codingBlox.setQuestions(questionList);
    } else {
      question.setQuestionNumber(codingBlox.getQuestions().size() + 1);
      codingBlox.getQuestions().add(question);
    }
  }

  public boolean areQuestionsAvailable() {
    return codingBlox.getQuestions() != null;
  }

  public boolean ifQuestionExists(String difficultyLevel) {
    if (codingBlox.getQuestions() != null) {
      for (Question question : codingBlox.getQuestions()) {
        if (question.getDifficultyLevel().compareTo(difficultyLevel) == 0) return true;
      }
    }
    return false;
  }

  public void listAllQuestions() {
    for (Question question : codingBlox.getQuestions()) {
      System.out.println("Q.No: " + question.getQuestionNumber());
      System.out.println("Level: " + question.getDifficultyLevel());
      System.out.println("Score: " + question.getScore() + "\n");
    }
  }

  public void listQuestionWithLevel(String level) {
    System.out.print("Q.No: [");
    for (Question question : codingBlox.getQuestions()) {
      if (question.getDifficultyLevel().compareTo(level) == 0) {
        System.out.print(question.getQuestionNumber() + ",");
      }
    }
    System.out.print("]");
  }
}
