package io.github.robsoncalixto.customerservice.application;

import io.github.robsoncalixto.customerservice.application.representation.CustomerSaveRequest;
import io.github.robsoncalixto.customerservice.service.CustomerService;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("customer")
public class CustomerResource {

    private  final CustomerService customerService;

    public CustomerResource(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping
    public  String status(){
        return "Ok";
    }

    @PostMapping
    public ResponseEntity save(@RequestBody @NotNull CustomerSaveRequest request){
        var customer = request.toModel();
        customerService.save(customer);
        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("cpf={}")
                .buildAndExpand(customer.getCpf())
                .toUri();
        return  ResponseEntity.created(headerLocation).build();
    }

    @GetMapping(params = "cpf")
    public ResponseEntity getCustomer(@RequestParam("cpf") String cpf){
        var customer = customerService.getByCPF(cpf);
        if(customer.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customer);
    }

}

