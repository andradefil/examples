(ns library.core
  (:require [datomic.api :as d]))

(def scheme
  [{:db/ident :book/title
    :db/cardinality :db.cardinality/one
    :db/valueType :db.type/string}
   {:db/ident :book/author
    :db/cardinality :db.cardinality/one
    :db/valueType :db.type/ref}])

(def db-uri "datomic:dev://localhost:4334/library")
(d/create-database db-uri)
(def conn (d/connect db-uri))

(d/transact conn scheme)

;; alter :book/author cardinality
(d/transact conn [{:db/ident :book/author
                   :db/cardinality :db.cardinality/many
                   :db/valueType :db.type/ref}])

;; include author scheme
(d/transact conn [{:db/ident :author/name
                   :db/cardinality :db.cardinality/one
                   :db/valueType :db.type/string}])

(d/transact
 conn
 [{:book/title "The Pragmatic Programmer"
   :book/author ["foo" "bar"]}
  {:db/id "foo" :author/name "Hunt Andrew"}
  {:db/id "bar" :author/name "Thomas David"}])


;; Queries

;; verifying datoms
(seq (d/datoms (d/db conn) :eavt))
