package cc.aisc.platform.eny.product.service;

import cc.aisc.platform.eny.product.entity.Product;
import org.springframework.data.domain.Page;

import java.util.Optional;

/**
 * Created by sjf on 15-11-11.
 */
public interface ProductService {
    Product add(Product product);
    void delete(Product product);
    Product update(Product product);
    Optional<Page<Product>> findAll(int page,int size);
    Optional<Product> findByProductSn(String productSn);
    Optional<Page<Product>> findByName(String name, int page, int size);
}
