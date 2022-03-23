package com.github.hughwphamill.transactiontestentityissue.entity

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EntityListeners
import javax.persistence.Id

@EntityListeners(TestEntityListener::class)
@Entity
class TestEntity {

    @Id
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @Column(name = "field", nullable = false)
    var field: String = "default"
}

@Repository
interface TestRepository : CrudRepository<TestEntity, Long>