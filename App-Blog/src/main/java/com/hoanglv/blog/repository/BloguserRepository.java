package com.hoanglv.blog.repository;

import com.hoanglv.blog.model.BlogUser;
import org.springframework.data.repository.CrudRepository;

public interface BloguserRepository extends CrudRepository<BlogUser,Long> {
}
