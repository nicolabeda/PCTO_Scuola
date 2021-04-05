package itiseveri.pcto.pcto.repository;

import itiseveri.pcto.pcto.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;


@Repository
public interface UserRepository extends CrudRepository<User, Long>{}
