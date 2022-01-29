package coding.Blox.Commands;

import coding.Blox.Models.CodingBlox;
import coding.Blox.Models.Command;

public class RunCommandExecutor extends CommandExecutor{
    public static final String COMMAND_NAME = "RUN";

    public RunCommandExecutor(CodingBlox codingBlox) {
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
