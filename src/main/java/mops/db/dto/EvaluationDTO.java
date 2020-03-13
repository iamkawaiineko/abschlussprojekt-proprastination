package mops.db.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("priorization")
public class EvaluationDTO {
    @Id
    private int id;
    @Column("application")
    private String application;
    @Column("priority")
    private int priority;
}
