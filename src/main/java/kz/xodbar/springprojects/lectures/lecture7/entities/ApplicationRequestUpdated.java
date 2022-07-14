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
@Table(name = "requests_new")
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
public class ApplicationRequestUpdated {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_name", length = 200)
    private String userName;

    @Column(name = "commentary", length = 500, nullable = false)
    private String commentary;

    @Column(name = "phone", length = 17, nullable = false)
    private String phone;

    @Column(name = "is_handled", nullable = false)
    private boolean handled;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Course course;

    @ManyToMany(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Operator> operators;
}
