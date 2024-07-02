package dev.cb.store.presentation;

import java.util.Map;

public abstract class Menu {

    protected Map<Integer, Runnable> actions;
    protected String entityName;
    protected String menuText;
    protected String inputText;
    protected String inText;
    protected String outText;

    public Menu() {
        this.inputText = "\nPlease enter\s";
    }

    public Map<Integer, Runnable> getActions() {
        return actions;
    }

    protected void changeActualMenu(int key) {
        Ihm.actualMenu = Ihm.menus.get(key);
    }

    protected void displayMenu() {
        System.out.println(menuText);
    }

    protected void displayInputText(String inputLabel) {
        System.out.print(this.inputText + inputLabel + ":\s");
    }

    protected void displayInputText(String fieldClass, String fieldLabel) {
        System.out.print(this.inputText + fieldClass + " " + fieldLabel + ":\s");
    }
}
