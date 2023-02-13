package SpringCrmRestAPI.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import SpringCrmRestAPI.entity.Customer;

@Repository
public class CustomUserRepositoryImpl implements CustomUserRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public List<Customer> findAllCustomers() {
		
		List<Customer> customers = entityManager.createQuery("SELECT c FROM Customer c").getResultList();
		
		return customers;
	}

}
