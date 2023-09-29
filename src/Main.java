
import Controller.ManageEastAsiaCountries;
public class Main {
    public static void main(String[] args) {
        String mChon[] = {"Input the information of 11 countries in East Asia", "Display the information of country you've just input",
        "Search the information of country by user-entered name","Display the information of countries sorted name in ascending order"};
        ManageEastAsiaCountries manageEastAsiaCountries = new ManageEastAsiaCountries("Main Menu", mChon, "exit");
        manageEastAsiaCountries.run();
    }
}
