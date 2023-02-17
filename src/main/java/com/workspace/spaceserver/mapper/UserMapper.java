package com.workspace.spaceserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.workspace.spaceserver.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
