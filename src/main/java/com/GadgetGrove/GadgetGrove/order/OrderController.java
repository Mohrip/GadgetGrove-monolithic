package com.GadgetGrove.GadgetGrove.order;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {



    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponse> placeOrder(
            @RequestHeader("User-ID") UUID userId,
            @RequestBody OrderRequest request) {
        return new ResponseEntity<>(orderService.placeOrder(userId, request), HttpStatus.CREATED);
    }
}
