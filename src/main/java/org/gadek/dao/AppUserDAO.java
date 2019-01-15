package org.gadek.dao;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.sql.DataSource;

import org.gadek.mapper.AppUserMapper;
import org.gadek.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AppUserDAO extends JdbcDaoSupport {
 	
    @Autowired
    private EntityManager entityManager;
    
    @Autowired
    public AppUserDAO(DataSource dataSource) {
      this.setDataSource(dataSource);
    }
 
    public AppUser findUserAccount(String userName) {
        try {
            String sql = "Select e from " + AppUser.class.getName() + " e " //
                    + " Where e.userName = :userName ";
            Query query = entityManager.createQuery(sql, AppUser.class);
            query.setParameter("userName", userName);
            return (AppUser) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public List<AppUser> getUsers() {
    	String sql = AppUserMapper.BASE_SQL;
        Object[] params = new Object[] {};
        AppUserMapper mapper = new AppUserMapper();
        List<AppUser> list = this.getJdbcTemplate().query(sql, params, mapper);
        return list;
    }

}