package rayglass.springblog.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "Blog_Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, unique = true)
    private String userName;

    @Column(length = 100, unique = true)
    private String email;

    @Column(length = 100)
    private String password;

    public User(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public User(Long id) {
        this.id = id;
    }

    public User(User copy) {
        id = copy.id; // This line is SUPER important! Many things won't work if it's absent
        email = copy.email;
        userName = copy.userName;
        password = copy.password;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Post> post;

}