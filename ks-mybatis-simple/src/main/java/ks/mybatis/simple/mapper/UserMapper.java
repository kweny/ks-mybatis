package ks.mybatis.simple.mapper;

import ks.mybatis.simple.entity.SysRole;
import ks.mybatis.simple.entity.SysUser;

import java.util.List;

public interface UserMapper {

    SysUser choseOne(Long id);

    List<SysUser> selectAll();

    List<SysRole> selectUserRoles(Long userId);

}
