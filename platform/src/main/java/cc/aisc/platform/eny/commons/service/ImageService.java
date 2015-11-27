package cc.aisc.platform.eny.commons.service;

import cc.aisc.platform.eny.commons.entity.Image;

import java.util.Optional;

/**
 * Created by sjf on 15-11-18.
 */
public interface ImageService {
    Image add(Image image);
    void delete(Image image);
    Optional<Image> findById(Long id);
}
