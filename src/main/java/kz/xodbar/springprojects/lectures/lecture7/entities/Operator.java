package kz.xodbar.springprojects.lectures.lecture7.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "operators")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Operator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "department", nullable = false)
    private String department;

    @ManyToMany
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<ApplicationRequestUpdated> assignedRequests;
}
