package com.moonykun.myreactappback.controller;

import com.moonykun.myreactappback.dto.UserDTO;
import com.moonykun.myreactappback.server.impl.UserServerImpl;
import com.moonykun.myreactappback.vo.UserQueryVO;
import com.moonykun.myreactappback.vo.UserUpdateVO;
import com.moonykun.myreactappback.vo.UserVO;
import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Moonykun
 */
@Validated
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServerImpl userServerImpl;

    @PostMapping
    public String save(@Valid @RequestBody UserVO vO) {
        return userServerImpl.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        userServerImpl.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody UserUpdateVO vO) {
        userServerImpl.update(id, vO);
    }

    @GetMapping("/{id}")
    public UserDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return userServerImpl.getById(id);
    }

    @GetMapping
    public Page<UserDTO> query(@Valid UserQueryVO vO) {
        return userServerImpl.query(vO);
    }


}
