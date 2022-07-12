package ott.cheol.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ott.cheol.entity.User;

@Getter
@NoArgsConstructor
public class UserForm {

    private String userId;
    private String password;
    private String userName;

    @Builder
    public UserForm(String userId, String password, String userName) {
        this.userId = userId;
        this.password = password;
        this.userName = userName;
    }

    public User toEntity() {
        return User.builder()
                .userId(userId)
                .password(password)
                .userName(userName)
                .build();
    }
}
