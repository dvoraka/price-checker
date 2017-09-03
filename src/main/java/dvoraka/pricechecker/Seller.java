package dvoraka.pricechecker;

import java.util.List;
import java.util.Optional;

/**
 * Interface for sellers.
 */
public interface Seller {

    Optional<Item> findById(String id);

    List<Item> findByName(String name);
}
