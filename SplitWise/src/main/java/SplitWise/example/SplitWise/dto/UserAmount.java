package SplitWise.example.SplitWise.dto;

import SplitWise.example.SplitWise.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserAmount {
    private User user;
    private Long amount;

}
