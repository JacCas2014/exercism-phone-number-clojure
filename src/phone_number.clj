(ns phone-number
 (:require [clojure.string :as str]))

(defn number-without-punctuation-or-blanks [phone-number]
 (str/replace phone-number #"\p{Blank}|\p{Punct}" ""))

 (defn number [phone-number]
  (number-without-punctuation-or-blanks phone-number))
