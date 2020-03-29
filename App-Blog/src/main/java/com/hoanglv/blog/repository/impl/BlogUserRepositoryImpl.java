package com.hoanglv.blog.repository.impl;

import com.hoanglv.blog.model.BlogUser;
import com.hoanglv.blog.repository.BloguserRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;
@Transactional
public class BlogUserRepositoryImpl implements BloguserRepository {
    @PersistenceContext
    private EntityManager em;
    @Override
    public List<BlogUser> findAll() {
        TypedQuery<BlogUser>query=em.createQuery("select b from BlogUser b",BlogUser.class);
        return query.getResultList();
    }

    @Override
    public BlogUser findById(Long id) {
        TypedQuery<BlogUser>query=em.createQuery("select b from BlogUser b where b.id=:id",BlogUser.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public void save(BlogUser model) {
        if (model.getId()!=null){
            em.merge(model);
        }else {
            em.persist(model);
        }
    }

    @Override
    public void remove(Long id) {
        BlogUser blogUser=findById(id);
        if (blogUser!=null){
            em.remove(blogUser);
        }
    }
}
