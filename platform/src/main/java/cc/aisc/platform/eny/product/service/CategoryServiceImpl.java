package cc.aisc.platform.eny.product.service;

import cc.aisc.platform.eny.product.dao.CategoryDao;
import cc.aisc.platform.eny.product.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

/**
 * Created by sjf on 15-11-11.
 */
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    private static final String ENY_CACHE = "enyCache";

    @Override
    @CachePut(value = ENY_CACHE)
    public Category add(Category category) {
        return categoryDao.save(category);
    }

    @Override
    @CacheEvict(value = ENY_CACHE)
    public void delete(Category category) {
        categoryDao.delete(category);
    }

    @Override
    @CachePut(value = ENY_CACHE)
    public Category update(Category category) {
        return categoryDao.save(category);
    }

    @Override
    @Cacheable(value = ENY_CACHE)
    public Optional<Page<Category>> findAll(int page, int size) {
        return Optional.ofNullable(categoryDao.findAll(new PageRequest(page - 1, size)));
    }
    @Override
    @Cacheable(value = ENY_CACHE)
    public Optional<Collection<Category>> findAll() {
        return Optional.ofNullable(categoryDao.findAll());
    }

    @Override
    @Cacheable(value = ENY_CACHE)
    public Optional<Collection<Category>> findByLevelLessThan(Integer lvlLt) {
        return Optional.ofNullable(categoryDao.findByLevelLessThan(lvlLt));
    }

    @Override
    @Cacheable(value = ENY_CACHE)
    public Optional<Category> findCategoryById(Long id) {
        return Optional.ofNullable(categoryDao.findOne(id));
    }

    @Override
    @Cacheable(value = ENY_CACHE)
    public Optional<Page<Category>> findCategoryByName(String name, int page, int size) {
        return Optional.ofNullable(categoryDao.findByName(name, new PageRequest(page - 1, size)));
    }

    @Override
    @Cacheable(value = ENY_CACHE)
    public Optional<Collection<Category>> findCategoryByName(String name) {
        return Optional.ofNullable(categoryDao.findByName(name));
    }

    @Override
    @Cacheable(value = ENY_CACHE)
    public Optional<Category> findByCategorySn(String categorySn) {
        return Optional.ofNullable(categoryDao.findOneByCategorySn(categorySn));
    }
}
