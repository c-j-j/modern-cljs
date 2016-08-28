(ns modern-cljs.login
  (:require [domina.core :refer [by-id value set-value!]]))

(defn validate-form []
  (let [email (value (by-id "email"))
        password (value (by-id "password"))]
    (if (> (count email) 0)
      true
      (do (js/alert "No, that's not right")
          false))))

(defn ^:export init []
  (if (and js/document
           (.-getElementById js/document))
    (let [login-form (.getElementById js/document "loginForm")]
      (set! (.-onsubmit login-form) validate-form))))

