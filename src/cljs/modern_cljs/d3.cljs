(ns modern-cljs.d3
  (:require [modern-cljs.d3-wrapper :as d3]))

(def body (.select js/d3 "body"))

(defn add-svg! [el w h]
  (let [svg (d3/append! el "svg")]
    (d3/set-attr! svg "width", w)))

(defn add-circle! [el cx cy r]
  (let [circle (d3/append! el "circle")]
    (-> circle
        (d3/set-attr! "cx" cx)
        (d3/set-attr! "cy" cy)
        (d3/set-attr! "r" r))))

(defn render-d3 []
  (-> body
      (add-svg! "50" "50")
      (add-circle! "25" "25" "5")))

(defn ^:export init []
  (if (and js/document
           (.-getElementById js/document))
    (render-d3)))

