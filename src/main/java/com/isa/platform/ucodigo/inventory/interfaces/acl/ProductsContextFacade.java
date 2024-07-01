package com.isa.platform.ucodigo.inventory.interfaces.acl;

import com.isa.platform.ucodigo.inventory.domain.model.aggregates.Product;
import com.isa.platform.ucodigo.inventory.domain.model.queries.GetProductBySerialNumber;
import com.isa.platform.ucodigo.inventory.domain.services.ProductCommandService;
import com.isa.platform.ucodigo.inventory.domain.services.ProductQueryService;
import org.springframework.stereotype.Service;

@Service
public class ProductsContextFacade {
    private final ProductCommandService productCommandService;
    private final ProductQueryService productQueryService;

    public ProductsContextFacade(ProductCommandService productCommandService, ProductQueryService productQueryService) {
        this.productCommandService = productCommandService;
        this.productQueryService = productQueryService;
    }

    public Long fetchProductIdByProductSerialNumber(String serialNumber) {
        var query = new GetProductBySerialNumber(serialNumber);
        var product = productQueryService.handle(query);

        if(product.isEmpty()) return 0L;
        return product.get().getId();
    }


}
