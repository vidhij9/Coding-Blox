package coding.Blox.Commands;

import coding.Blox.Models.CodingBlox;
import coding.Blox.Models.Command;
import coding.Blox.Service.ContestService;
import coding.Blox.Service.QuestionService;
import coding.Blox.Service.UserService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CreateCommandExecutor extends CommandExecutor {
  public static final String COMMAND_NAME = "CREATE";

  private final UserService userService;
  private final QuestionService questionService;
  private final ContestService contestService;

  public CreateCommandExecutor(CodingBlox codingBlox) {
    super(codingBlox);
    this.userService = new UserService(codingBlox);
    this.questionService = new QuestionService(codingBlox);
    this.contestService = new ContestService(codingBlox);
  }

  @Override
  public boolean validate(Command command) {
    List<String> params = command.getParams();
    if (params.get(0).compareTo("USER") == 0) {
      if (userService.isUserExists(params.get(1))) {
        return false;
      }
    }
    if (params.get(0).compareTo("CONTEST") == 0) {
      if (userService.isUserExists(params.get(3))) {
        if (contestService.isContestExists(params)) {
          return false;
        } else return true;
      } else {
        System.out.println("Creator does not exists");
        return false;
      }
    }
    return true;
  }

  @Override
  public void execute(Command command) {
    List<String> params = command.getParams();
    if (params.get(0).compareTo("USER") == 0) {
      userService.createUser(params.get(1));
      System.out.println("user created: " + params.get(1));
    }
    if (params.get(0).compareTo("QUESTION") == 0) {
      questionService.createQuestion(params.get(1), Integer.valueOf(params.get(2)));
      System.out.println("question created");
    }
    if (params.get(0).compareTo("CONTEST") == 0) {
      Integer contestId = contestService.createContest(params);
      System.out.println("Contest created: " + contestId);
    }
  }
}
