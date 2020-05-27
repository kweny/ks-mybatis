package ks.mybatis.simple;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;
import ks.mybatis.simple.entity.Country;

import java.io.Reader;
import java.util.List;

public class CountryMapperTest {

    private static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void init() {
        // 读取 mybatis-config.xml 配置文件，并创建 SqlSessionFactory 工厂对象
        try (Reader reader = Resources.getResourceAsReader("mybatis-config.xml")) {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectAll() {
        /*
            使用 SqlSessionFactory 工厂对象获取 SqlSession，
            通过 SqlSession 的 selectList 方法找到 CountryMapper.xml 中名为 selectAll 的 Statement 并执行，
            MyBatis 底层将使用 JDBC 执行 SQL 获得结果集 ResultSet，根据 resultType 指定的类型，将结果集映射为 Country 类型的集合，
            执行完成后需要关闭 SqlSession 对象，此处使用 try-with-resources 方式自动关闭。
         */
        try (SqlSession session = sqlSessionFactory.openSession()) {
            List<Country> countryList = session.selectList("selectAll");
            for (Country country : countryList) {
                System.out.println(country);
            }
        }
    }

}