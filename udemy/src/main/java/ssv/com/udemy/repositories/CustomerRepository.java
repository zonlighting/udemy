package ssv.com.udemy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ssv.com.udemy.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
}
