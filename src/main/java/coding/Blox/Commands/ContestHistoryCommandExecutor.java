package coding.Blox.Commands;

import coding.Blox.Models.CodingBlox;
import coding.Blox.Models.Command;

public class ContestHistoryCommandExecutor extends CommandExecutor{
    public static final String COMMAND_NAME = "CONTEST_HISTORY";

    public ContestHistoryCommandExecutor(CodingBlox codingBlox) {
        super(codingBlox);
    }

    @Override
    public boolean validate(Command command) {
        return false;
    }

    @Override
    public void execute(Command command) {

    }
}
