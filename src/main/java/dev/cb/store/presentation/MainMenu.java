package dev.cb.store.presentation;

import java.util.HashMap;

public class MainMenu extends Menu {

    public MainMenu() {
        super();
        this.actions = new HashMap<>();
        actions.put(1, () -> this.changeActualMenu(1));
        actions.put(2, () -> this.changeActualMenu(2));
        actions.put(3, () -> this.changeActualMenu(3));
        actions.put(0, () -> Ihm.hasQuit = true);
        this.menuText = """
                \n=== Main Menu ===
                                
                1. Manage clients
                2. Manage sales
                3. Manage items
                0. Exit""";
    }
}
