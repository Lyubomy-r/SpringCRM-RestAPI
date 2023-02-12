package SpringCrmRestAPI.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import SpringCrmRestAPI.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the session factory
//	@Autowired
//	private SessionFactory sessionFactory;
	
	
	@PersistenceContext
	@Qualifier("localContainerEMF")
	private EntityManager entityManager ;

	@Override
	public List<Customer> getCustomers() {
		
		List<Customer>  customers = entityManager.createQuery("SELECT c FROM Customer c").getResultList();
		
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		
		int  numId= theCustomer.getId();
		
		if(numId==0) {
			entityManager.persist(theCustomer);
			
		}else {
			entityManager.merge(theCustomer);
		}
		
		
		
	}

	@Override
	public Customer getCustomer(int theId) {
		
		Customer customer = entityManager.find(Customer.class, theId);
		
		return customer;
	}

	@Override
	public void deleteCustomer(int theId) {
		
		Customer customer = entityManager.find(Customer.class, theId);
		
		entityManager.remove(customer);
		
		
	}
	
	
// -------------------------------------------------	
			
//	@Override
//	public List<Customer> getCustomers() {
//		
//		// get the current hibernate session
//		Session currentSession = sessionFactory.getCurrentSession();
//				
//		// create a query  ... sort by last name
//		Query<Customer> theQuery = 
//				currentSession.createQuery("from Customer order by lastName",
//											Customer.class);
//		
//		// execute query and get result list
//		List<Customer> customers = theQuery.getResultList();
//				
//		// return the results		
//		return customers;
//	}
//
//	@Override
//	public void saveCustomer(Customer theCustomer) {
//
//		// get current hibernate session
//		Session currentSession = sessionFactory.getCurrentSession();
//		
//		// save/upate the customer ... finally LOL
//		currentSession.saveOrUpdate(theCustomer);
//		
//	}
//
//	@Override
//	public Customer getCustomer(int theId) {
//
//		// get the current hibernate session
//		Session currentSession = sessionFactory.getCurrentSession();
//		
//		// now retrieve/read from database using the primary key
//		Customer theCustomer = currentSession.get(Customer.class, theId);
//		
//		return theCustomer;
//	}
//
//	@Override
//	public void deleteCustomer(int theId) {
//
//		// get the current hibernate session
//		Session currentSession = sessionFactory.getCurrentSession();
//		
//		// delete object with primary key
//		Query theQuery = 
//				currentSession.createQuery("delete from Customer where id=:customerId");
//		theQuery.setParameter("customerId", theId);
//		
//		theQuery.executeUpdate();		
//	}

}











