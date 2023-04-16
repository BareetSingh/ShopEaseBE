package com.shopease.app.services.mappers;

import com.shopease.app.domain.entities.Product;
import com.shopease.app.domain.values.ProductInfo;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(target = "guid", ignore = true)
    Product toProduct(ProductInfo productInfo);

    @Mapping(target = "guid", ignore = true)
    @InheritInverseConfiguration
    void toExistingProduct(ProductInfo productInfo, @MappingTarget Product product);

    ProductInfo toProductInfo(Product product);
}
