package com.skillstorm.spartanwireless.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.skillstorm.spartanwireless.dtos.PhoneLineRequestDto;
import com.skillstorm.spartanwireless.models.PhoneLine;
import com.skillstorm.spartanwireless.repositories.PhoneLineRepository;
import com.skillstorm.spartanwireless.services.PhoneLineService;

public class TestPhoneLineServiceImpl {

    PhoneLineService pls;
    List<PhoneLine> phoneLines;

    @BeforeAll
    public void init(){
        // TODO Create phoneLines list
        // pls = new PhoneLineServiceImpl(new TestPhoneLineRepository());
    }

    @Test
    public void TestCreatePhoneLine(PhoneLineRequestDto phoneLineRequestDto) {
        // TODO Create a test for Service's createPhoneLine method
    }

    @Test
    public void TestGetAllPhoneLines() {
        // TODO Create a test for Service's getAllPhoneLines method
    }

    @Test
    public void TestGetPhoneLineById(String phoneNumber) {
        // TODO Create a test for Service's getPhoneLineById method
    }

    @Test
    public void TestUpdatePhoneLine(String phoneNumber, PhoneLineRequestDto phoneLineRequestDto) {
        // TODO Create a test for Service's updatePhoneLine method
    }

    @Test
    public void TestDeletePhoneLine(String phoneNumber) {
        // TODO Create a test for Service's deletePhoneLine method
    }
    
}
