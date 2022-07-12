package ott.cheol.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;
    private String password;
    private String userName;

    @Builder
    public User(String userId, String password, String userName) {
        this.userId = userId;
        this.password = password;
        this.userName = userName;
    }

    public void update(String userId, String password, String userName) {
        this.userId = userId;
        this.password = password;
        this.userName = userName;
    }

}
