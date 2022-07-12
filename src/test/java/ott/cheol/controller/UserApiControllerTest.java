package ott.cheol.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import ott.cheol.entity.User;
import ott.cheol.repository.UserRepository;
import ott.cheol.request.UserEdit;
import ott.cheol.request.UserForm;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UserApiControllerTest {

    @Autowired
    private UserApiController userController;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void clear() {
        userRepository.deleteAll();
    }

    @Test
    @DisplayName("회원 가입")
    @Transactional
    void register() {

        //given
        UserForm userForm = UserForm.builder()
                .userId("철희")
                .password("1234")
                .userName("철희")
                .build();

        //when
        userController.register(userForm);

        //then
        assertEquals(1L, userRepository.count());
    }

    @Test
    @DisplayName("회원 수정")
    @Transactional
    void edit() {

        //given
        UserForm userForm = UserForm.builder()
                .userId("철희")
                .password("1111")
                .userName("철희")
                .build();

        Long num = userController.register(userForm);

        //when
        UserEdit userForm2 = UserEdit.builder()
                .userId("이현")
                .password("2222")
                .userName("이현")
                .build();

        userController.edit(num, userForm2);

        //then
        User changeUser = userRepository.findById(num).orElseThrow(() -> new IllegalStateException("존재하지 않습니다"));
        assertEquals("이현", changeUser.getUserName());

    }

    @Test
    @DisplayName("회원 삭제")
    @Transactional
    void delete() {

        //given
        UserForm user = UserForm.builder()
                .userId("유저1")
                .userName("철희")
                .password("111")
                .build();

        //when
        Long num = userController.register(user);

        userController.delete(num);

        //then
        assertEquals(0L, userRepository.count());
    }
}