package com.moonykun.myreactappback.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户
 * @author Moonykun
 */
@Data
@Entity
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户昵称
     */
    @Column(name = "username")
    private String username;

    /**
     * id
     */
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 账号
     */
    @Column(name = "userAccount")
    private String userAccount;

    /**
     * 用户头像
     */
    @Column(name = "avatarUrl")
    private String avatarUrl;

    /**
     * 性别
     */
    @Column(name = "gender")
    private Integer gender;

    /**
     * 密码
     */
    @Column(name = "userPassword", nullable = false)
    private String userPassword;

    /**
     * 电话
     */
    @Column(name = "phone")
    private String phone;

    /**
     * 邮箱
     */
    @Column(name = "email")
    private String email;

    /**
     * 状态 0 - 正常
     */
    @Column(name = "userStatus", nullable = false)
    private Integer userStatus=0;

    /**
     * 创建时间
     */
    @Column(name = "createTime")
    private Date createTime;

    @Column(name = "updateTime")
    private Date updateTime;

    /**
     * 是否删除
     */
    @Column(name = "isDelete", nullable = false)
    private Integer isDelete =0;

    /**
     * 用户角色 0 - 普通用户 1 - 管理员
     */
    @Column(name = "userRole", nullable = false)
    private Integer userRole=0;

    /**
     * 星球编号
     */
    @Column(name = "planetCode")
    private String planetCode;

}
