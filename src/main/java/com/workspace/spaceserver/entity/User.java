package com.workspace.spaceserver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String nickname;
    private String email;
    private String password;
    private String avatar;
    private Date createdAt;
    private Date updatedAt;
}
