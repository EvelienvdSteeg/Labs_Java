package Webshop.Domain;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class Catalogus {

    private List<Item> lijstCatalogusItems = new ArrayList<>();



    private Year jaar;

    public Catalogus(List<Item> lijstCatalogusItems, Year jaar) {
        this.lijstCatalogusItems = lijstCatalogusItems;
        this.jaar = jaar;
    }

    public Year getJaar() {
        return jaar;
    }

    public void setJaar(Year jaar) {
        this.jaar = jaar;
    }

    @Override
    public String toString() {
        return "Catalogus: \n" + "jaar: " + jaar +
                "\n items: " + lijstCatalogusItems
                ;
    }
}
