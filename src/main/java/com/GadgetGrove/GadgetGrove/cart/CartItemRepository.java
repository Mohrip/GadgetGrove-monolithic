package com.GadgetGrove.GadgetGrove.cart;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CartItemRepository extends JpaRepository<CartItem, UUID> {

    Optional<CartItem> findUserIdAndProductId(UUID userId, UUID productId);

}
