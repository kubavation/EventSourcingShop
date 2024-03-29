package io.duryskuba.EventSourcingShop.service.product;

import io.duryskuba.EventSourcingShop.command.product.CreateProductCommand;
import io.duryskuba.EventSourcingShop.converter.ProductConverter;
import io.duryskuba.EventSourcingShop.repository.ProductRepository;
import io.duryskuba.EventSourcingShop.resource.ProductDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import static io.duryskuba.EventSourcingShop.converter.ProductConverter.toEntity;

@Service
public class ProductCommandService {

    private final CommandGateway commandGateway;
    private final ProductRepository productRepository;

    public ProductCommandService(CommandGateway commandGateway, ProductRepository productRepository) {
        this.commandGateway = commandGateway;
        this.productRepository = productRepository;
    }

    public CompletableFuture<String> createProductv2(ProductDTO productDTO) {
        return commandGateway.send (
                CreateProductCommand.builder()
                    .id(UUID.randomUUID().toString())
                    .name(productDTO.getName())
                    .code(productDTO.getCode())
                    .description(productDTO.getDescription())
                    .groupCode(productDTO.getGroupCode()).build() );
    }

    public void createProduct(ProductDTO productDTO) {
        productRepository.save( toEntity(productDTO) );
    }

}
