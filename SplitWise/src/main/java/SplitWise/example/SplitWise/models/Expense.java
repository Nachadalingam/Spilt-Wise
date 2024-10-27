package SplitWise.example.SplitWise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

@Entity
@Getter
@Setter
public class Expense extends BaseModel{

    private Currency currency;
    private Long amount;
    private String name;
    private LocalDateTime localDateTime;
    private String description;
    @ManyToOne
    private  User userAddedBy;
    @OneToMany
    private List<UserExpense>userExpenses;

}

 // expense   userexpense
//    1         M
 //   1         1


//User Expense
// 1     M   -> Trip,outing
//       1  ->
