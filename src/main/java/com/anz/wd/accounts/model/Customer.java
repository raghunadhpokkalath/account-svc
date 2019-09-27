package com.anz.wd.accounts.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Customer {
    @Id
    private String customerId;
    private String customerName;
}
