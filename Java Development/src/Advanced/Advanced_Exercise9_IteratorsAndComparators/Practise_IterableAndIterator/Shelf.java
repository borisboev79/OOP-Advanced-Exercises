package Advanced.Advanced_Exercise9_IteratorsAndComparators.Practise_IterableAndIterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Shelf implements Iterable<String> {
    private List<String> fruits;

    public Shelf(String... fruits) {
        this.fruits = Arrays.asList(fruits);
    }

    @Override
    public Iterator<String> iterator() {
        return new ShopGirl();
    }

    // Това е по-лесният начин, директно да върнем нов итератор, но е по-добре да си го направим в нов клас, затова това го закоментираме

//        return new Iterator<String>() {
//
//            int index = 0;
//
//
//            @Override
//            public boolean hasNext() {
//                //Има ли още плодове?
//                return index < fruits.size();
//            }
//
//            @Override
//            public String next() {
//                //Дай ми щом има
//                String fruit = fruits.get(index++);
//
//                return fruit;
//            }
//        };

    class ShopGirl implements Iterator<String> {
        int index = 0;

        @Override
        public boolean hasNext() {
            return index < fruits.size();
        }

        @Override
        public String next() {
            String fruit = fruits.get(index++);
            return fruit;
        }
    }


}
