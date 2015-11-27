package cc.aisc.platform.eny.commons.entity;

import cc.aisc.platform.commons.base.BaseEntity;
import com.google.common.base.Objects;

import javax.persistence.*;

/**
 * Created by sjf on 15-11-18.
 */
@Entity
@Table(name = "t_traits")
public class Trait extends BaseEntity<Long>{

    @Column(name = "trait")
    private String trait;

    @Column(name = "belong2")
    private String belong2;

    @Column(name = "belong2_id")
    private String belong2id;

    @Column(name = "order_num")
    private String orderNum;


    @Override
    public String toString() {
        return "Trait{" +
                "trait='" + trait + '\'' +
                ", belong2='" + belong2 + '\'' +
                ", belong2id=" + belong2id +
                ", orderNum=" + orderNum +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Trait trait1 = (Trait) o;
        return Objects.equal(trait, trait1.trait) &&
                Objects.equal(belong2, trait1.belong2) &&
                Objects.equal(belong2id, trait1.belong2id) &&
                Objects.equal(orderNum, trait1.orderNum);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), trait, belong2, belong2id, orderNum);
    }

    public String getTrait() {

        return trait;
    }

    public void setTrait(String trait) {
        this.trait = trait;
    }

    public String getBelong2() {
        return belong2;
    }

    public void setBelong2(String belong2) {
        this.belong2 = belong2;
    }

    public String getBelong2id() {
        return belong2id;
    }

    public void setBelong2id(String belong2id) {
        this.belong2id = belong2id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }
}
