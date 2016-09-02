(ns modern-cljs.shopping
  (:require [domina.core :refer [append!
                                 destroy!
                                 by-id
                                 by-class
                                 value
                                 set-value!]]
            [domina.events :refer [listen!]]
            [hiccups.runtime])
  (:require-macros [hiccups.core :refer [html]]))


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

(defn- show-help! []
  (append! (by-id "shoppingForm")
           (html [:div.help "Click to calculate"])))

(defn- hide-help! []
  (destroy! (by-class "help")))

(defn ^:export init []
  (when (and js/document
           (aget js/document "getElementById"))
    (listen! (by-id "calc") :click calculate)
    (listen! (by-id "calc") :mouseover  show-help!)
    (listen! (by-id "calc") :mouseout  hide-help!)))

