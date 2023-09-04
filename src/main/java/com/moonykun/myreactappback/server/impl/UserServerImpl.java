package com.moonykun.myreactappback.server.impl;

import com.moonykun.myreactappback.domain.User;
import com.moonykun.myreactappback.dto.UserDTO;
import com.moonykun.myreactappback.repository.UserRepository;
import com.moonykun.myreactappback.server.UserServer;
import com.moonykun.myreactappback.vo.UserQueryVO;
import com.moonykun.myreactappback.vo.UserUpdateVO;
import com.moonykun.myreactappback.vo.UserVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.MimeType;

import javax.persistence.criteria.*;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Moonykun
 */
@Service
public class UserServerImpl implements UserServer {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Long save(UserVO vO) {
        User bean = new User();
        BeanUtils.copyProperties(vO, bean);
        bean = userRepository.save(bean);
        return bean.getId();
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void update(Long id, UserUpdateVO vO) {
        User bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        userRepository.save(bean);
    }

    @Override
    public UserDTO getById(Long id) {
        User original = requireOne(id);
        return toDTO(original);
    }

    @Override
    public Page<UserDTO> query(UserQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    @Override
    public long userRegister(String userAccount, String userPassword, String checkPassword) {
        // 校验
        if (StringUtils.isAnyBlank(userAccount, userPassword, checkPassword)) {
            return -1;
        }
        if (userAccount.length() < 4) {
            return -1;
        }
        if (userPassword.length() < 8 || checkPassword.length() < 8) {
            return -1;
        }
        String validPattern = "[`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Matcher matcher = Pattern.compile(validPattern).matcher(userAccount);
        if (matcher.find()) {
            return -1;
        }
        Specification<User> userSpecification = (root, criteriaQuery, criteriaBuilder) -> {
            Path<Object> username = root.get("userAccount");
            return criteriaBuilder.equal(username.as(String.class), userAccount);
        };
        long count = userRepository.count(userSpecification);
        if (count > 0) {
            return -1;
        }
        if (!userPassword.equals(checkPassword)) {
            return -1;
        }
        // 密码加密
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode(userPassword);
        // 保存数据
        User user = new User();
        user.setUserAccount(userAccount);
        user.setUserPassword(userPassword);
        userRepository.save(user);
        return 0;
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
