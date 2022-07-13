package kz.xodbar.springprojects.big_project.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "folders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Folder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long folderId;

    @Column(name = "name", nullable = false, unique = true)
    private String folderName;

    @ManyToMany(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<TaskCategory> folderCategories;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        else if (o == null)
            return false;
        else if (o.getClass() != getClass())
            return false;

        boolean idEquality = ((this.folderId == null && ((Folder) o).folderId == null)
                || (this.folderId != null && this.folderId.equals(((Folder) o).folderId)));
        boolean nameEquality = ((this.folderName == null && ((Folder) o).folderName == null)
                || (this.folderName != null && this.folderName.equals(((Folder) o).folderName)));

        return (idEquality && nameEquality);
    }

    @Override
    public int hashCode() {
        final int base = 31;
        int result = 1;

        result = (base * result
                + (this.folderId == null ? 0 : this.folderId.hashCode())
                + (this.folderName == null ? 0 : this.folderName.hashCode()));

        return result;
    }
}
