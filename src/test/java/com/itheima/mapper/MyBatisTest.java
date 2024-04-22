package com.itheima.mapper;
import com.itheima.pojo.Users;
import com.itheima.pojo.Person;
import com.itheima.pojo.Worker;
import com.itheima.pojo.Employee;
import com.itheima.Utils.MyBatisUtils;
import com.itheima.pojo.Category;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyBatisTest {
    //(1)根据id查询员工信息
    @Test
    public void select01() {
        //通过工具类获取SQLSession对象
        SqlSession sqlSession = MyBatisUtils.getSession();
        //创建Employee对象接收SQL语句的查询结果
        Employee employee01 = sqlSession.selectOne("select01",2);
        System.out.println(employee01);
        //关闭事务
        sqlSession.close();
    }
    //(2)新增员工信息
    @Test
    public void insert02() {
        SqlSession sqlSession = MyBatisUtils.getSession();
        //实例化Employee
        Employee employee = new Employee();
        employee.setId(4);
        employee.setName("赵六");
        employee.setAge(100);
        employee.setPosition("老板");
        //这里的insertID一定要与EmployeeMapper文件中的id对应，要一模一样
        sqlSession.insert("insert02",employee);
        System.out.println("添加成功！");
        sqlSession.close();
    }
    //(3)根据id修改员工信息
    @Test
    public void update03() {
        SqlSession sqlSession = MyBatisUtils.getSession();
        Employee employee = new Employee();
        employee.setId(3);
        employee.setName("陈二");
        employee.setAge(40);
        employee.setPosition("经理");
        sqlSession.insert("update03",employee);
        System.out.println("更新成功！");
        sqlSession.close();
    }
    //(4)根据id删除员工信息
    @Test
    public void delete04() {
        SqlSession sqlSession = MyBatisUtils.getSession();
        sqlSession.delete("delete04", 4);
        System.out.println("删除成功！");
        sqlSession.close();
    }
    @Test
    public void findPersonByIdTest() {
        // 1、通过工具类获取SqlSession对象
        SqlSession session = MyBatisUtils.getSession();
        // 2.使用MyBatis嵌套查询的方式查询id为1的人的信息
        Person person = session.selectOne("com.itheima.mapper."
                + "PersonMapper.findPersonById", 1);
        // 3、输出查询结果信息
        System.out.println(person);
        // 4、关闭SqlSession
        session.close();
    }
    @Test
    public void findUserTest() {
        // 1.通过工具类生成SqlSession对象
        SqlSession session = MyBatisUtils.getSession();
        // 2.查询id为1的用户信息
        Users users = session.selectOne("com.itheima.mapper."
                + "UsersMapper.findUserWithOrders", 1);
        // 3.输出查询结果信息
        System.out.println(users);
        // 4.关闭SqlSession
        session.close();
    }
    @Test
    public void findCategoryTest(){
        SqlSession session = MyBatisUtils.getSession();
        Category category=session.selectOne("com.itheima.mapper."+"CategoryMapper.findCategoryWithProduct",2);
        System.out.println(category);
        session.close();
    }
    @Test
    public void findWorkerByIdTest() {
        // 1.获取SqlSession对象
        SqlSession session = MyBatisUtils.getSession();
        WorkerMapper mapper = session.getMapper(WorkerMapper.class);
        // 2.查询id为1的员工信息
        Worker worker = mapper.selectWorker(1);
        System.out.println(worker.toString());
        // 3.关闭SqlSession
        session.close();
    }
    @Test
    public void insertWorkerTest() {
        // 1.生成SqlSession对象
        SqlSession session = MyBatisUtils.getSession();
        Worker worker = new Worker();
        worker.setId(4);	worker.setName("赵六");	worker.setAge(36);
        worker.setSex("女");	worker.setWorker_id("1004");
        WorkerMapper mapper = session.getMapper(WorkerMapper.class);
        // 2.插入员工信息
        int result = mapper.insertWorker(worker);
        // 输出语句省略...
        session.commit();	session.close(); // 3.关闭SqlSession
    }
    @Test
    public void updateWorkerTest() {
        // 1.生成SqlSession对象
        SqlSession session = MyBatisUtils.getSession();
        Worker worker = new Worker();
        worker.setId(4);	worker.setName("李华");
        worker.setAge(28);
        WorkerMapper mapper = session.getMapper(WorkerMapper.class);
        // 2.更新员工信息
        int result = mapper.updateWorker(worker);
        // 输出语句省略...
        session.commit();
        session.close(); // 3.关闭SqlSession
    }
}