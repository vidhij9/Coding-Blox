package coding.Blox.Commands;

import coding.Blox.Models.CodingBlox;
import coding.Blox.Models.Command;
import coding.Blox.Service.ContestService;
import coding.Blox.Service.UserService;

import java.util.List;

public class AttendCommandExecutor extends CommandExecutor {
  public static final String COMMAND_NAME = "ATTEND";
  private final UserService userService;
  private final ContestService contestService;

  public AttendCommandExecutor(CodingBlox codingBlox) {
    super(codingBlox);
    this.userService = new UserService(codingBlox);
    this.contestService = new ContestService(codingBlox);
  }

  @Override
  public boolean validate(Command command) {
    List<String> params = command.getParams();
    if (params.size() != 2) return false;
    if (!contestService.isContestExists(Integer.parseInt(params.get(0)))) return false;
    if (!userService.isUserExists(params.get(1))) return false;
    return true;
  }

  @Override
  public void execute(Command command) {
    userService.attendContest(command.getParams());
  }
}
