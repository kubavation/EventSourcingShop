package io.duryskuba.EventSourcingShop.service.cart;

import io.duryskuba.EventSourcingShop.command.account.CreateAccountCommand;
import io.duryskuba.EventSourcingShop.command.cart.AddProductCommand;
import io.duryskuba.EventSourcingShop.model.CartProduct;
import io.duryskuba.EventSourcingShop.resource.AccountDTO;
import io.duryskuba.EventSourcingShop.resource.CartProductDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class CartCommandService {

    private final CommandGateway commandGateway;

    public CartCommandService(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    public CompletableFuture<String> addProduct(CartProductDTO dto) {
        return commandGateway.send(
                new AddProductCommand(dto.getCartId(), dto.getProductId(), dto.getQuantity()));
    }
}
