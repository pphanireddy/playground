(ns my-app.core
  (:gen-class))

(defn my-func
      "Docstring for my-func."
      [x]
      (* x x))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, Rayaru's friend!")
  (println (my-func 3)))
