package com.danilo.repository

import com.danilo.model.Product
import javax.inject.Singleton

@Singleton
interface ProductRepository {

    fun saveCql(product: Product): Product
    fun deleteCql(id: String)
    fun updateCql(product: Product): Product


}