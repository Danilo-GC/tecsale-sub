package com.danilo.service.impl

import com.danilo.model.Product
import com.danilo.repository.ProductRepository
import com.danilo.service.ProductService
import java.util.UUID
import javax.inject.Singleton

@Singleton
class ProductServiceImpl(private val productRepository: ProductRepository) : ProductService {

    override fun addProduct(product: Product): Product {
        return this.productRepository.saveCql(product)
    }

    override fun updateProduct(id: UUID, product: Product): Product {
        if(!this.productRepository.equals(id)){
            throw RuntimeException("Product not found!")
            }
        return this.productRepository.updateCql(id,product)
    }

    override fun deleteProduct(id: UUID) {
        this.productRepository.deleteCql(id)
    }


}