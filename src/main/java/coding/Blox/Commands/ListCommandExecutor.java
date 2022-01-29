package coding.Blox.Commands;

import coding.Blox.Models.CodingBlox;
import coding.Blox.Models.Command;
import coding.Blox.Service.ContestService;
import coding.Blox.Service.QuestionService;

import java.util.List;

public class ListCommandExecutor extends CommandExecutor {
  public static final String COMMAND_NAME = "LIST";

  private final QuestionService questionService;
  private final ContestService contestService;

  public ListCommandExecutor(CodingBlox codingBlox) {
    super(codingBlox);
    this.questionService = new QuestionService(codingBlox);
    this.contestService = new ContestService(codingBlox);
  }

  @Override
  public boolean validate(Command command) {
    List<String> params = command.getParams();
    if (params.get(0).compareTo("QUESTION") == 0) {
      if (params.size() == 1) {
        return questionService.areQuestionsAvailable();
      } else {
        return questionService.ifQuestionExists(params.get(1));
      }
    }

    if (params.get(0).compareTo("CONTEST") == 0) {
      if (params.size() == 1) {
        return contestService.areContestsAvailable();
      } else {
        return contestService.ifContestExists(params.get(1));
      }
    }
    return false;
  }

  @Override
  public void execute(Command command) {
    List<String> params = command.getParams();
    if (params.get(0).compareTo("QUESTION") == 0) {
      System.out.println("Questions available are: \n");
      if (params.size() == 1) {
        questionService.listAllQuestions();
      } else {
        questionService.listQuestionWithLevel(params.get(1));
      }
    }
    if (params.get(0).compareTo("CONTEST") == 0) {
      System.out.println("Contests available are: \n");
      if (params.size() == 1) {
        contestService.listAllContests();
      } else {
        contestService.listContestWithLevel(params.get(1));
      }
    }
  }
}
