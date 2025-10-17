package br.com.carstore.dao;

import br.com.carstore.entity.CarEntity;
import br.com.carstore.model.CarDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@Transactional
public class CarJpaDao {

    @PersistenceContext
    private EntityManager em;

    public List<CarDTO> findAll() {
        List<CarEntity> list = em.createQuery("SELECT c FROM CarEntity c", CarEntity.class).getResultList();
        return list.stream().map(this::toDto).collect(Collectors.toList());
    }

    public void save(CarDTO dto) {
        CarEntity e = new CarEntity();
        e.setName(dto.getName());
        e.setColor(dto.getColor());

        em.persist(e);

        dto.setId(e.getId());
    }

    public void deleteById(String id) {
        CarEntity e = em.find(CarEntity.class, id);
        if (e != null) {
            em.remove(e);
        }
    }

    public void update(String id, CarDTO dto) {
        CarEntity e = em.find(CarEntity.class, id);
        if (e != null) {
            e.setName(dto.getName());
            e.setColor(dto.getColor());
            em.merge(e);
        }
    }

    private CarDTO toDto(CarEntity e) {
        CarDTO d = new CarDTO();
        d.setId(e.getId());
        d.setName(e.getName());
        d.setColor(e.getColor());
        return d;
    }
}
