package ott.cheol.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ott.cheol.request.UserEdit;
import ott.cheol.request.UserForm;
import ott.cheol.service.UserService;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    /**
     * 회원가입 !!!
     */
    @PostMapping("/api/register")
    public Long register(@RequestBody UserForm userForm) {
        log.info("userForm={}", userForm);
        return userService.add(userForm);
    }

    /**
     * 회원 수정
     */
    @PostMapping("/api/edit/{id}")
    public String edit(@PathVariable Long id, @RequestBody UserEdit requestDto) {
        log.info("id={},userEdit={}", id, requestDto);
        userService.update(id, requestDto);
        return "ok";
    }

    /**
     * 회원 삭제
     */
    @GetMapping("/api/delete/{id}")
    public String delete(@PathVariable Long id) {
        log.info("id={}", id);
        userService.delete(id);
        return "ok";
    }
}
