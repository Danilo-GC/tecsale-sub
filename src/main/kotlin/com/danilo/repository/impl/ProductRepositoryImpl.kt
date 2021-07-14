package com.danilo.repository.impl

import com.danilo.model.Product
import com.danilo.repository.ProductRepository
import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.UUID
import javax.inject.Singleton

@Singleton
class ProductRepositoryImpl(private val cqlSession: CqlSession) : ProductRepository {

    private val log: Logger = LoggerFactory.getLogger(this::class.java)

    override fun saveCql(product: Product): Product {
        cqlSession.execute(
            SimpleStatement
                .newInstance(
                    "INSERT INTO product.Product(id,name,price,type,description) VALUES (?,?,?,?,?)",
                    UUID.randomUUID(),
                    product.name,
                    product.price,
                    product.type,
                    product.description
                )
        )
        log.info("product added")
        return product
    }

    override fun deleteCql(id: String) {
        cqlSession.execute(
            SimpleStatement
                .newInstance(
                    "DELETE FROM product.Product WHERE id = ?",
                    UUID.fromString(id)
                )
        )
        log.info("product deleted")
    }

    override fun updateCql(product: Product): Product {
        cqlSession.execute(
            SimpleStatement
                .newInstance(
                    "UPDATE product.Product SET name = ?, price = ?, type = ?,description = ? WHERE id = ?",
                    product.name,
                    product.price,
                    product.type,
                    product.description,
                    product.id
                )
        )
        log.info("product updated")
        return product
    }
}