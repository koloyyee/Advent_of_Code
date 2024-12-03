(ns core
  (:require
   [clojure.java.io :as io]
   [clojure.string :as str]))

(defn read-file
  [filename]
  (with-open [rdr (io/reader filename)]
    (into [] (line-seq rdr))))

(defn intify-seq [seq-string]
  (map #(Integer/parseInt %) seq-string))

(defn string-to-ints [line]
  (intify-seq (str/split line #"\s+")))