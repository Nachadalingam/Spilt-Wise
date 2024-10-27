package SplitWise.example.SplitWise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class SettleMentTranscation extends BaseModel{
    @ManyToMany
    private User landor;
    @ManyToMany
    private User borrower;

    private Long amount;
}
