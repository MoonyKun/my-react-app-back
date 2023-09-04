package com.moonykun.myreactappback.server;

import com.moonykun.myreactappback.domain.User;
import com.moonykun.myreactappback.dto.UserDTO;
import com.moonykun.myreactappback.repository.UserRepository;
import com.moonykun.myreactappback.vo.UserQueryVO;
import com.moonykun.myreactappback.vo.UserUpdateVO;
import com.moonykun.myreactappback.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

/**
 * @author Moonykun
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Long save(UserVO vO) {
        User bean = new User();
        BeanUtils.copyProperties(vO, bean);
        bean = userRepository.save(bean);
        return bean.getId();
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public void update(Long id, UserUpdateVO vO) {
        User bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        userRepository.save(bean);
    }

    public UserDTO getById(Long id) {
        User original = requireOne(id);
        return toDTO(original);
    }

    public Page<UserDTO> query(UserQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private UserDTO toDTO(User original) {
        UserDTO bean = new UserDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private User requireOne(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
