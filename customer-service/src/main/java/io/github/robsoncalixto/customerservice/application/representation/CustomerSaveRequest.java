package io.github.robsoncalixto.customerservice.application.representation;

import io.github.robsoncalixto.customerservice.domain.Customer;

import java.util.Objects;

public class CustomerSaveRequest {
    private String cpf;
    private String name;
    private Integer age;

    public Customer toModel() {
        return new Customer(this.cpf,this.name, this.age);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerSaveRequest that = (CustomerSaveRequest) o;
        return cpf.equals(that.cpf) && name.equals(that.name) && age.equals(that.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf, name, age);
    }

}
