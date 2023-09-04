package com.moonykun.myreactappback.server;

import com.moonykun.myreactappback.domain.User;
import com.moonykun.myreactappback.dto.UserDTO;
import com.moonykun.myreactappback.vo.UserQueryVO;
import com.moonykun.myreactappback.vo.UserUpdateVO;
import com.moonykun.myreactappback.vo.UserVO;
import org.springframework.data.domain.Page;

/**
 * @author Moonykun
 */
public interface UserServer {
    Long save(UserVO vO);
    void delete(Long id);
    void update(Long id, UserUpdateVO vO);
    UserDTO getById(Long id);
    Page<UserDTO> query(UserQueryVO vO);

    /**
     *
     * 用户注册
     * @param userAccount 用户账号
     * @param userPassword 用户密码
     * @param checkPassword 密码校验
     * @return 新用户id
     */
    long userRegister(String userAccount,String userPassword,String checkPassword);
}
