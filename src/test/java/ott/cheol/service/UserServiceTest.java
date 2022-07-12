package ott.cheol.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ott.cheol.entity.User;
import ott.cheol.repository.UserRepository;
import ott.cheol.request.UserEdit;
import ott.cheol.request.UserForm;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void clear() {
        userRepository.deleteAll();
    }

    @Test
    @DisplayName("유저 회원가입")
    void 회원가입() {
        //given
        UserForm user = UserForm.builder()
                .userId("유저1")
                .userName("철희")
                .password("111")
                .build();

        //when
        userService.add(user);

        //then
        assertEquals(1L,userRepository.count());

    }

    @Test
    @DisplayName("단건조회")
    void 단건조회() {
        //given
        User user = User.builder()
                .userId("유저1")
                .userName("철희")
                .password("111")
                .build();

        userRepository.save(user);

        //when
        User findUser = userRepository.findById(user.getId()).get();
        //then
        assertNotNull(findUser);
        assertEquals("철희", findUser.getUserName());
        assertEquals("111",findUser.getPassword());
    }

    @Test
    @DisplayName("회원수정")
    void 회원수정() {
        //given
        UserForm user = UserForm.builder()
                .userId("유저1")
                .userName("철희")
                .password("111")
                .build();
        Long num = userService.add(user);

        UserEdit userEdit = UserEdit.builder()
                .userId("유저2")
                .password("222")
                .userName("이현")
                .build();

        //when

        userService.update(num,userEdit);

        //then
        User changeUser = userRepository.findById(num).orElseThrow(() -> new IllegalStateException("존재하지 않습니다"));
        assertEquals("이현",changeUser.getUserName());

    }

    @Test
    @DisplayName("유저 삭제")
    void 회원삭제() {
        //given
        UserForm user = UserForm.builder()
                .userId("유저1")
                .userName("철희")
                .password("111")
                .build();

        //when
        Long num = userService.add(user);
        User findUser = userRepository.findById(num).get();
        userRepository.deleteById(findUser.getId());

        //then
        assertEquals(0L,userRepository.count());

    }
}