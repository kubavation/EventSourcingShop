package io.duryskuba.EventSourcingShop.service.product;

import io.duryskuba.EventSourcingShop.command.account.AccountCreationCommand;
import io.duryskuba.EventSourcingShop.command.product.CreateProductCommand;
import io.duryskuba.EventSourcingShop.resource.AccountDTO;
import io.duryskuba.EventSourcingShop.resource.ProductDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class ProductCommandService {

    private final CommandGateway commandGateway;

    public ProductCommandService(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }


    public CompletableFuture<String> createProduct(ProductDTO productDTO) {
        return commandGateway.send (
                CreateProductCommand.builder()
                    .id(UUID.randomUUID().toString())
                    .name(productDTO.getName())
                    .code(productDTO.getCode())
                    .description(productDTO.getDescription())
                    .groupCode(productDTO.getGroupCode()).build() );
    }

}
