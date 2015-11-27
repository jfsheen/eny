package cc.aisc.platform.eny.business.entity;

import cc.aisc.platform.commons.base.BaseEntity;
import com.google.common.base.Objects;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by sjf on 15-11-12.
 */
@Entity
@Table(name = "t_biz_invoice")
public class Invoice extends BaseEntity<Long> {

    @Column(name="invoice_sn")
    private String invoiceSn;

    @Column(name="invoice_code")
    private String invoiceCode;

    @Column(name="buyer")
    private String buyer;

    @Column(name="release_date")
    @Temporal(TemporalType.DATE)
    private Date releaseDate;

    @Column(name="maker")
    private String maker;

    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "contract_id")
    private Contract contract;

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceSn='" + invoiceSn + '\'' +
                ", invoiceCode='" + invoiceCode + '\'' +
                ", buyer='" + buyer + '\'' +
                ", releaseDate=" + releaseDate +
                ", maker='" + maker + '\'' +
                ", contract=" + contract +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Invoice invoice = (Invoice) o;
        return Objects.equal(invoiceSn, invoice.invoiceSn) &&
                Objects.equal(invoiceCode, invoice.invoiceCode) &&
                Objects.equal(buyer, invoice.buyer) &&
                Objects.equal(releaseDate, invoice.releaseDate) &&
                Objects.equal(maker, invoice.maker) &&
                Objects.equal(contract, invoice.contract);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), invoiceSn, invoiceCode, buyer, releaseDate, maker, contract);
    }

    public String getInvoiceSn() {

        return invoiceSn;
    }

    public void setInvoiceSn(String invoiceSn) {
        this.invoiceSn = invoiceSn;
    }

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
