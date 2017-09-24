package dvoraka.pricechecker;

import java.util.List;
import java.util.Optional;

public class TestingSeller implements Seller {

    @Override
    public Optional<Item> findById(String id) {
        return null;
    }

    @Override
    public List<Item> findByName(String name) {
        return null;
    }
}
