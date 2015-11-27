package cc.aisc.platform.eny.commons.service;

import cc.aisc.platform.eny.commons.dao.ImageDao;
import cc.aisc.platform.eny.commons.entity.Image;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * Created by sjf on 15-11-18.
 */
@Service
@Transactional
public class ImageServiceImpl implements ImageService{
    private final static Logger LOGGER = LoggerFactory.getLogger(ImageServiceImpl.class);

    private final ImageDao imageDao;

    @Autowired
    public ImageServiceImpl(ImageDao imageDao) {
        this.imageDao = imageDao;
    }

    @Override
    public Image add(Image image) {
        return imageDao.save(image);
    }

    @Override
    public void delete(Image image) {
        imageDao.delete(image);
    }

    @Override
    public Optional<Image> findById(Long id) {
        return Optional.ofNullable(imageDao.findOne(id));
    }
}
