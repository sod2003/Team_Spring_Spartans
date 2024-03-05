package com.skillstorm.spartanwireless.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "phone_line")
public class PhoneLine {

    @Id
    @Column(name = "phone_number")
    private String phoneNumber;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "cust_id")
    private Customer customer;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "device_id")
    private Device device;
}
