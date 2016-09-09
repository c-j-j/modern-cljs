(ns modern-cljs.d3-wrapper)

(defn set-attr! [el k v]
  (.attr el k v))

(defn append! [el item]
  (.append el item))
