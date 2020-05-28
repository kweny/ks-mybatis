package ks.mybatis.simple.mapper;

import ks.mybatis.simple.entity.SysPrivilege;

import java.util.List;

public interface PrivilegeMapper {

    List<SysPrivilege> selectAll();

}
