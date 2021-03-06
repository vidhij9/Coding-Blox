package coding.Blox.Commands;

import coding.Blox.Models.CodingBlox;
import coding.Blox.Models.Command;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CommandExecutorFactory {

  private final Map<String, CommandExecutor> commandExecutorMap = new HashMap<>();
  private CodingBlox codingBlox = new CodingBlox();

  public CommandExecutorFactory() {
    commandExecutorMap.put(
        CreateCommandExecutor.COMMAND_NAME, new CreateCommandExecutor(codingBlox));
    commandExecutorMap.put(ListCommandExecutor.COMMAND_NAME, new ListCommandExecutor(codingBlox));
    commandExecutorMap.put(
        AttendCommandExecutor.COMMAND_NAME, new AttendCommandExecutor(codingBlox));
    commandExecutorMap.put(RunCommandExecutor.COMMAND_NAME, new RunCommandExecutor(codingBlox));
    commandExecutorMap.put(
        LeaderBoardCommandExecutor.COMMAND_NAME, new LeaderBoardCommandExecutor(codingBlox));
    commandExecutorMap.put(
        ContestHistoryCommandExecutor.COMMAND_NAME, new ContestHistoryCommandExecutor(codingBlox));
    commandExecutorMap.put(
        WithdrawCommandExecutor.COMMAND_NAME, new WithdrawCommandExecutor(codingBlox));
    commandExecutorMap.put(ExitCommandExecutor.COMMAND_NAME, new ExitCommandExecutor(codingBlox));
  }

  public CommandExecutor getCommandExecutor(final Command command) {
    CommandExecutor commandExecutor = commandExecutorMap.get(command.getCommandName());
    if (commandExecutor == null) {
      System.out.println("INVALID COMMAND NAME");
      commandExecutor = commandExecutorMap.get("EXIT");
    }
    return commandExecutor;
  }
}
