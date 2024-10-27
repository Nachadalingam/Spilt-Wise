package SplitWise.example.SplitWise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "Splitwise_Group")
@Getter
@Setter
public class Group extends BaseModel{
    @ManyToOne
    private User createdAt;

    private String groupName;

    @OneToMany
    private List<Expense>expenses;

    private LocalDateTime localDateTime;

    @ManyToMany
    private List<User> users;
    private List<SettleMentTranscation>settleMentTranscations;



}

//group  settlementranscation
// 1         M
//  1          1

//group  expense
// 1      M
// 1       1

// 1      M


//group  user/admin
// 1       1
// M        1
