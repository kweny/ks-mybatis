package ks.mybatis.simple.mapper;

import ks.mybatis.simple.entity.SysRole;
import ks.mybatis.simple.entity.SysUserRole;

import java.util.List;

public interface UserRoleMapper {

    List<SysUserRole> selectAll();

}
