package coding.Blox.Commands;

import coding.Blox.Models.CodingBlox;
import coding.Blox.Models.Command;

public class LeaderBoardCommandExecutor extends CommandExecutor{
    public static final String COMMAND_NAME = "LEADER_BOARD";

    public LeaderBoardCommandExecutor(CodingBlox codingBlox) {
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
