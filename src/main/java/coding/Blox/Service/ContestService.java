package coding.Blox.Service;

import coding.Blox.Models.CodingBlox;
import coding.Blox.Models.Contest;
import coding.Blox.Models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContestService {
  private final CodingBlox codingBlox;

  public ContestService(CodingBlox codingBlox) {
    this.codingBlox = codingBlox;
  }

  public boolean isContestExists(Integer contestId) {
    if (codingBlox.getContests() != null) {
      for (Contest contest : codingBlox.getContests()) {
        if (contest.getContestId().compareTo(contestId) == 0) return true;
      }
    }
    return false;
  }

  public boolean isContestExists(List<String> params) {
    String contestName = params.get(1);
    String contestLevel = params.get(2);
    String creatorName = params.get(3);
    if (codingBlox.getContests() != null) {
      for (Contest contest : codingBlox.getContests()) {
        if (contest.getContestName().compareTo(contestName) == 0
            && contest.getContestLevel().compareTo(contestLevel) == 0
            && contest.getCreator().getUsername().compareTo(creatorName) == 0) {
          System.out.println("Contest already exists.");
          return true;
        }
      }
    }
    return false;
  }

  public Integer createContest(List<String> params) {
    User creator = null;
    for (User user : codingBlox.getUsers()) {
      if (user.getUsername().compareTo(params.get(3)) == 0) {
        creator = user;
        break;
      }
    }
    Contest newContest = new Contest(1, params.get(1), params.get(2), creator);
    if (codingBlox.getContests() == null) {
      List<Contest> contestList = new ArrayList<>();
      contestList.add(newContest);
      codingBlox.setContests(contestList);
    } else {
      newContest.setContestId(codingBlox.getContests().size() + 1);
      codingBlox.getContests().add(newContest);
    }
    //    assert creator != null;
    if (creator.getContests() == null) {
      List<Contest> newContestList = attendNewContest(newContest, creator);
      creator.setContests(newContestList);
    } else {
      creator.getContests().add(newContest);
    }
    return newContest.getContestId();
  }

  private List<Contest> attendNewContest(Contest newContest, User creator) {
    List<Contest> contestList = new ArrayList<>();
    contestList.add(newContest);
    creator.setContests(contestList);
    return contestList;
  }

  public void listAllContests() {
    for (Contest contest : codingBlox.getContests()) {
      System.out.println("contestId: " + contest.getContestId());
      System.out.println("contestName: " + contest.getContestName());
      System.out.println("creator_Name: " + contest.getCreator() + "\n");
    }
  }

  public void listContestWithLevel(String level) {
    System.out.print("Q.No: [");
    for (Contest contest : codingBlox.getContests()) {
      if (contest.getContestLevel().compareTo(level) == 0) {
        System.out.print(contest.getContestName() + ",");
      }
    }
    System.out.print("]");
  }

  public boolean areContestsAvailable() {
    return codingBlox.getContests() != null;
  }

  public boolean ifContestExists(String level) {
    if (codingBlox.getContests() != null) {
      for (Contest contest : codingBlox.getContests()) {
        if (contest.getContestLevel().compareTo(level) == 0) return true;
      }
    }
    return false;
  }

  public Contest getContest(Integer contestId) {
    for (Contest contest : codingBlox.getContests())
      if (contest.getContestId().compareTo(contestId) == 0) return contest;
    return null;
  }
}
