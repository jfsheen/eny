package cc.aisc.platform.eny.customer.entity.comment;

import cc.aisc.platform.commons.base.BaseEntity;
import cc.aisc.platform.commons.base.BaseImageEntity;
import com.google.common.base.Objects;

import javax.persistence.*;

/**
 * Created by sjf on 15-11-23.
 */
@Entity
@Table(name = "t_cust_cmt_image")
public class CommentImage extends BaseImageEntity<Long> {

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "comment_id")
    private Comment comment;

    @Override
    public String toString() {
        return "CommentImage{" +
                "comment=" + comment +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CommentImage commentImage = (CommentImage) o;
        return Objects.equal(comment, commentImage.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), comment);
    }

    public Comment getComment() {

        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
}
