package cc.aisc.platform.eny.company.service;

import cc.aisc.platform.eny.company.entity.Agricola;
import org.springframework.data.domain.Page;

import java.util.Optional;

/**
 * Created by sjf on 15-11-11.
 */
public interface AgricolaService {
    Agricola add(Agricola agricola);
    void delete(Agricola agricola);
    void delete(Long id);
    Agricola update(Agricola revised);
    Optional<Page<Agricola>> findAll(int page, int size);
    Optional<Agricola> getById(Long id);
    Optional<Agricola> getBySn(String sn);
    Optional<Page<Agricola>> findByName(String name, int page, int size);
}
