package com.zcl;

import com.zcl.utils.JpaUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.Iterator;
import java.util.List;

public class JpqlTest {
    @Test
    public void findAll(){
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        String sql= "from User";
        Query query = entityManager.createQuery(sql);
        List resultList = query.getResultList();

        Iterator iterator = resultList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
