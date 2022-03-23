package com.github.hughwphamill.transactiontestentityissue.entity

import javax.persistence.PostLoad
import javax.persistence.PostPersist
import javax.persistence.PostRemove
import javax.persistence.PostUpdate
import javax.persistence.PrePersist
import javax.persistence.PreRemove
import javax.persistence.PreUpdate

class TestEntityListener {

    @PostLoad
    fun postLoad(entity: TestEntity) {
        ResultSingleton.postLoad = true
    }

    @PrePersist
    fun prePersist(entity: TestEntity) {
        ResultSingleton.prePersist = true
    }

    @PostPersist
    fun postPersist(entity: TestEntity) {
        ResultSingleton.postPersist = true
    }

    @PreUpdate
    fun preUpdate(entity: TestEntity) {
        ResultSingleton.preUpdate = true
    }

    @PostUpdate
    fun postUpdate(entity: TestEntity) {
        ResultSingleton.postUpdate = true
    }

    @PreRemove
    fun preRemove(entity: TestEntity) {
        ResultSingleton.preRemove = true
    }

    @PostRemove
    fun postRemove(entity: TestEntity) {
        ResultSingleton.postRemove = true
    }
}