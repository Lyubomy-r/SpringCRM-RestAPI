package SpringCrmRestAPI.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import SpringCrmRestAPI.entity.Customer;



//@Transactional
public interface UserRepository extends  JpaRepository <Customer, Long>, CustomUserRepository {

//	@Query("SELECT c FROM Customer c join fetch c.firstName join fetch c.email order by c.id")
//	List<Customer> findAllFetchNameAndRoles();
	
	@Query("SELECT c FROM Customer c  WHERE c.email = : email")
	Optional <Customer> findByEmail (@Param("email") String email);
	
	
		@Query("SELECT c FROM Customer c WHERE c.id = :id")
		Customer findCustomer(@Param("id") int id);
	
	
	
	
}

