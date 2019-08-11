package io.duryskuba.EventSourcingShop.repository;

import io.duryskuba.EventSourcingShop.model.CartProduct;
import io.duryskuba.EventSourcingShop.model.CartProductId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartProductRepository extends JpaRepository<CartProduct, CartProductId> {
}
