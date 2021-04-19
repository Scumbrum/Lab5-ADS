package Laba5Ads;

import java.util.Iterator;
import java.util.LinkedList;

public class HashTable<T> implements Iterable<T>{

    private LinkedList<T>[] table;

    private int count;

    private int size;

    private int hash(T item){
        return item.hashCode();
    }

    private void resize(int size){
        LinkedList<T>[] newTable =  new LinkedList[size];
        for(int i=0;i<table.length;i++){
            newTable[i]=table[i];
        }
        table=newTable;
        this.size=size;
    }

    public HashTable(int size) {
        this.size = size;
        table =  new LinkedList[size];
    }

    public void insert(T item){
        int hash = hash(item);
        if(hash>=size){
            resize(hash+1);
        }
        if(table[hash]==null){
            table[hash] = new LinkedList<>();
        }
        table[hash].add(item);
        count++;
        if(count/size>0.7){
            resize(size*2);
        }
    }

    public boolean find(T item){
        int index = hash(item);
        if(table[index]==null){
            return false;
        }
        for(T i:table[index]){
            if(i.equals(item)){
                return true;
            }
        }
        return false;
    }

    public boolean delete(T item){
        int index = hash(item);
        boolean isDelete = table[index].remove(item);
        return isDelete;
    }

    private class HashIterator implements Iterator<T>{
        private int curr;
        private int localCurr;
        public HashIterator(){
            curr=0;
            localCurr=0;
        }
        @Override
        public boolean hasNext() {
            while(curr<table.length){
                if(table[curr]!=null){
                    if(localCurr==table[curr].size()) {
                        curr++;
                        localCurr=0;
                    }else {
                        localCurr++;
                        return true;
                    }
                }
                curr++;
            }
            return false;
        }

        @Override
        public T next() {
            return table[curr].get(localCurr-1);
        }
    }
    @Override
    public Iterator<T> iterator() {
        return new HashIterator();
    }
}
