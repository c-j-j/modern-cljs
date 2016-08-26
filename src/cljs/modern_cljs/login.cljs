(ns modern-cljs.login)

(defn validate-form []
  (let [email (.-value (.getElementById js/document "email"))
        password (.-value (.getElementById js/document "password"))]
    (if (> (count email) 0)
      true
      (do (js/alert "No, that's not right")
          false))))

(defn init []
  (if (and js/document
           (.-getElementById js/document))
    (let [login-form (.getElementById js/document "loginForm")]
      (set! (.-onsubmit login-form) validate-form))))

(set! (.-onload js/window) init)
