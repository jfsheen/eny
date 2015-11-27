package cc.aisc.platform.eny.product.service;

import cc.aisc.platform.commons.base.BaseService;
import cc.aisc.platform.eny.product.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by sjf on 15-11-11.
 */
public interface CategoryService/* extends BaseService<Category, Long>*/{
    Category add(Category category);
    void delete(Category category);
    Category update(Category category);
    Optional<Page<Category>> findAll(int page,int size);
    Optional<Category> findCategoryById(Long id);
    Optional<Page<Category>> findCategoryByName(String name, int page, int size);
    Optional<Collection<Category>> findCategoryByName(String name);
    Optional<Category> findByCategorySn(String categorySn);
    Optional<Collection<Category>> findAll();
    Optional<Collection<Category>> findByLevelLessThan(Integer lvlLt);
}
