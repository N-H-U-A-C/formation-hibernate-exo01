package dev.cb.store.presentation;

import dev.cb.store.business.model.Sale;
import dev.cb.store.business.model.Status;
import dev.cb.store.business.service.SaleService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
        Optional<Sale> optionalSale = saleService.getById(this.inputId());
        optionalSale.ifPresentOrElse(
                sale -> this.saleService.delete(sale),
                () -> System.out.println(this.entityName + " not found")
        );
    }

    private void update() {
        Optional<Sale> optionalSale = saleService.getById(this.inputId());
        optionalSale.ifPresentOrElse(
                sale -> this.saleService.update(this.inputUpdatedSale(sale)),
                () -> System.out.println(this.entityName + " not found")
        );
    }

    private void readAll() {
        this.saleService.getAll().forEach(System.out::println);
    }

    private void read() {
        Optional<Sale> optionalSale = this.saleService.getById(this.inputId());
        optionalSale.ifPresentOrElse(
                System.out::println,
                () -> System.out.println(this.entityName + " not found")
        );
    }

    private void create() {
        this.saleService.save(this.inputNewSale());
    }

    private Sale inputNewSale() {
        Sale sale = new Sale();
        inputDate(sale);
        inputStatus(sale);
        while (Ihm.readInput("Do you want to add an item to the sale? (y/n)").equalsIgnoreCase("y")) {
            inputItem(sale);
        }
        return sale;
    }


    private Sale inputUpdatedSale(Sale sale) {
        System.out.println("= Current sale =");
        System.out.println("\nCurrent date: " + sale.getDate());
        inputDate(sale);
        System.out.println("\nCurrent status: " + sale.getStatus());
        inputStatus(sale);
        for (int i = 0; i < sale.getSaleLines().size(); i++) {
            System.out.println("\nCurrent item: " + sale.getSaleLines().get(i));
            inputItem(sale);
        }
        while (Ihm.readInput("Do you want to add an item to the sale? (y/n)").equalsIgnoreCase("y")) {
            inputItem(sale);
        }
        return sale;
    }

    private void inputDate(Sale sale) {
        LocalDate date = LocalDate.parse(Ihm.readInput(this.entityName.toLowerCase(), "date"));
        LocalTime time = LocalTime.parse(Ihm.readInput(this.entityName.toLowerCase(), "time"));
        LocalDateTime dateTime = LocalDateTime.of(date, time);
        sale.setDate(dateTime);
    }

    private void inputStatus(Sale sale) {
        String statusCase = Ihm.readInput(this.entityName.toLowerCase(), """
                status
                1. Ongoing
                2. Finalized
                3. Canceled
                """);
        sale.setStatus(
                switch (statusCase) {
                    case "2" -> Status.FINALIZED;
                    case "3" -> Status.CANCELED;
                    default -> Status.ONGOING;
                }
        );
    }

    private void inputItem(Sale sale) {
/*
        // TODO implement
         demander id item, quantité item
*/
    }
}
