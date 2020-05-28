package ks.mybatis.simple;

import ks.mybatis.simple.entity.SysRole;
import ks.mybatis.simple.entity.SysUser;
import ks.mybatis.simple.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class UserMapperTest extends BaseMapperTest {

    @Test
    public void testChoseOne() {
        try (SqlSession session = getSqlSession()) {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            SysUser user = userMapper.choseOne(1L);
            System.out.println(user);
            Assert.assertNotNull(user);
        }
    }

    @Test
    public void testSelectAll() {
        try (SqlSession session = getSqlSession()) {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            List<SysUser> userList = userMapper.selectAll();
            for (SysUser user : userList) {
                System.out.println(user);
            }
            Assert.assertNotNull(userList);
            Assert.assertTrue(userList.size() > 0);
        }
    }

    @Test
    public void testSelectUserRoles() {
        try (SqlSession session = getSqlSession()) {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            List<SysRole> roleList = userMapper.selectUserRoles(1L);
            for (SysRole role : roleList) {
                System.out.println(role);
            }
            Assert.assertNotNull(roleList);
            Assert.assertTrue(roleList.size() > 0);
        }
    }

}
