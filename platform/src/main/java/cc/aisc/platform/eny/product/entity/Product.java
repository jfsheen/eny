package cc.aisc.platform.eny.product.entity;

import cc.aisc.platform.commons.base.BaseEntity;
import com.google.common.base.Objects;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by sjf on 15-11-3.
 */
@Entity
@Table(name = "t_prdt_product")
public class Product extends BaseEntity<Long> {

    @Column(name = "product_sn", nullable = false)
    private String productSn;

    @Column(name = "product_name")
    private String productName;

    @OneToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Temporal(value = TemporalType.DATE)
    @Column(name="date_produce")
    private Date dateProduction;

    @Temporal(value = TemporalType.DATE)
    @Column(name="date_market")
    private Date dateMarket;

    @Column(name="size")
    private String size;

    @Column(name="weight")
    private String weight;

    @Column(name="description")
    private String description;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER, mappedBy = "product")
    private List<PrdtPropValue> prdtPropValueList;

    @Override
    public String toString() {
        return "Product{" +
                "productSn='" + productSn + '\'' +
                ", productName='" + productName + '\'' +
                ", category=" + category +
                ", dateProduction=" + dateProduction +
                ", dateMarket=" + dateMarket +
                ", size='" + size + '\'' +
                ", weight='" + weight + '\'' +
                ", description='" + description + '\'' +
                ", prdtPropValueList=" + prdtPropValueList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Product product = (Product) o;
        return Objects.equal(productSn, product.productSn) &&
                Objects.equal(productName, product.productName) &&
                Objects.equal(category, product.category) &&
                Objects.equal(dateProduction, product.dateProduction) &&
                Objects.equal(dateMarket, product.dateMarket) &&
                Objects.equal(size, product.size) &&
                Objects.equal(weight, product.weight) &&
                Objects.equal(description, product.description) &&
                Objects.equal(prdtPropValueList, product.prdtPropValueList);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), productSn, productName, category, dateProduction, dateMarket, size, weight, description, prdtPropValueList);
    }

    public String getProductSn() {

        return productSn;
    }

    public void setProductSn(String productSn) {
        this.productSn = productSn;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Date getDateProduction() {
        return dateProduction;
    }

    public void setDateProduction(Date dateProduction) {
        this.dateProduction = dateProduction;
    }

    public Date getDateMarket() {
        return dateMarket;
    }

    public void setDateMarket(Date dateMarket) {
        this.dateMarket = dateMarket;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<PrdtPropValue> getPrdtPropValueList() {
        return prdtPropValueList;
    }

    public void setPrdtPropValueList(List<PrdtPropValue> prdtPropValueList) {
        this.prdtPropValueList = prdtPropValueList;
    }
}
