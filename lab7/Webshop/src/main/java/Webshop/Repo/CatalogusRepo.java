package Webshop.Repo;

import Webshop.Domain.Catalogus;
import Webshop.Domain.Item;

import java.math.BigDecimal;
import java.time.Year;
import java.util.List;

public class CatalogusRepo {
    //List<Catalogus> catalogusLijst = new ArrayList<>();
//
    private Item item1 = new Item("it1", new BigDecimal(1.25), "Pen");
    private Item item2 = new Item("it2", new BigDecimal(10.50), "Boek");

    private List<Item> lijst2024 = List.of(item1, item2);

    private List<Item> lijst2023 = List.of(item1);

    private Catalogus catalogus2024 = new Catalogus(lijst2024, Year.of(2024));

    private Catalogus catalogus2023 = new Catalogus(lijst2023, Year.of(2023));


    private List<Catalogus> catalogusLijst = List.of(catalogus2023, catalogus2024);



    public void addNewCatalogus(Catalogus catalogus){
        this.catalogusLijst.add(catalogus);
    }

    public List<Catalogus> vindCatalogus(Year jaar){
        return this.catalogusLijst.stream().filter(c -> c.getJaar().equals(jaar)).toList();
    }


}
