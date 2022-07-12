package ott.cheol.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserEdit {

    private String userId;
    private String password;
    private String userName;

    @Builder
    public UserEdit(String userId, String password, String userName) {
        this.userId = userId;
        this.password = password;
        this.userName = userName;
    }
}
