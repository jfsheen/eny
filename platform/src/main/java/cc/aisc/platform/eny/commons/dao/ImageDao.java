package cc.aisc.platform.eny.commons.dao;

import cc.aisc.platform.commons.base.BaseDao;
import cc.aisc.platform.eny.commons.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sjf on 15-11-18.
 */
public interface ImageDao extends JpaRepository<Image, Long> {
}
