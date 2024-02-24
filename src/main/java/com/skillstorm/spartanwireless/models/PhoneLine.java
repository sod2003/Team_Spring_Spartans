package com.skillstorm.spartanwireless.models;

import jakarta.persistence.AssociationOverride;
import jakarta.persistence.AssociationOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "phone_line")
@AssociationOverrides({
    @AssociationOverride(name = "primaryKey.customer",
        joinColumns = @JoinColumn(name = "cust_id")),
    @AssociationOverride(name = "primaryKey.device",
        joinColumns = @JoinColumn(name = "device_id")) })
public class PhoneLine {

    private PhoneLineId primaryKey = new PhoneLineId();

    @Column(name = "phone_number")
    private String phoneNumber;

    @EmbeddedId
    public PhoneLineId getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(PhoneLineId primaryKey) {
        this.primaryKey = primaryKey;
    }

    @Transient
    public Customer getCustomer() {
        return getPrimaryKey().getCustomer();
    }
 
    public void setCustomer(Customer customer) {
        getPrimaryKey().setCustomer(customer);
    }
 
    @Transient
    public Device getDevice() {
        return getPrimaryKey().getDevice();
    }
 
    public void setDevice(Device device) {
        getPrimaryKey().setDevice(device);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((primaryKey == null) ? 0 : primaryKey.hashCode());
        result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PhoneLine other = (PhoneLine) obj;
        if (primaryKey == null) {
            if (other.primaryKey != null)
                return false;
        } else if (!primaryKey.equals(other.primaryKey))
            return false;
        if (phoneNumber == null) {
            if (other.phoneNumber != null)
                return false;
        } else if (!phoneNumber.equals(other.phoneNumber))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "PhoneLine [primaryKey=" + primaryKey + ", phoneNumber=" + phoneNumber + "]";
    }
}
