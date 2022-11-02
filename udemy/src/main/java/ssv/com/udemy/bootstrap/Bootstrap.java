package ssv.com.udemy.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ssv.com.udemy.repositories.CategoryRepository;
import ssv.com.udemy.repositories.CustomerRepository;
import ssv.com.udemy.domain.Category;
import ssv.com.udemy.domain.Customer;

@Component
public class Bootstrap implements CommandLineRunner {
    private CategoryRepository categoryRepository;
    private final CustomerRepository customerRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadCategories();
        loadCustomers();
    }

    private void loadCustomers() {
        Customer customer1 = new Customer();
        customer1.setId(1l);
        customer1.setFirstname("Michale");
        customer1.setLastname("Weston");
        customerRepository.save(customer1);

        Customer customer2 = new Customer();
        customer2.setId(2l);
        customer2.setFirstname("Sam");
        customer2.setLastname("Axe");

        customerRepository.save(customer2);

        System.out.println("Customers Loaded: " + customerRepository.count());

    }

    private void loadCategories() {
        Category fruits = new Category();
        fruits.setName("fruits");

        Category dried = new Category();
        fruits.setName("dried");

        Category fresh = new Category();
        fruits.setName("fresh");

        Category exotic = new Category();
        fruits.setName("exotic");

        Category nuts = new Category();
        fruits.setName("nuts");

        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);

        System.out.println("data loaded = " + categoryRepository.count());

    }
}
