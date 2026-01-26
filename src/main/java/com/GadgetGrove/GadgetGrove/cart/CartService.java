package com.GadgetGrove.GadgetGrove.cart;

import com.GadgetGrove.GadgetGrove.product.Product;
import com.GadgetGrove.GadgetGrove.product.ProductRepository;
import com.GadgetGrove.GadgetGrove.user.User;
import com.GadgetGrove.GadgetGrove.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CartService {

    @Autowired
    CartItemRepository cartItemRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    public void addToCart(UUID userId, CartItemrequest request) {
        Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        Optional<Product> productOpt = productRepository.findById(request.getProductId());
        if (productOpt.isEmpty()) {
            throw new RuntimeException("Product not found");
        }
        Product product = productOpt.get();
        if (request.getQuantity() == null || request.getQuantity() <= 0) {
            throw new RuntimeException("Quantity must be greater than zero");
        }
        if (request.getQuantity() > product.getStockQuantity()) {
            throw new RuntimeException("Insufficient stock available");
        }

        CartItem cartItem = new CartItem();
        cartItem.setUser(userOpt.get());
        cartItem.setProduct(product);
        cartItem.setQuantity(request.getQuantity());
        cartItem.setPrice(product.getPrice().multiply(
                java.math.BigDecimal.valueOf(request.getQuantity())
        ));

        cartItemRepository.save(cartItem);
    }
}
