package SpringCrmRestAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import SpringCrmRestAPI.entity.Customer;
import SpringCrmRestAPI.persistence.UserRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	// need to inject customer dao
//	@Autowired
//	private CustomerDAO customerDAO;
	
	@Autowired
	private UserRepository customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.findAll();
		
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {

		customerDAO.save(theCustomer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		
		Customer customer = customerDAO.findById(theId).get();
		
		return customer;
		//return customerDAO.findCustomer(theId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		
		Customer customer = customerDAO.findById(theId).get();
		customerDAO.delete(customer);
	}
}





