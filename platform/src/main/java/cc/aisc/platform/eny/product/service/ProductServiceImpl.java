package cc.aisc.platform.eny.product.service;

import cc.aisc.platform.eny.product.dao.ProductDao;
import cc.aisc.platform.eny.product.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * Created by sjf on 15-11-11.
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {


    private final ProductDao productDao;

    @Autowired
    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public Product add(Product product) {
        return productDao.save(product);
    }

    @Override
    public void delete(Product product) {
        productDao.delete(product);
    }

    @Override
    public Product update(Product product) {
        return productDao.save(product);
    }

    @Override
    public Optional<Page<Product>> findAll(int page, int size) {
        return Optional.ofNullable(productDao.findAll(new PageRequest(page - 1, size)));
    }

    @Override
    public Optional<Product> findByProductSn(String productSn) {
        return Optional.ofNullable(productDao.findByProductSn(productSn));
    }

    @Override
    public Optional<Page<Product>> findByName(String name, int page ,int size) {
        return Optional.ofNullable(productDao.findByProductName(name, new PageRequest(page - 1, size)));
    }
}
