package com.danilo.service.impl

import com.danilo.model.Product
import com.danilo.repository.ProductRepository
import com.danilo.service.ProductService
import javax.inject.Singleton

@Singleton
class ProductServiceImpl(private val productRepository: ProductRepository) : ProductService {

    override fun addProduct(product: Product): Product {
        return this.productRepository.saveCql(product)
    }

    override fun updateProduct(product: Product): Product {
        return this.productRepository.updateCql(product)
    }

    override fun deleteProduct(id: String) {
        this.productRepository.deleteCql(id)
    }

}