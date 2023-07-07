package rayglass.springblog.models;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(length = 1024, nullable = false)
    private String body;

//    Establish Post-User Relationship

    @ManyToOne
    @JoinColumn(name = "creator_id")
    // columnDefinition allows you to modify the table definition
    private User creator;

//    public Post(Long id, String title, String body) {
//        this.id = id;
//        this.title = title;
//        this.body = body;
//    }

//    public Post(String title, String body) {
//        this.title = title;
//        this.body = body;
//    }


}