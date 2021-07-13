package com.danilo.repository

import com.danilo.model.Product
import java.util.UUID
import javax.inject.Singleton

@Singleton
interface ProductRepository {

    fun saveCql(product: Product): Product
    fun deleteCql(id: UUID)
    fun updateCql(id: UUID, product: Product): Product


}