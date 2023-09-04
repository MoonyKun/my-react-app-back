package com.moonykun.myreactappback.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;


/**
 * @author Moonykun
 */
@Data
public class UserVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 用户昵称
     */
    private String username;


    /**
     * id
     */
    @NotNull(message = "id can not null")
    private Long id;


    /**
     * 账号
     */
    private String userAccount;


    /**
     * 用户头像
     */
    private String avatarUrl;


    /**
     * 性别
     */
    private Integer gender;


    /**
     * 密码
     */
    @NotNull(message = "userPassword can not null")
    private String userPassword;


    /**
     * 电话
     */
    private String phone;


    /**
     * 邮箱
     */
    private String email;


    /**
     * 状态 0 - 正常
     */
    @NotNull(message = "userStatus can not null")
    private Integer userStatus;


    /**
     * 创建时间
     */
    private Date createTime;

    private Date updateTime;


    /**
     * 是否删除
     */
    @NotNull(message = "isDelete can not null")
    private Integer isDelete;


    /**
     * 用户角色 0 - 普通用户 1 - 管理员
     */
    @NotNull(message = "userRole can not null")
    private Integer userRole;


    /**
     * 星球编号
     */
    private String planetCode;

}
