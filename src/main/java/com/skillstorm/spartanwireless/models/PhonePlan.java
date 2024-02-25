package com.skillstorm.spartanwireless.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "phone_plan")
public class PhonePlan {

    @Id
    @Column(name = "phone_plan_id")
    private Long phonePlanId;
    
    @Column(name = "phone_lines")
    private int phoneLines;

    @Column(name = "data_limit")
    private int dataLimit;

    @Column(name = "cost")
    private double cost;

    @ManyToMany(mappedBy = "phonePlans")
    private List<Customer> customers;
}
