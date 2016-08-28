(ns modern-cljs.shopping
  (:require [domina.core :refer [by-id value set-value!]]))


(defn calculate []
  (let [quantity (value (by-id "quantity"))
        price    (value (by-id "price"))
        tax      (value (by-id "tax"))
        discount (value (by-id "discount"))]
    (set-value! (by-id "total") (-> (* quantity price)
                                    (* (+ 1 (/ tax 100)))
                                    (- discount)
                                    (+ 100)
                                    (.toFixed 2)))
    false))

(defn ^:export init []
  (if (and js/document
           (.-getElementById js/document))
    (let [shopping-form (.getElementById js/document "shoppingForm")]
      (set! (.-onsubmit shopping-form) calculate))))

