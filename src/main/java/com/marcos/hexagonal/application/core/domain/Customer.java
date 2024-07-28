package com.marcos.hexagonal.application.core.domain;

public class Customer {

    private String id;

    private String name;

    private Address address;

    private String cpf;

    private boolean isCpfValid;

    public Customer(){
        this.isCpfValid = false;
    }

    public Customer(String id, String name, Address address, String cpf, boolean isCpfValid) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.cpf = cpf;
        this.isCpfValid = isCpfValid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean isCpfValid() {
        return isCpfValid;
    }

    public void setCpfValid(boolean cpfValid) {
        isCpfValid = cpfValid;
    }
}
