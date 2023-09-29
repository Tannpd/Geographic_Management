package Controller;

import Common.Library;
import Model.Country;
import View.Menu;
import java.util.ArrayList;
import java.util.Collections;

public class ManageEastAsiaCountries extends Menu {

    ArrayList<Country> lc = new ArrayList<>();
    Library l;

    public ManageEastAsiaCountries(String td, String[] mc, String exit) {
        super(td, mc, exit);
        l = new Library();
        lc = new ArrayList<>();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                inputCountry(lc);
                break;
            case 2:
                printCountry(lc);
                break;
            case 3:
                searchByName(lc);
                break;
            case 4:
                printCountrySorted(lc);
                break;
        }
    }

    //allow user input infomation of contries
    public void inputCountry(ArrayList<Country> lc) {
        System.out.print("Enter code of contry: ");
        String countryCode = l.checkInputString();
        //check code contry exist or not
        if (!l.checkCountryExist(lc, countryCode)) {
            System.err.println("Country exist.");
            return;
        }
        System.out.print("Enter name of contry: ");
        String countryName = l.checkInputString();
        System.out.print("Enter total area: ");
        double countryArea = l.checkInputDouble();
        System.out.print("Enter terrain of contry: ");
        String countryTerrain = l.checkInputString();
        lc.add(new Country(countryTerrain, countryCode, countryName, countryArea));
        System.err.println("Add successful.");
    }

    //display infomation of country
    public void printCountry(ArrayList<Country> lc) {
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area",
                "Terrain");
        for (Country country : lc) {
            country.display();
        }
    }

    //display infomation sort name in ascending
    public void printCountrySorted(ArrayList<Country> lc) {
        Collections.sort(lc);
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area",
                "Terrain");
        for (Country country : lc) {
            country.display();
        }
    }

    //allow user search infomation contry by name
    public void searchByName(ArrayList<Country> lc) {
        System.out.print("Enter the name you want to search for: ");
        String countryName = l.checkInputString();
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area",
                "Terrain");
        for (Country country : lc) {
            if (country.getCountryName().equalsIgnoreCase(countryName)) {
                country.display();
            }
        }
    }

}
