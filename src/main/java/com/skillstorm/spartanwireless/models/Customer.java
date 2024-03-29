package com.skillstorm.spartanwireless.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @Column(name = "cust_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long custId;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;
    
    @Column(name = "email")
    private String email;

    @Column(name = "archived")
    private boolean isArchived;
    
    @ManyToMany
    @JoinTable(
        name="customer_plan",
        joinColumns=@JoinColumn(name="cust_id", referencedColumnName="cust_id"),
        inverseJoinColumns=@JoinColumn(name="phone_plan_id", referencedColumnName="phone_plan_id"))
    private List<PhonePlan> phonePlans;

    @JsonManagedReference
    @OneToMany(mappedBy = "customer")
    private List<PhoneLine> lines;

    @OneToOne(mappedBy = "customer")
    private UserEntity user;
}