package coding.Blox.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class CodingBlox {

  private List<User> users;
  private List<Question> questions;
  private List<Contest> contests;
}

/*
create user u1
create contest c1 low u1
*/
