package SpringCrmRestAPI.persistence;

import java.util.List;

import SpringCrmRestAPI.entity.Customer;

public interface CustomUserRepository {
	
	public List<Customer> findAllCustomers();

}
