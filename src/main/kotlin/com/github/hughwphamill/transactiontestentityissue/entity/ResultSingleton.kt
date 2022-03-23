package com.github.hughwphamill.transactiontestentityissue.entity

class ResultSingleton {

    companion object {
        var postLoad = false
        var prePersist = false
        var postPersist = false
        var preUpdate = false
        var postUpdate = false
        var preRemove = false
        var postRemove = false

        fun reset() {
            postLoad = false
            prePersist = false
            postPersist = false
            preUpdate = false
            postUpdate = false
            preRemove = false
            postRemove = false
        }
    }
}