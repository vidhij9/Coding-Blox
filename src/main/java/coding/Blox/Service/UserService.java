package coding.Blox.Service;

import coding.Blox.Models.CodingBlox;
import coding.Blox.Models.Contest;
import coding.Blox.Models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserService {

  private final CodingBlox codingBlox;
  private final ContestService contestService;

  public UserService(CodingBlox codingBlox) {
    this.codingBlox = codingBlox;
    this.contestService = new ContestService(codingBlox);
  }

  public boolean isUserExists(String userName) {
    if (codingBlox.getUsers() != null) {
      for (User user : codingBlox.getUsers()) {
        if (user.getUsername().compareTo(userName) == 0) {
          System.out.println("User already exists");
          return true;
        }
      }
    }
    return false;
  }

  public void createUser(String userName) {
    User newUser = new User(userName);
    if (codingBlox.getUsers() == null) {
      List<User> userList = new ArrayList<>();
      userList.add(newUser);
      codingBlox.setUsers(userList);
    } else {
      codingBlox.getUsers().add(newUser);
    }
  }

  public void attendContest(List<String> params) {
    User user = getUser(params.get(1));
    Contest contest = contestService.getContest(Integer.valueOf(params.get(0)));
    if (user.getContests() == null) {
      List<Contest> contestList = new ArrayList<>();
      contestList.add(contest);
      user.setContests(contestList);
    } else {
      user.getContests().add(contest);
    }
  }

  private User getUser(String userName) {
    for (User user : codingBlox.getUsers()) {
      if (user.getUsername().compareTo(userName) == 0) {
        return user;
      }
    }
    return null;
  }
}
