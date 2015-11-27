package cc.aisc.platform.commons.entity;

import cc.aisc.platform.commons.base.BaseEntity;
import com.google.common.base.Objects;

import javax.persistence.Column;
import javax.persistence.*;

/**
 * Created by sjf on 15-10-25.
 */
@Entity
@Table(name = "t_cms_address")
public class Address extends BaseEntity<Long> {

    @Column
    private String addressName;
    @Column
    private String country;
    @Column
    private String province;
    @Column
    private String city;
    @Column
    private String district;
    @Column
    private String street;
    @Column
    private String details;
    @Column
    private String zip;



    @Override
    public String toString() {
        return "Address{" +
                "addressName='" + addressName + '\'' +
                ", country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", street='" + street + '\'' +
                ", details='" + details + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Address address = (Address) o;
        return Objects.equal(addressName, address.addressName) &&
                Objects.equal(country, address.country) &&
                Objects.equal(province, address.province) &&
                Objects.equal(city, address.city) &&
                Objects.equal(district, address.district) &&
                Objects.equal(street, address.street) &&
                Objects.equal(details, address.details) &&
                Objects.equal(zip, address.zip);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), addressName, country, province, city, district, street, details, zip);
    }

    public String getAddressName() {

        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
