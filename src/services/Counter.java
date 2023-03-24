package services;

import storage.CountStorage;

public class Counter implements CounterInterface {
    private final CountStorage countStorage;
    private int count;

    public Counter(CountStorage countStorage) {
        this.countStorage = countStorage;
        count = countStorage.load();
    }

    @Override
    public void increment() {
        count++;
        countStorage.save(count);
    }

    @Override
    public void reset() {
        count = 0;
        countStorage.save(count);
    }

    public int getCount() {
        return count;
    }
}
