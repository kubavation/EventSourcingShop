package io.duryskuba.EventSourcingShop.service.cart;

import io.duryskuba.EventSourcingShop.exception.ResourceNotFoundException;
import io.duryskuba.EventSourcingShop.model.ShoppingCart;
import io.duryskuba.EventSourcingShop.repository.CartRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.messaging.Message;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartQueryService {

    private final CartRepository cartRepository;

    @Autowired
    private EventStore eventStore;

    public CartQueryService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @QueryHandler(queryName = "findAllCarts")
    public Collection<ShoppingCart> findAllCarts() {
        return cartRepository.findAll();
    }

    public Optional<ShoppingCart> findCartById(String id) {
        return cartRepository.findById(id);
    }

    public ShoppingCart findCartByIdOrThrow(String id) {
        return cartRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException(ShoppingCart.class, id));
    }


    public List<Object> eventsOfCart(String id) {
        return eventStore.readEvents(id)
                .asStream()
                .map(Message::getPayload)
                .collect(Collectors.toList());
    }
}
