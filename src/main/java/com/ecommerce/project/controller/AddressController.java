package com.ecommerce.project.controller;

import com.ecommerce.project.model.User;
import com.ecommerce.project.payload.AddressDTO;
import com.ecommerce.project.service.AddressService;
import com.ecommerce.project.util.AuthUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AddressController {

    @Autowired
    private AuthUtil authUtil;

    @Autowired
    private AddressService addressService;

    @GetMapping("/addresses")
    public ResponseEntity<List<AddressDTO>> getAddresses() {
        List<AddressDTO> addressList = addressService.getAddresses();

        return new ResponseEntity<List<AddressDTO>>(addressList, HttpStatus.FOUND);
    }

    @GetMapping("/addresses/{addressId}")
    public ResponseEntity<AddressDTO> getAddressById(@PathVariable Long addressId) {
        AddressDTO addressDTO = addressService.getAddressById(addressId);

        return new ResponseEntity<AddressDTO>(addressDTO, HttpStatus.FOUND);
    }

    @GetMapping("/users/addresses")
    public ResponseEntity<List<AddressDTO>> getUserAddresses() {
        User user = authUtil.loggedInUser();

        List<AddressDTO> addressesDTO = addressService.getUserAddresses(user);

        return new ResponseEntity<List<AddressDTO>>(addressesDTO, HttpStatus.FOUND);
    }

    @PostMapping("/addresses")
    public ResponseEntity<AddressDTO> createAddress(@Valid @RequestBody AddressDTO addressDTO) {

        User user = authUtil.loggedInUser();

        AddressDTO savedAddressDTO = addressService.createAddress(addressDTO, user);

        return new ResponseEntity<>(savedAddressDTO, HttpStatus.CREATED);
    }

    @PutMapping("/addresses/{addressId}")
    public ResponseEntity<AddressDTO> updateAddress(@RequestBody AddressDTO addressDTO, @PathVariable Long addressId){

        User user = authUtil.loggedInUser();

        AddressDTO updatedAddressDTO = addressService.updateAddress(addressId, addressDTO);

        return new ResponseEntity<AddressDTO>(updatedAddressDTO, HttpStatus.OK);

    }

    @DeleteMapping("/addresses/{addressId}")
    public ResponseEntity<String> deleteAddress(@PathVariable Long addressId){
        String status = addressService.deleteAddress(addressId);

        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
