package Laba5Ads;

public class Item {
    private String value;

    public String getValue() {
        return value;
    }

    public Item(String value){
        this.value=value;
    }
    @Override
    public int hashCode(){
        int hash=0;
        for(int i=0;i<value.length();i++){
            hash=31*i+value.charAt(i);
        }
        return hash;
    }
    @Override
    public String toString(){
        return value;
    }
    @Override
    public boolean equals(Object o2){
        if(o2.getClass()!=this.getClass()){
            return false;
        }
        if(this==o2){
            return true;
        }
        Item i2 = (Item) o2;
        return this.getValue().equals(i2.getValue());
    }
}
