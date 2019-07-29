package io.duryskuba.EventSourcingShop.repository;

import io.duryskuba.EventSourcingShop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
}
