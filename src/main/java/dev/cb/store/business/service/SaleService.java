package dev.cb.store.business.service;

import dev.cb.store.business.model.Sale;
import dev.cb.store.business.model.Status;
import dev.cb.store.persistence.SaleRepository;

import java.util.List;
import java.util.Optional;

public class SaleService {

    private SaleRepository saleRepository;

    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    // specific CRUD
    public Optional<Status> getStatusById(Long id) {
        return saleRepository.findStatusById(id);
    }

    // basic CRUD
    public void save(Sale sale) {
        saleRepository.save(sale);
    }

    public Optional<Sale> getById(Long id) {
        return saleRepository.findById(id);
    }

    public List<Sale> getAll() {
        return saleRepository.findAll();
    }

    public void update(Sale sale) {
        Optional<Sale> optionalSale = saleRepository.findById(sale.getId());
        optionalSale.ifPresent(fetchedSale -> {
            fetchedSale.update(sale);
            saleRepository.update(fetchedSale);
        });
    }

    public void delete(Sale sale) {
        saleRepository.delete(sale);
    }
}
