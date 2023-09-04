package com.moonykun.myreactappback.controller;

import com.moonykun.myreactappback.dto.UserDTO;
import com.moonykun.myreactappback.server.UserService;
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
    private UserService userService;

    @PostMapping
    public String save(@Valid @RequestBody UserVO vO) {
        return userService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        userService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody UserUpdateVO vO) {
        userService.update(id, vO);
    }

    @GetMapping("/{id}")
    public UserDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return userService.getById(id);
    }

    @GetMapping
    public Page<UserDTO> query(@Valid UserQueryVO vO) {
        return userService.query(vO);
    }
}
