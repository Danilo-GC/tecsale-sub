package com.danilo.broker

import com.danilo.model.Product
import com.danilo.service.ProductService
import io.micronaut.nats.annotation.NatsListener
import io.micronaut.nats.annotation.Subject

@NatsListener
class ProductListener(private val productService: ProductService) {

    @Subject("store.product")
    fun receiveSave(product: Product) {
        productService.addProduct(product)

    }

    @Subject("store.product.update")
    fun receiveUpdate(product: Product) {
        productService.updateProduct(product)

    }

    @Subject("store.product.delete")
    fun receiveDelete(id: String) {
        productService.deleteProduct(id)
    }
}

