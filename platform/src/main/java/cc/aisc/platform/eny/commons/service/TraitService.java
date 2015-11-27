package cc.aisc.platform.eny.commons.service;

import cc.aisc.platform.eny.commons.entity.Trait;

import java.util.Optional;

/**
 * Created by sjf on 15-11-18.
 */
public interface TraitService {
    Trait add(Trait trait);
    void delete(Trait trait);
    Optional<Trait> findById(Long id);
}
