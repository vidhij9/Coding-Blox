package coding.Blox.Commands;

import coding.Blox.Models.CodingBlox;
import coding.Blox.Models.Command;

public class WithdrawCommandExecutor extends CommandExecutor{
    public static final String COMMAND_NAME = "WITHDRAW_CONTEST";

    public WithdrawCommandExecutor(CodingBlox codingBlox) {
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
