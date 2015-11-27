package cc.aisc.platform.eny.product.dao;

import cc.aisc.platform.commons.base.BaseDao;
import cc.aisc.platform.eny.product.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by sjf on 15-11-11.
 */
public interface ProductDao extends JpaRepository<Product, Long> {
    Product findByProductSn(String productSn);
    Page<Product> findByProductName(String name, Pageable pageable);

}
