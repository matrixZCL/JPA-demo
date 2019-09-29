package com.zcl;

import com.zcl.domain.User;
import com.zcl.utils.JpaUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestJpa {
    @Test
    public void testSave(){
//        //加载配置文件创建工厂对象
//        EntityManagerFactory myJpa = Persistence.createEntityManagerFactory("myJpa");
//
//        //通过实体管理工厂获得实体管理器
//        EntityManager entityManager = myJpa.createEntityManager();

        EntityManager entityManager =JpaUtils.getEntityManager();

        //获取事务对象
        EntityTransaction transaction = entityManager.getTransaction();

        //开启事务
        transaction.begin();

        User user=new User();
        user.setUsername("zhangsan");
        user.setPassword("123");

        //向数据库插入数据user
        entityManager.persist(user);

        //提交事务
        transaction.commit();

//        //释放资源
//        entityManager.close();
//        myJpa.close();

        JpaUtils.factoryClose();


    }

    @Test
    public void testFind(){
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        User user = entityManager.find(User.class, 1);//参数1：传入返回对象类型  参数2：传入的主键id
        System.out.println(user);
        transaction.commit();
        entityManager.close();
    }

}
