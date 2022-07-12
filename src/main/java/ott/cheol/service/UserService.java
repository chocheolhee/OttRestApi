package ott.cheol.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ott.cheol.entity.User;
import ott.cheol.repository.UserRepository;
import ott.cheol.request.UserEdit;
import ott.cheol.request.UserForm;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    /**
     * 회원가입
     */
    @Transactional
    public Long add(UserForm userDto) {

        User user = userDto.toEntity();

         userRepository.save(user);
         return user.getId();
    }

    /**
     * 유저 조회
     */
    public User get(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않습니다"));
    }

    /**
     * 회원 수정
     */
    @Transactional
    public void update(Long id, UserEdit requestDto) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("회원이 존재하지 않습니다."));
        user.update(requestDto.getUserId(),requestDto.getPassword(),requestDto.getUserName());
    }

    /**
     * 회원 삭제
     */
    @Transactional
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
