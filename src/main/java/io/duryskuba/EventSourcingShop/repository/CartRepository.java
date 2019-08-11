package io.duryskuba.EventSourcingShop.repository;

import io.duryskuba.EventSourcingShop.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<ShoppingCart, String> {
}
