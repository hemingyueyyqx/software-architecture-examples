package org.example.springjdbcexamples.repository;

import lombok.extern.slf4j.Slf4j;
import org.example.springjdbcexamples.dox.Address;
import org.example.springjdbcexamples.dto.AddressUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class AddressRepositoryTest {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private UserRepository userRepository;
    @Test
    public void saveAddress() {
        Address address = Address.builder().detail("909").userId("1315944192462041088").build();
        addressRepository.save(address);
    }
//    @Test
//    void findByUserId() {
//        for(Address a : addressRepository.findByUserId("1315944192462041088")) {
//            log.debug("address : {}", a);
//        }
//    }

    @Test
    void updateDetail() {
    }

    @Test
    void deleteAddressById() {
    }

    @Test
    void findAddressUserById() {
        AddressUser addressUser = addressRepository.findAddressUserById("1315915852791427072");
        log.debug("{}",addressUser.getUser());
        log.debug("{}", addressUser.getAddress());
    }

    @Test
    void findAddresses() {
        List<Address> addresses = addressRepository.findAddresses("1315944192462041088");
        for(Address a : addresses) {
            log.debug("address : {}", a);
        }
    }
}