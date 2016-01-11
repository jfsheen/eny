package cc.aisc.platform.eny.customer.entity.comment;

import cc.aisc.platform.commons.base.BaseEntity;
import cc.aisc.platform.eny.business.entity.Deal;
import cc.aisc.platform.eny.customer.entity.Customer;
import com.google.common.base.Objects;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sjf on 15-11-21.
 */
@Entity
@Table(name = "t_cstm_comment")
public class Comment extends BaseEntity<Long> {

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column
    private String content;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER,mappedBy = "comment")
    private Set<CommentImage> commentImageSet = new HashSet<>();

    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "deal_id")
    private Deal deal;


    @Override
    public String toString() {
        return "Comment{" +
                "customer=" + customer +
                ", content='" + content + '\'' +
                ", commentImageSet=" + commentImageSet +
                ", deal=" + deal +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Comment comment = (Comment) o;
        return Objects.equal(customer, comment.customer) &&
                Objects.equal(content, comment.content) &&
                Objects.equal(commentImageSet, comment.commentImageSet) &&
                Objects.equal(deal, comment.deal);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), customer, content, commentImageSet, deal);
    }

    public Deal getDeal() {

        return deal;
    }

    public void setDeal(Deal deal) {
        this.deal = deal;
    }

    public Customer getCustomer() {

        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Set<CommentImage> getCommentImageSet() {
        return commentImageSet;
    }

    public void setCommentImageSet(Set<CommentImage> commentImageSet) {
        this.commentImageSet = commentImageSet;
    }
}
