(ns modern-cljs.canvas
  (:require [domina.core :refer [by-id]]
))

(defrecord Vector [x y])
(defrecord Segment [v1 v2])
(defrecord Rectangle [origin horiz vert])

(defn coord-map [rect]
  ((fn[point]
     )))

(defn make-picture [seglist]
  ((fn[rect]
     (doseq [seg seglist] (draw-line
                           ((coord-map rect) (:v1 seg))
                           ((coord-map rect) (:v2 seg)))))))

(defn make-rect [horiz vert origin] ("rectangle"))

(defn draw-segment [s]
  (fn[context]
    (let [v1 (:v1 s)
          v2 (:v2 s)]
      (do
        (.moveTo context (:x v1) (:y v1))
        (.lineTo context (:x v2) (:y v2))
        (.stroke context)))))

(def segment (Segment. (Vector. 0 0) (Vector. 200 200)))

(defn- get-context [c]
  (.getContext c "2d"))

(defn ^:export init []
  (when (and js/document
             (aget js/document "getElementById"))
    (let [context (get-context (by-id "canvas"))]
      ((draw-segment segment) context))))
