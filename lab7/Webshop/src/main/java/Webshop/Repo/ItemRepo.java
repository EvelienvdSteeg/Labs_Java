package Webshop.Repo;

import Webshop.Domain.Item;

import java.math.BigDecimal;
import java.util.List;

public class ItemRepo {


    private Item item1 = new Item("it1", new BigDecimal(1.25), "Pen");
    private Item item2 = new Item("it2", new BigDecimal(10.50), "Boek");

    private List<Item> itemLijst = List.of(item1, item2);

    public void addItems(Item item){
        this.itemLijst.add(item);
    }

    public Item zoekItemOpBeschrijving(String beschrijving){
        return this.itemLijst.stream().filter(i -> i.getBeschrijving().equals(beschrijving)).findFirst().orElse(null);
    }


}
