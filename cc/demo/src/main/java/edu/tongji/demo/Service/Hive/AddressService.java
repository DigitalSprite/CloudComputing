package edu.tongji.demo.Service.Hive;

import edu.tongji.demo.Model.Address;

import java.util.List;

public interface AddressService {

    List<Address> geListByAddressBy(String address);
}
