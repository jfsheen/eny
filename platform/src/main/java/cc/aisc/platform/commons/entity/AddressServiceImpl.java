package cc.aisc.platform.commons.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * Created by sjf on 15-11-14.
 */
@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    private final AddressDao addressDao;

    @Autowired
    public AddressServiceImpl(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    @Override
    public Optional<Address> findById(Long id) {
        return Optional.ofNullable(addressDao.findOne(id));
    }

    @Override
    public Address add(Address address) {
        return addressDao.save(address);
    }

/*    @Override
    public Optional<Address> findById(String name) {
        return Optional.ofNullable(addressDao.findByAddressName(name));
    }

    @Override
    public Optional<Address> findByCity(String city) {
        return Optional.ofNullable(addressDao.findByAddressName(city));
    }*/
}
