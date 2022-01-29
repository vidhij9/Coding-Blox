package coding.Blox.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class User {
  private String username;
  private List<Contest> contests;
  private Integer score;

  public User(String username) {
    this.username = username;
    this.score = 1500;
  }
}
