package com.GadgetGrove.GadgetGrove.cart;

import java.util.UUID;
import lombok.Data;

@Data
public class CartItemrequest {
    private UUID productId;
    private Integer quantity;
}
