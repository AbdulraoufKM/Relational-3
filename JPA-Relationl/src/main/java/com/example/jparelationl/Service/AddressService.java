package com.example.jparelationl.Service;

import com.example.jparelationl.Api.ApiException;
import com.example.jparelationl.DTO.AddressDTO;
import com.example.jparelationl.Model.Address;
import com.example.jparelationl.Model.Teacher;
import com.example.jparelationl.Repository.AddressRepository;
import com.example.jparelationl.Repository.TeacherRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;

    public List<Address> getAllAddress(){
        return addressRepository.findAll();
    }

    public void addAddress(AddressDTO addressDTO){
        Teacher teacher= teacherRepository.findTeacherById(addressDTO.getTeacher_id());

        if (teacher == null){
            throw new ApiException("Teacher not found");
        }

        Address address = new Address(null , addressDTO.getArea(),addressDTO.getStreet(), addressDTO.getBuilding_number(), teacher);
        addressRepository.save(address);
    }

    public void updateAddress(AddressDTO addressDTO){
        Address address = addressRepository.findAddressById(addressDTO.getTeacher_id());

        if(address == null){
            throw new ApiException("address not found");
        }
        address.setArea(addressDTO.getArea());
        address.setStreet(addressDTO.getStreet());
        address.setBuilding_number(addressDTO.getBuilding_number());

        addressRepository.save(address);

    }


    public void deleteAddress(Integer id){
        Address address = addressRepository.findAddressById(id);
        if(address == null){
            throw new ApiException("address not found");
        }

        addressRepository.delete(address);
    }



}
