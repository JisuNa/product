package com.musinsa.product.domain.rdb.infrastructure.persistence.jpa.impl

import com.musinsa.product.domain.rdb.domain.dto.BrandDto
import com.musinsa.product.domain.rdb.domain.dto.ProductDto
import com.musinsa.product.domain.rdb.domain.dto.QBrandDto
import com.musinsa.product.domain.rdb.domain.dto.QProductDto
import com.musinsa.product.domain.rdb.domain.entity.QBrand.Companion.brand
import com.musinsa.product.domain.rdb.domain.entity.QCategory.Companion.category
import com.musinsa.product.domain.rdb.domain.entity.QProduct
import com.musinsa.product.domain.rdb.domain.entity.QProduct.Companion.product
import com.musinsa.product.domain.rdb.infrastructure.persistence.jpa.JpaProductRepositoryCustom
import com.querydsl.jpa.JPAExpressions
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class JpaProductRepositoryImpl(
    private val queryFactory: JPAQueryFactory
) : JpaProductRepositoryCustom {
    override fun findMinPriceProductsByCategory(): List<ProductDto> {
        val productSub = QProduct("productSub")

        return queryFactory
            .select(
                QProductDto(
                    brandId = product.brand.id,
                    brandName = brand.name,
                    categoryId = product.category.id,
                    categoryName = category.name,
                    price = product.price
                )
            )
            .from(product)
            .join(product.brand, brand)
            .join(product.category, category)
            .where(
                product.price.eq(
                    JPAExpressions
                        .select(productSub.price.min())
                        .from(productSub)
                        .where(productSub.category.id.eq(product.category.id))
                )
            )
            .fetch()
    }

    override fun findCheapestBrand(): BrandDto? {
        return queryFactory
            .select(
                QBrandDto(
                    brandId = product.brand.id,
                    brandName = brand.name
                )
            )
            .from(product)
            .join(product.brand, brand)
            .groupBy(product.brand.id)
            .orderBy(product.price.sum().asc())
            .limit(1)
            .fetchOne()
    }

    override fun findProductsByBrandId(brandId: Long): List<ProductDto> {
        return queryFactory
            .select(
                QProductDto(
                    brandId = product.brand.id,
                    brandName = brand.name,
                    categoryId = product.category.id,
                    categoryName = category.name,
                    price = product.price
                )
            )
            .from(product)
            .join(product.brand, brand)
            .join(product.category, category)
            .where(product.brand.id.eq(brandId))
            .fetch()
    }

    override fun findMinPriceProductByCategory(categoryId: Long): ProductDto? {
        return queryFactory
            .select(
                QProductDto(
                    brandId = product.brand.id,
                    brandName = brand.name,
                    categoryId = product.category.id,
                    categoryName = category.name,
                    price = product.price
                )
            )
            .from(product)
            .join(product.brand, brand)
            .join(product.category, category)
            .where(product.categoryId.eq(categoryId))
            .orderBy(product.price.asc())
            .limit(1)
            .fetchOne()
    }

    override fun findMaxPriceProductByCategory(categoryId: Long): ProductDto? {
        return queryFactory
            .select(
                QProductDto(
                    product.id,
                    brand.name,
                    product.id,
                    brand.name,
                    product.price
                )
            )
            .from(product)
            .join(product.brand, brand)
            .where(product.category.id.eq(categoryId))
            .orderBy(product.price.desc())
            .limit(1)
            .fetchOne()
    }
}
