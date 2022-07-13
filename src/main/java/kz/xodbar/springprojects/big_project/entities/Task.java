package kz.xodbar.springprojects.big_project.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long taskId;

    @Column(name = "title", nullable = false, unique = true)
    private String taskTitle;

    @Column(name = "description", columnDefinition = "TEXT")
    private String taskDescription;

    @Column(name = "status", nullable = false, length = 1)
    private int taskStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Folder taskFolder;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        else if (o == null)
            return false;
        else if (o.getClass() != getClass())
            return false;

        boolean idEquality = ((this.taskId == null && ((Task) o).taskId == null)
                        || (this.taskId != null && this.taskId.equals(((Task) o).taskId))),

                titleEquality = ((this.taskTitle == null && ((Task) o).taskTitle == null)
                        || (this.taskTitle != null && this.taskTitle.equals(((Task) o).taskTitle))),

                descriptionEquality = ((this.taskDescription == null && ((Task) o).taskDescription == null)
                        || (this.taskDescription != null && this.taskDescription.equals(((Task) o).taskDescription))),

                statusEquality = (this.taskStatus == ((Task) o).taskStatus);

        return (idEquality && titleEquality && descriptionEquality && statusEquality);
    }

    @Override
    public int hashCode() {
        final int base = 31;
        int result = 1;

        result = result * base
                + (this.taskId == null ? 0 : this.taskId.hashCode())
                + (this.taskTitle == null ? 0 : this.taskTitle.hashCode())
                + (this.taskDescription == null ? 0 : this.taskDescription.hashCode())
                + (this.taskFolder == null ? 0 : this.taskFolder.hashCode())
                + this.taskStatus;

        return result;
    }
}
