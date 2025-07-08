(ns alg.core
  (:require [clojure.math :as math]))

(defn higher-n
  "Receives a pair of x,y and returns the high number
  resulting of the comparing the first by second."
  [[x y]]
  (if (> x y)
    x
    y))

(defn adjust-perc
  "Returns the adjusted percentage p in v."
  [p v]
  (+ v (* v (/ p 100))))

(defn consumation
  "Given the consumed quantity and balance, calculate the consumation
  given constant of 2% amount from balance plus discount of 15%.
  Return a map of keys:
  
   :consumed-amount amount consumed calculated from baseline of 2% from balance
   :counsumed-amount-discount the consumed amount with discount of 15%"
  [qty balance]
  (let [base (* 0.02 balance)
        consumed-amount (* qty base)
        consumed-amount-discount (- consumed-amount (* 0.15 consumed-amount))]
    {:consumed-amount consumed-amount
     :consumed-amount-discount consumed-amount-discount}))

(defn switch
  "Receives a tuple [x,y] and return a tuple of [y,x]."
  [[x y]]
  [y x])

(defn hyp
  "Returns result the sum of the square of b and square of c."
  [b c]
  (+ (math/pow b 2) (math/pow c 2)))


(higher-n [3 2])
(adjust-perc 1 100)
(consumation 1 1000)
(switch [2 3])
(hyp 2 3)
