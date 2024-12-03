(ns day01
  (:require
   [core :refer :all]))

(def	 sample-bigger
  "63721   98916
83871   23584
55026   62690
21948   69139")

(def sample "342133   435393")

(def txt (read-file "inputs/01.txt"))
txt
;; (defn abs-diff [h t]
;;   (map #(abs (- %1 %2)) h t))

;; (def firsts (map #(first (string-to-ints %)) txt))
;; (def lasts (map #(last (string-to-ints %)) txt))

(defn txt-to-ints [f txt] (map #(f (string-to-ints %)) txt))

(def firsts (txt-to-ints first txt))
(def lasts (txt-to-ints last txt))
firsts

;; part 1 
(defn pt1 []  (reduce +
                         ((fn [firsts lasts] (map (fn [f l] (abs (- f l))) firsts lasts))
                          (sort firsts)
                          (sort lasts ))))

(pt1)

;; part 2 
firsts
(frequencies lasts)

(map (fn [f] (get (frequencies lasts) f)) firsts)

(defn pt2 [firsts lasts]
  (reduce +
          (let [freq (frequencies lasts)]
            (map #(* % (get freq % 0)) firsts))))

(pt2 firsts lasts)