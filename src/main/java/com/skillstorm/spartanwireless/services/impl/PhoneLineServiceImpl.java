package com.skillstorm.spartanwireless.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.spartanwireless.dtos.PhoneLineResponseDto;
import com.skillstorm.spartanwireless.models.Customer;
import com.skillstorm.spartanwireless.models.Device;
import com.skillstorm.spartanwireless.models.PhoneLine;
import com.skillstorm.spartanwireless.repositories.CustomerRepository;
import com.skillstorm.spartanwireless.repositories.DeviceRepository;
import com.skillstorm.spartanwireless.repositories.PhoneLineRepository;
import com.skillstorm.spartanwireless.services.PhoneLineService;

import static com.skillstorm.spartanwireless.mappers.PhoneLineMapper.mapToPhoneLineResponseDto;

@Service
public class PhoneLineServiceImpl implements PhoneLineService {

    @Autowired
    private PhoneLineRepository phoneLineRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private DeviceRepository deviceRepository;

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
    public PhoneLineResponseDto createPhoneLine(Long custId, Long deviceId) {
        Customer customer = customerRepository.findById(custId).get();
        Device device = deviceRepository.findById(deviceId).get();
        PhoneLine phoneLine = PhoneLine
                .builder()
                .phoneNumber(numberGenerator())
                .customer(customer)
                .device(device)
                .build();
        return mapToPhoneLineResponseDto(phoneLineRepository.save(phoneLine));
    }

    @SuppressWarnings("null")
    @Override
    public List<PhoneLineResponseDto> getAllPhoneLines(Long custId) {
        Customer customer = customerRepository.findById(custId).get();
        return phoneLineRepository.findAll(customer).stream().map((phoneLine) -> mapToPhoneLineResponseDto(phoneLine))
                .collect(Collectors.toList());
    }

    @SuppressWarnings("null")
    @Override
    public PhoneLineResponseDto getPhoneLineById(String phoneNumber) {
        return mapToPhoneLineResponseDto(phoneLineRepository.findById(phoneNumber).get());
    }

    /*
     * (Comment in Controller)
     * 
     * @Override
     * public PhoneLineResponseDto updatePhoneLine(String phoneNumber,
     * PhoneLineRequestDto phoneLineRequestDto) {
     * PhoneLine phoneLine = phoneLineRepository.findById(phoneNumber).get();
     * phoneLine.setPhoneNumber(phoneLineRequestDto.getPhoneNumber());
     * return mapToPhoneLineResponseDto(phoneLineRepository.save(phoneLine));
     * }
     */

    @SuppressWarnings("null")
    @Override
    public void deletePhoneLine(String phoneNumber) {
        phoneLineRepository.deleteById(phoneNumber);
    }

    public String numberGenerator() {
        Random random = new Random();
        long phoneNumber;
        Optional<PhoneLine> phoneLine;

        do {
            int random1 = random.nextInt(900) + 100;
            int random2 = random.nextInt(900) + 100;
            int random3 = random.nextInt(9000) + 1000;
            phoneNumber = Long.parseLong("" + random1 + random2 + random3);
            phoneLine = phoneLineRepository.findById("" + phoneNumber);
        } while (phoneLine.isPresent());

        System.out.println(phoneNumber);
        return "" + phoneNumber;
    }

}
