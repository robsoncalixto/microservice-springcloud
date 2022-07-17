package io.github.robsoncalixto.customerservice.service;

import io.github.robsoncalixto.customerservice.domain.Customer;
import io.github.robsoncalixto.customerservice.infra.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRep;

    public CustomerService(CustomerRepository customerRep) {
        this.customerRep = customerRep;
    }

    @Transactional
    public Customer save(Customer customer){
        return customerRep.save(customer);
    }

    public Optional<Customer> getByCPF(String cpf){
        return customerRep.findByCpf(cpf);
    }

}
