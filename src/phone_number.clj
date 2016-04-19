(ns phone-number
  (:require [clojure.string :as str]))

(defn number-without-punctuation-or-blanks [phone-number]
  (str/replace phone-number #"\p{Blank}|\p{Punct}" ""))

(defn change-to-valid-number [phone-number]
  (cond
    (= (count phone-number) 10) phone-number
    (and (= (count phone-number) 11) (str/starts-with? phone-number "1")) (str/replace-first phone-number "1" "")
    :else "0000000000"))

(defn number [phone-number]
  (-> phone-number
      number-without-punctuation-or-blanks
      change-to-valid-number))
