package cc.aisc.platform.eny.customer.entity.comment;

import cc.aisc.platform.commons.base.BaseEntity;
import cc.aisc.platform.eny.business.entity.Deal;
import com.google.common.base.Objects;

import javax.persistence.*;

/**
 * Created by sjf on 15-11-23.
 */
@Entity
@Table(name = "t_cust_evaluation")
public class Evaluation extends BaseEntity<Long> {

    @Column(name = "score")
    private Short score;

    @Column(name = "eval")
    private String eval;

    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "deal_id")
    private Deal deal;

    @Override
    public String toString() {
        return "Evaluation{" +
                "score=" + score +
                ", eval='" + eval + '\'' +
                ", deal=" + deal +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Evaluation that = (Evaluation) o;
        return Objects.equal(score, that.score) &&
                Objects.equal(eval, that.eval) &&
                Objects.equal(deal, that.deal);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), score, eval, deal);
    }

    public Short getScore() {

        return score;
    }

    public void setScore(Short score) {
        this.score = score;
    }

    public String getEval() {
        return eval;
    }

    public void setEval(String eval) {
        this.eval = eval;
    }

    public Deal getDeal() {

        return deal;
    }

    public void setDeal(Deal deal) {
        this.deal = deal;
    }
}
