package kz.xodbar.springprojects.lectures.lecture4.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "requests")
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
public class ApplicationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_name", length = 200)
    private String userName;

    @Column(name = "course", length = 100)
    private String course;

    @Column(name = "commentary", length = 500, nullable = false)
    private String commentary;

    @Column(name = "phone", length = 17, nullable = false)
    private String phone;

    @Column(name = "is_handled", nullable = false)
    private boolean handled;
}
