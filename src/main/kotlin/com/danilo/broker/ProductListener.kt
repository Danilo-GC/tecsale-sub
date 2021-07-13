package com.danilo.broker

import com.danilo.model.Product
import com.danilo.service.ProductService
import io.micronaut.nats.annotation.NatsListener
import io.micronaut.nats.annotation.Subject
import java.util.UUID

@NatsListener
class ProductListener(private val productService: ProductService) {

    @Subject("store.product")
    fun receiveSave(product: Product) {
        productService.addProduct(product)

    }
    @Subject("store.product")
    fun receiveUpdate(product: Product){
        val productId = product.id
        productService.updateProduct(UUID.randomUUID(),product)

    }
    @Subject("store.product")
    fun receiveDelete(product: Product){
        val productId = product.id
        productService.deleteProduct(UUID.randomUUID())
    }

}

