package ks.mybatis.simple.mapper;

import ks.mybatis.simple.entity.SysRolePrivilege;
import ks.mybatis.simple.entity.SysUserRole;

import java.util.List;

public interface RolePrivilegeMapper {

    List<SysRolePrivilege> selectAll();

}
