package cc.aisc.platform.eny.business.entity;

import cc.aisc.platform.commons.base.BaseEntity;
import cc.aisc.platform.eny.product.entity.Product;
import com.google.common.base.Objects;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by sjf on 15-11-12.
 */
@Entity
@Table(name = "t_biz_deal")
public class Deal extends BaseEntity<Long>{
    @Column(name = "deal_sn")
    private String dealSn;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "fee")
    private Integer fee;

    @Column(name = "discount")
    private Integer discount;

    @Column(name = "begin_date")
    @Temporal(TemporalType.DATE)
    private Date dateBegin;

    @Column(name = "expiry_date")
    @Temporal(TemporalType.DATE)
    private Date dateExpiry;

    @Column(name = "remarks")
    private String remarks;

    @OneToOne(mappedBy = "deal")
    private Arrangement arrangement;

    @Override
    public String toString() {
        return "Deal{" +
                "dealSn='" + dealSn + '\'' +
                ", contract=" + contract +
                ", product=" + product +
                ", fee=" + fee +
                ", discount=" + discount +
                ", dateBegin=" + dateBegin +
                ", dateExpiry=" + dateExpiry +
                ", remarks='" + remarks + '\'' +
                ", arrangement=" + arrangement +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Deal deal = (Deal) o;
        return Objects.equal(dealSn, deal.dealSn) &&
                Objects.equal(contract, deal.contract) &&
                Objects.equal(product, deal.product) &&
                Objects.equal(fee, deal.fee) &&
                Objects.equal(discount, deal.discount) &&
                Objects.equal(dateBegin, deal.dateBegin) &&
                Objects.equal(dateExpiry, deal.dateExpiry) &&
                Objects.equal(remarks, deal.remarks) &&
                Objects.equal(arrangement, deal.arrangement);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), dealSn, contract, product, fee, discount, dateBegin, dateExpiry, remarks, arrangement);
    }

    public String getDealSn() {

        return dealSn;
    }

    public void setDealSn(String dealSn) {
        this.dealSn = dealSn;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getFee() {
        return fee;
    }

    public void setFee(Integer fee) {
        this.fee = fee;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Date getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
    }

    public Date getDateExpiry() {
        return dateExpiry;
    }

    public void setDateExpiry(Date dateExpiry) {
        this.dateExpiry = dateExpiry;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Arrangement getArrangement() {
        return arrangement;
    }

    public void setArrangement(Arrangement arrangement) {
        this.arrangement = arrangement;
    }
}
