package dev.cb.store.presentation;

import dev.cb.store.business.model.Sale;
import dev.cb.store.business.model.Status;
import dev.cb.store.business.service.SaleService;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Optional;

public class SaleMenu extends Menu {

    private SaleService saleService;

    public SaleMenu(SaleService saleService) {
        super();
        this.saleService = saleService;
        this.actions = new HashMap<>();
        actions.put(1, this::create);
        actions.put(2, this::read);
        actions.put(3, this::readAll);
        actions.put(4, this::update);
        actions.put(5, this::delete);
        actions.put(6, () -> this.changeActualMenu(0));
        actions.put(0, () -> Ihm.hasQuit = true);
        this.entityName = "Sale";
        this.menuText = """
                \n=== Manage sales ===
                                
                1. Add a sale
                2. Display a sale (by id)
                3. Display all sales
                4. Update a sale
                5. Delete a sale
                6. Return to main menu
                0. Exit
                """;
    }

    private void delete() {
        Optional<Sale> optionalSale = saleService.getById(this.inputSaleId());
        optionalSale.ifPresentOrElse(
                sale -> this.saleService.delete(sale),
                () -> System.out.println(this.entityName + " not found")
        );
    }

    private void update() {
        Optional<Sale> optionalSale = saleService.getById(this.inputSaleId());
        optionalSale.ifPresentOrElse(
                sale -> this.saleService.update(this.inputUpdatedSale(sale)),
                () -> System.out.println(this.entityName + " not found")
        );
    }

    private void readAll() {
        this.saleService.getAll().forEach(System.out::println);
    }

    private void read() {
        Optional<Sale> optionalSale = this.saleService.getById(this.inputSaleId());
        optionalSale.ifPresentOrElse(
                System.out::println,
                () -> System.out.println(this.entityName + " not found")
        );
    }

    private void create() {
        this.saleService.save(this.inputNewSale());
    }

    private Long inputSaleId() {
        return Long.valueOf(Ihm.readInput(this.entityName.toLowerCase(), "id"));
    }

    private Sale inputNewSale() {
        Sale sale = new Sale();
        sale.setDate(LocalDateTime.parse(Ihm.readInput(this.entityName.toLowerCase(), "date")));
        String statusCase = Ihm.readInput(this.entityName.toLowerCase(), """
                status
                1. ongoing
                2. finalized
                3. canceled
                """);
        sale.setStatus(
                switch (statusCase) {
                    default -> Status.ONGOING;
                    case "2" -> Status.FINALIZED;
                    case "3" -> Status.CANCELED;
                }
        );
        return sale;
    }

    private Sale inputUpdatedSale(Sale sale) {
        System.out.println("= Current sale =");
        System.out.println("\nCurrent date: " + sale.getDate());
        sale.setDate(LocalDateTime.parse(Ihm.readInput(this.entityName.toLowerCase(), "date")));
        System.out.println("\nCurrent status: " + sale.getStatus());
        String statusCase = Ihm.readInput(this.entityName.toLowerCase(), """
                status
                1. ongoing
                2. finalized
                3. canceled
                """);
        sale.setStatus(
                switch (statusCase) {
                    default -> Status.ONGOING;
                    case "2" -> Status.FINALIZED;
                    case "3" -> Status.CANCELED;
                }
        );
        return sale;
    }
}