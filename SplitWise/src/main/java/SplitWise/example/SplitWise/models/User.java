package SplitWise.example.SplitWise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Entity(name = "User_Details")
@Getter
@Setter
public class User extends BaseModel{

    private String name;
    private String password;
    private String email;
    @ManyToMany
    private List<User>friends;
    @ManyToMany
    private List<Group>groups;
}


//  User group
//   1    M
//   M     1