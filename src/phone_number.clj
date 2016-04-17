(ns phone-number
 (:require [clojure.string :as str]))

(defn number-without-punctuation-or-blanks [phone-number]
 (str/replace phone-number #"\p{Blank}|\p{Punct}" ""))

(defn eleven-digits? [phone-number]
 (= (count phone-number) 11))

(defn strip-first-char-when-11-digits-and-first-is-1 [phone-number]
 (if (and (eleven-digits? phone-number) (str/starts-with? phone-number "1"))
  (str/replace-first phone-number "1" "")
  phone-number))

 (defn number [phone-number]
  (-> phone-number
      number-without-punctuation-or-blanks
      strip-first-char-when-11-digits-and-first-is-1))
