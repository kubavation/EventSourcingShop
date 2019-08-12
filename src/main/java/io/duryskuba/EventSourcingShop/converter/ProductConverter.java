package io.duryskuba.EventSourcingShop.converter;

import io.duryskuba.EventSourcingShop.model.Product;
import io.duryskuba.EventSourcingShop.resource.ProductDTO;
import org.springframework.stereotype.Component;

public class ProductConverter {

    public static Product toEntity(ProductDTO dto) {
        return Product.builder()
                .name(dto.getName())
                .price(dto.getPrice())
                .quantity(dto.getQuantity())
                .description(dto.getDescription())
                .code(dto.getCode())
                .groupCode(dto.getGroupCode())
                .build();
    }

    public static ProductDTO toDTO(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .code(product.getCode())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build();
    }
}
