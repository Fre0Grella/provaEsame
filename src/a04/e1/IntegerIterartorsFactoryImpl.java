package a04.e1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.random.RandomGenerator;

public class IntegerIterartorsFactoryImpl implements IntegerIteratorsFactory {

    @Override
    public SimpleIterator<Integer> empty() {
        return new SimpleIterator<Integer>() {

            @Override
            public Optional<Integer> next() {
                return Optional.empty();
            }
            
        };
    }

    @Override
    public SimpleIterator<Integer> fromList(List<Integer> list) {
        return new SimpleIterator<Integer>() {
            private int i = -1;
            @Override
            public Optional<Integer> next() {
                i++;
                return i < list.size() ? Optional.of(list.get(i)) : Optional.empty();
            }
            
        };
    }

    @Override
    public SimpleIterator<Integer> random(int size) {
        return new SimpleIterator<Integer>() {
            private int i = 0;
            @Override
            public Optional<Integer> next() {
                i++;
                return i <= size ? Optional.of(RandomGenerator.getDefault().nextInt(size)) : Optional.empty();
            }
            
        };
    }

    @Override
    public SimpleIterator<Integer> quadratic() {
        return new SimpleIterator<Integer>() {
            private int i = 1;
            private int k = 1;
            @Override
            public Optional<Integer> next() {
                if (k == 0) {
                    i++;
                    k = i;
                }
                k--;
                return Optional.of(i);
            }
            
        };
    }

    @Override
    public SimpleIterator<Integer> recurring() {
        
        //0,0,1,0,1,2,0,1,2,3,0,1,2,3,4
        return new SimpleIterator<Integer>() {
            private List<Integer> list = List.of(0,0,1,0,1,2,0,1,2,3,0,1,2,3,4);
            private int i = 1;
            @Override
            public Optional<Integer> next() {
                i++;
                if (i == list.size()) {
                    i=0;
                }
                return Optional.of(list.get(i));
            }
            
        };
    }
    
}
