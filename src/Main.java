import Laba5Ads.HashTable;
import Laba5Ads.Item;

import java.util.Iterator;

public class Main {
    public static void main(String[] args){
       HashTable<Item> table = new HashTable<>(10);
       table.insert(new Item("popodos"));
       table.insert(new Item("popos"));
       table.insert(new Item("popos"));
       System.out.println(table.find(new Item("popo")));
       Iterator<Item> iterator= table.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
