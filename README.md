# transaction-test-entity-issue
Example project showing entity listener failures in transactional tests

Contains 2 identical tests that exercise an entity listener

The non-transactional test executes all annotated entity listener methods

The transactional test fails to execute the following annotate entity listener methods

* `@PostPersist`
* `@PostLoad`
* `@PreUpdate`
* `@PostUpdate`
