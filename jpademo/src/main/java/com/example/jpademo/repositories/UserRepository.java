package com.example.jpademo.repositories;

import com.example.jpademo.entity.User;
import com.example.jpademo.transactions.DemoEntityManagerResolver;
import org.apache.deltaspike.data.api.EntityManagerConfig;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

        import java.util.List;

@Repository(forEntity = User.class)
@EntityManagerConfig(entityManagerResolver = DemoEntityManagerResolver.class)
public interface UserRepository extends EntityRepository<User, Long> {

    List<User> findByName(String name);
	User findOneById(long id);

}
