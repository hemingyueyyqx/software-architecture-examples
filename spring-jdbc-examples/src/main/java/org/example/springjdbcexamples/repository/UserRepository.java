package org.example.springjdbcexamples.repository;

import org.example.springjdbcexamples.dox.Address;
import org.example.springjdbcexamples.dox.User;
import org.example.springjdbcexamples.dto.UserAddress;
import org.example.springjdbcexamples.dto.UserCountDTO;
import org.example.springjdbcexamples.mapper.UserAddressResultSetExtractor;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
    User findByAccount(String account);
@Query(value="select * from user u join address a on u.id = a.user_id where a.user_id=:uid",
resultSetExtractorClass = UserAddressResultSetExtractor.class)
UserAddress findUserAddress(String uid);
@Query("""
select u.id as user_id,u.name,count(a.user_id) as count from user u  left join address a
on u.id=a.user_id
group by u.id
order by count
""")
List<UserCountDTO> findCounts();
@Query("select * from user u join address a on u.id = a.user_id where a.id=:aid")
    User find(String aid);
@Query("select * from user u where u.account=:account and u.password=:password")
    User find(String account, String password);
}
