package coding.Blox.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Contest {

  private Integer contestId;
  private String contestName;
  private String contestLevel;
  private User creator;
  private String contestStatus;
  private List<Question> questions;

  public Contest(Integer contestId, String contestName, String contestLevel, User creator) {
    this.contestId = contestId;
    this.contestName = contestName;
    this.contestLevel = contestLevel;
    this.creator = creator;
  }
}
