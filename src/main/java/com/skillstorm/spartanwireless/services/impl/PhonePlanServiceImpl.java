package com.skillstorm.spartanwireless.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.spartanwireless.dtos.PhonePlanResponseDto;
import com.skillstorm.spartanwireless.exceptions.PhonePlanNotPurchasedException;
import com.skillstorm.spartanwireless.models.Customer;
import com.skillstorm.spartanwireless.models.PhonePlan;
import com.skillstorm.spartanwireless.repositories.CustomerRepository;
import com.skillstorm.spartanwireless.repositories.PhonePlanRepository;
import com.skillstorm.spartanwireless.services.PhonePlanService;

import static com.skillstorm.spartanwireless.mappers.PhonePlanMapper.mapToPhonePlanResponseDto;

@Service
public class PhonePlanServiceImpl implements PhonePlanService {

    @Autowired
    private PhonePlanRepository phonePlanRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public PhonePlanServiceImpl(PhonePlanRepository ppr, CustomerRepository cs) {
        phonePlanRepository = ppr;
        customerRepository = cs;
    }

    /*
     * Type is completely known from custom mappers,
     * you will see that we have checked this for every
     * api. We are suppressing warnings. The input from the
     * request are validated, then they are funnelled through
     * our custom wrappers that are EXPLICITYLY TYPED. Or,
     * in the case when there are no dtos (just id's) the EXACT
     * type from the controller down the api is ensured.
     * For the sake of being concise, we are not using Generic
     * types which would need explicit null checks.
     */
    @SuppressWarnings("null")
    @Override
    public PhonePlanResponseDto createPhonePlan(Long custId, Long phonePlanId) {
        PhonePlan phonePlan = phonePlanRepository.findById(phonePlanId).get();
        Customer customer = customerRepository.findById(custId).get();
        List<PhonePlan> phonePlans = customer.getPhonePlans();
        if (phonePlans == null) {
            phonePlans = new ArrayList<>();
        }
        phonePlans.add(phonePlan);
        customer.setPhonePlans(phonePlans);
        customerRepository.save(customer);
        return mapToPhonePlanResponseDto(phonePlan);
    }

    @Override
    public List<PhonePlanResponseDto> getAllPhonePlansByCustId(Long custId) {
        return phonePlanRepository.findAll(custId).stream().map((phonePlan) -> mapToPhonePlanResponseDto(phonePlan))
                .collect(Collectors.toList());
    }

    @SuppressWarnings("null")
    @Override
    public PhonePlanResponseDto getPhonePlanById(Long custId, Long phonePlanId) {
        Customer customer = customerRepository.findById(custId).get();
        List<PhonePlan> phonePlans = customer.getPhonePlans();
        for (PhonePlan phonePlan : phonePlans) {
            if (phonePlan.getPhonePlanId() == phonePlanId) {
                return mapToPhonePlanResponseDto(phonePlanRepository.findById(phonePlanId).get());
            }
        }
        throw new PhonePlanNotPurchasedException();
    }

    /*
     * (comment in controller)
     * 
     * @Override
     * public PhonePlanResponseDto updatePhonePlan(Long phonePlanId,
     * PhonePlanRequestDto phonePlanRequestDto) {
     * PhonePlan phonePlan = mapToPhonePlan(phonePlanRequestDto);
     * phonePlan.setPhonePlanId(phonePlanId);
     * return mapToPhonePlanResponseDto(phonePlanRepository.save(phonePlan));
     * }
     */

    @SuppressWarnings("null")
    @Override
    public void deletePhonePlan(Long custId, Long phonePlanId) {
        Customer customer = customerRepository.findById(custId).get();
        List<PhonePlan> phonePlans = customer.getPhonePlans();
        for (PhonePlan phonePlan : phonePlans) {
            if (phonePlan.getPhonePlanId() == phonePlanId) {
                phonePlans.remove(phonePlan);
                customer.setPhonePlans(phonePlans);
                customerRepository.save(customer);
                return;
            }
        }
        throw new PhonePlanNotPurchasedException();
    }

}
