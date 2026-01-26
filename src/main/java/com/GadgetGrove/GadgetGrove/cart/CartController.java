package com.GadgetGrove.GadgetGrove.cart;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping
    public ResponseEntity<Void> addToCart(@RequestHeader("User-ID") UUID userId, @RequestBody CartItemrequest request) {
        cartService.addToCart(userId, request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
