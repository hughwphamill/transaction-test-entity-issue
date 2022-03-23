package com.github.hughwphamill.transactiontestentityissue.entity

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest
internal class TestEntityListenerTest {

    @Autowired
    private lateinit var repository: TestRepository

    @BeforeEach
    internal fun setUp() {
        repository.deleteAll()
        ResultSingleton.reset()
    }

    @Test
    internal fun `it should execute postLoad`() {
        // Given
        val id = 1L
        val entity = TestEntity().apply { this.id = id }
        repository.save(entity)

        // When
        repository.findByIdOrNull(id)

        // Then
        assertThat(ResultSingleton.postLoad).isTrue
    }

    @Test
    internal fun `it should execute prePersist`() {
        // Given
        val entity = TestEntity().apply { this.id = 1 }

        // When
        repository.save(entity)

        // Then
        assertThat(ResultSingleton.prePersist).isTrue
    }

    @Test
    internal fun `it should execute postPersist`() {
        // Given
        val entity = TestEntity().apply { this.id = 1 }

        // When
        repository.save(entity)

        // Then
        assertThat(ResultSingleton.postPersist).isTrue
    }

    @Test
    internal fun `it should execute preUpdate`() {
        // Given
        val entity = TestEntity().apply { this.id = 1 }
        repository.save(entity)
        entity.field = "updated"

        // When
        repository.save(entity)

        // Then
        assertThat(ResultSingleton.preUpdate).isTrue
    }

    @Test
    internal fun `it should execute postUpdate`() {
        // Given
        val entity = TestEntity().apply { this.id = 1 }
        repository.save(entity)
        entity.field = "updated"

        // When
        repository.save(entity)

        // Then
        assertThat(ResultSingleton.postUpdate).isTrue
    }

    @Test
    internal fun `it should execute preRemove`() {
        // Given
        val entity = TestEntity().apply { this.id = 1 }
        repository.save(entity)

        // When
        repository.delete(entity)

        // Then
        assertThat(ResultSingleton.preRemove).isTrue
    }

    @Test
    internal fun `it should execute postRemove`() {
        // Given
        val entity = TestEntity().apply { this.id = 1 }
        repository.save(entity)

        // When
        repository.delete(entity)

        // Then
        assertThat(ResultSingleton.postRemove).isTrue
    }
}