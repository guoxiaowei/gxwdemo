package gxw.demo.repository.mybatis;

import java.util.List;

import gxw.demo.domain.User;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

@Repository
public interface PageRepositoryMyBatis {
	
	public Page<User> findUser(Pageable pageable);
	
	public Page<User> findUserByName(@Param("name") String name, Pageable pageable);
	
	public Page<User> findOrderUser(Pageable pageable, Sort sort);
	
	public Page<User> findUserByList(@Param("ids") List<String> ids, Pageable pageable);
}
