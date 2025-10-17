package br.com.carstore.service;

import br.com.carstore.dao.CarDao;
import br.com.carstore.model.CarDTO;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CarServiceImpl implements CarService {

    private final CarDao carDao;

    public CarServiceImpl(CarDao carDao) {
        this.carDao = carDao;
    }

    @Override
    public List<CarDTO> findAll() {
        return carDao.findAll();
    }

    @Override
    public void save(CarDTO carDTO) {
        if (carDTO.getId() == null || carDTO.getId().isEmpty()) {
            carDTO.setId(UUID.randomUUID().toString());
        }
        carDao.save(carDTO);
    }

    @Override
    public void deleteById(String id) {
        carDao.deleteById(id);
    }

    @Override
    public void update(String id, CarDTO carDTO) {
        try {
            CarDTO existingCar = carDao.findById(id);  // Tenta buscar o carro
            if (existingCar != null) {
                carDTO.setId(id);
                carDao.update(id, carDTO);
            }
        } catch (EmptyResultDataAccessException e) {
            // Carro não encontrado - Salva como novo ou lida com o erro
            System.out.println("Carro com ID " + id + " não encontrado. Salvando como novo...");
            save(carDTO);  // Salva como novo carro
            // Alternativa: Para evitar salvar automaticamente, lance um erro: throw new RuntimeException("Carro não encontrado");
        }
    }
}
