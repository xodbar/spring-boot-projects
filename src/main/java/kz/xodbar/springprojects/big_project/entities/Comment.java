package kz.xodbar.springprojects.big_project.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "comments")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long commentId;

    @Column(name = "comment", nullable = false, columnDefinition = "VARCHAR(255)")
    private String commentContent;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Task commentTask;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        else if (o == null)
            return false;
        else if (o.getClass() != getClass())
            return false;

        boolean idEquality = ((this.commentId == null && ((Comment) o).commentId == null)
                        || (this.commentId != null && this.commentId.equals(((Comment) o).commentId))),

                contentEquality = ((this.commentContent == null && ((Comment) o).commentContent == null)
                        || (this.commentContent != null && this.commentContent.equals(((Comment) o).commentContent)));

        return (idEquality && contentEquality);
    }

    @Override
    public int hashCode() {
        final int base = 31;
        int result = 1;

        result = result * base
                + (this.commentId == null ? 0 : this.commentId.hashCode())
                + (this.commentContent == null ? 0 : this.commentContent.hashCode());

        return result;
    }
}
