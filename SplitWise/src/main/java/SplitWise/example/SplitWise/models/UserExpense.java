package SplitWise.example.SplitWise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class UserExpense extends BaseModel{
    @ManyToOne
    private User userName;

    private Long amount;

    @Enumerated(EnumType.STRING)
    private TypeOfExpense typeOfExpense;
}

//user userexpense
//1      M
// 1      1
