package com.skillstorm.spartanwireless.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "phone_line")
@IdClass(PhoneLineId.class)
public class PhoneLine {

    @Id
    private Long customerId;

    @Id
    private Long deviceId;

    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "cust_id", referencedColumnName = "cust_id")
    private Customer customer;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "device_id", referencedColumnName = "device_id")
    private Device device;
}
