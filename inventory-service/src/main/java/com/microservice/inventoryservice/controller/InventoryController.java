package com.microservice.inventoryservice.controller;

import com.microservice.inventoryservice.dto.InventoryResponse;
import com.microservice.inventoryservice.model.Inventory;
import com.microservice.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventories")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createInventory(){
        return "Inventory Successfully";
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCodes){
        return inventoryService.isInStock(skuCodes);
    }
}
