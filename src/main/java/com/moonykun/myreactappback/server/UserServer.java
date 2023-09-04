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
}
