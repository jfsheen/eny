package cc.aisc.platform.commons.entity;

import cc.aisc.platform.commons.base.BaseEntity;
import cc.aisc.platform.commons.base.pojo.Gender;
import com.google.common.base.Objects;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sjf on 15-11-11.
 */
@Entity
@Table(name = "t_cms_person")
public class Person extends BaseEntity<Long>{
    @Column
    private String name;
    @Column
    @Enumerated(EnumType.ORDINAL)
    private Gender gender;
    @Column
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Column
    private Integer height;
    @Column
    private Integer weight;
    @Column
    private String idCardNum;
    @Column
    private String nationality;
    @Column
    private String minzu;
    @Column
    private String photoPrefix;
    @Column
    private String reserved;


    public Person(){}

    public Person(String name, Gender gender, String idCardNum){
        this.name = name;
        this.gender = gender;
        this.idCardNum = idCardNum;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", birthDate=" + birthDate +
                ", height=" + height +
                ", weight=" + weight +
                ", idCardNum='" + idCardNum + '\'' +
                ", nationality='" + nationality + '\'' +
                ", minzu='" + minzu + '\'' +
                ", photoPrefix='" + photoPrefix + '\'' +
                ", reserved='" + reserved + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Person person = (Person) o;
        return Objects.equal(name, person.name) &&
                Objects.equal(gender, person.gender) &&
                Objects.equal(birthDate, person.birthDate) &&
                Objects.equal(height, person.height) &&
                Objects.equal(weight, person.weight) &&
                Objects.equal(idCardNum, person.idCardNum) &&
                Objects.equal(nationality, person.nationality) &&
                Objects.equal(minzu, person.minzu) &&
                Objects.equal(photoPrefix, person.photoPrefix) &&
                Objects.equal(reserved, person.reserved);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), name, gender, birthDate, height, weight, idCardNum, nationality, minzu, photoPrefix, reserved);
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getIdCardNum() {
        return idCardNum;
    }

    public void setIdCardNum(String idCardNum) {
        this.idCardNum = idCardNum;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getMinzu() {
        return minzu;
    }

    public void setMinzu(String minzu) {
        this.minzu = minzu;
    }

    public String getPhotoPrefix() {
        return photoPrefix;
    }

    public void setPhotoPrefix(String photoPrefix) {
        this.photoPrefix = photoPrefix;
    }

    public String getReserved() {
        return reserved;
    }

    public void setReserved(String reserved) {
        this.reserved = reserved;
    }

}
