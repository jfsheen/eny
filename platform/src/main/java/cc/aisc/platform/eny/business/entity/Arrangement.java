package cc.aisc.platform.eny.business.entity;

import cc.aisc.platform.commons.base.BaseEntity;
import com.google.common.base.Objects;

import javax.persistence.*;

/**
 * Created by sjf on 15-11-12.
 */
@Entity
@Table(name = "t_biz_dlargmt")
public class Arrangement extends BaseEntity<Long>{

    @Column(name = "total_person")
    private Integer personTotal;

    @Column(name = "male_count")
    private Integer maleCount;

    @Column(name = "female_count")
    private Integer femaleCount;

    @Column(name = "children_count")
    private Integer childrenCount;

    @Column(name = "come_from")
    private String comeFrom;

    @Column(name = "by_vehicle")
    private String vehicle;

    @Column(name = "message")
    private String message;

    @Column(name = "specials")
    private String specials;

    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "deal_id")
    private Deal deal;

    @Override
    public String toString() {
        return "ArrangementDao{" +
                "personTotal=" + personTotal +
                ", maleCount=" + maleCount +
                ", femaleCount=" + femaleCount +
                ", childrenCount=" + childrenCount +
                ", comeFrom='" + comeFrom + '\'' +
                ", vehicle='" + vehicle + '\'' +
                ", message='" + message + '\'' +
                ", specials='" + specials + '\'' +
                ", deal=" + deal +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Arrangement that = (Arrangement) o;
        return Objects.equal(personTotal, that.personTotal) &&
                Objects.equal(maleCount, that.maleCount) &&
                Objects.equal(femaleCount, that.femaleCount) &&
                Objects.equal(childrenCount, that.childrenCount) &&
                Objects.equal(comeFrom, that.comeFrom) &&
                Objects.equal(vehicle, that.vehicle) &&
                Objects.equal(message, that.message) &&
                Objects.equal(specials, that.specials) &&
                Objects.equal(deal, that.deal);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), personTotal, maleCount, femaleCount, childrenCount, comeFrom, vehicle, message, specials, deal);
    }

    public Deal getDeal() {

        return deal;
    }

    public void setDeal(Deal deal) {
        this.deal = deal;
    }

    public Integer getPersonTotal() {
        return personTotal;
    }

    public void setPersonTotal(Integer personTotal) {
        this.personTotal = personTotal;
    }

    public Integer getMaleCount() {
        return maleCount;
    }

    public void setMaleCount(Integer maleCount) {
        this.maleCount = maleCount;
    }

    public Integer getFemaleCount() {
        return femaleCount;
    }

    public void setFemaleCount(Integer femaleCount) {
        this.femaleCount = femaleCount;
    }

    public Integer getChildrenCount() {
        return childrenCount;
    }

    public void setChildrenCount(Integer childrenCount) {
        this.childrenCount = childrenCount;
    }

    public String getComeFrom() {
        return comeFrom;
    }

    public void setComeFrom(String comeFrom) {
        this.comeFrom = comeFrom;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSpecials() {
        return specials;
    }

    public void setSpecials(String specials) {
        this.specials = specials;
    }
}
