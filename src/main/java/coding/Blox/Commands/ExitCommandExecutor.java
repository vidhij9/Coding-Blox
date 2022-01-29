package coding.Blox.Commands;

import coding.Blox.Models.CodingBlox;
import coding.Blox.Models.Command;

public class ExitCommandExecutor extends CommandExecutor {
  public static final String COMMAND_NAME = "EXIT";

  public ExitCommandExecutor(CodingBlox codingBlox) {
    super(codingBlox);
  }

  @Override
  public boolean validate(Command command) {
    return command.getParams().isEmpty();
  }

  @Override
  public void execute(Command command) {
    System.out.println("Thanks for using Coding Blox.");
  }
}
