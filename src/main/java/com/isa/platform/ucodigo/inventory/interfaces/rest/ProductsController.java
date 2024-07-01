package com.isa.platform.ucodigo.inventory.interfaces.rest;

import com.isa.platform.ucodigo.inventory.domain.model.queries.GetProductById;
import com.isa.platform.ucodigo.inventory.domain.model.queries.GetProductBySerialNumber;
import com.isa.platform.ucodigo.inventory.domain.services.ProductCommandService;
import com.isa.platform.ucodigo.inventory.domain.services.ProductQueryService;
import com.isa.platform.ucodigo.inventory.interfaces.rest.resources.CreateProductResource;
import com.isa.platform.ucodigo.inventory.interfaces.rest.resources.ProductResource;
import com.isa.platform.ucodigo.inventory.interfaces.rest.transform.CreateProductCommandFromResourceAssembler;
import com.isa.platform.ucodigo.inventory.interfaces.rest.transform.ProductResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "api/v1/products", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Products")
public class ProductsController {
    private final ProductQueryService productQueryService;
    private final ProductCommandService productCommandService;

    public ProductsController(ProductQueryService productQueryService, ProductCommandService productCommandService) {
        this.productQueryService = productQueryService;
        this.productCommandService = productCommandService;
    }

    @PostMapping
    public ResponseEntity<?> createProduct(CreateProductResource resource){
        if(resource == null) return ResponseEntity.badRequest().body("El recurso proporcionado es nulo");

        var serialNumberQuery = new GetProductBySerialNumber(resource.serialNumber());
        if (productQueryService.handle(serialNumberQuery).isPresent())
            return ResponseEntity.badRequest().body("Ya existe un producto con este número de serie");

        var createProductCommand = CreateProductCommandFromResourceAssembler.fromResource(resource);
        var product = productCommandService.handle(createProductCommand);
        if (product.isEmpty()) return ResponseEntity.badRequest().body("No se pudo crear el producto");

        var productResource = ProductResourceFromEntityAssembler.fromEntity(product.get());
        return ResponseEntity.ok(productResource);
    }

    @GetMapping
    public ResponseEntity<ProductResource> getProductById(Long productId){
        var query = new GetProductById(productId);
        var product = productQueryService.handle(query);
        if (product.isEmpty()) return ResponseEntity.notFound().build();
        var productResource = ProductResourceFromEntityAssembler.fromEntity(product.get());
        return ResponseEntity.ok(productResource);
    }


}
