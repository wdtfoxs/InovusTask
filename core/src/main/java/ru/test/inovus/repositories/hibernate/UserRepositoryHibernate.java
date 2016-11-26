package ru.test.inovus.repositories.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.test.inovus.entity.User;
import ru.test.inovus.repositories.UserRepository;

@Repository
public class UserRepositoryHibernate implements UserRepository{

    @Autowired
    private SessionFactory sessionFactory;

    private Session curSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void add(User user) {
        curSession().save(user);
    }

    @Override
    public User getUseByUsername(String username){
        return (User) curSession().createCriteria(User.class)
                .add(Restrictions.eq("username", username)).uniqueResult();
    }

}
