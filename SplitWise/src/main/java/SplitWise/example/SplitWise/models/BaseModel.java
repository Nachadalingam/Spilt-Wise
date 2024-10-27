package SplitWise.example.SplitWise.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@MappedSuperclass
public abstract class BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private LocalDateTime createdBy;
    private LocalDateTime updatedBy;
}
