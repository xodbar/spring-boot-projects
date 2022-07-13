package kz.xodbar.springprojects.big_project.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "task_categories")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long taskCategoryId;

    @Column(name = "name", nullable = false, unique = true)
    private String taskCategoryName;

    @Override
    public String toString() {
        return ("TaskCategory[id=" + taskCategoryId + ", name=" + taskCategoryName + "]");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        else if (o == null)
            return false;
        else if (!(o instanceof TaskCategory))
            return false;

        boolean idEquality = ((this.taskCategoryId == null && ((TaskCategory) o).taskCategoryId == null) ||
                (this.taskCategoryId != null && this.taskCategoryId.equals(((TaskCategory) o).taskCategoryId)));
        boolean nameEquality = ((this.taskCategoryName == null && ((TaskCategory) o).taskCategoryName == null) ||
                (this.taskCategoryName != null && this.taskCategoryName.equals(((TaskCategory) o).taskCategoryName)));

        return (idEquality && nameEquality);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((taskCategoryName != null) ? taskCategoryName.hashCode() : 0)
                + ((taskCategoryId != null) ? taskCategoryId.hashCode() : 0);

        return result;
    }
}
