package coding.Blox.Commands;

import coding.Blox.Models.CodingBlox;
import coding.Blox.Models.Command;

public abstract class CommandExecutor {
  CodingBlox codingBlox;

  public CommandExecutor(CodingBlox codingBlox) {
    this.codingBlox = codingBlox;
  }

  public abstract boolean validate(Command command);

  public abstract void execute(Command command);
}
