(ns phone-number-test
  (:require [phone-number :refer :all]
            [clojure.string :as str])
  (:use midje.sweet))

(fact "cleans-number"
      (phone-number/number "(123) 456-7890") => "1234567890")

(fact "cleans-number-with-dots"
       (phone-number/number "555.867.5309") => "5558675309")

(fact "valid-when-11-digits-and-first-is-1"
      (phone-number/number "19876543210") => "9876543210")

(fact "invalid-when-11-digits"
       (phone-number/number "21234567890") => "0000000000")

(fact "invalid-when-9-digits"
       (phone-number/number "123456789") => "0000000000")

(future-fact "area-code"
       (phone-number/area-code "1234567890") => "123")

(future-fact "area-code-with-dots"
      (phone-number/area-code "555.867.5309") => "555")

(future-fact "area-code-with-parentheses"
      (phone-number/area-code "(987) 654-3210") => "987")

(future-fact "area-code-with-full-us-phone-number"
       (phone-number/area-code "11234567890") => "123")

(future-fact "pretty-print"
       (phone-number/pretty-print "1234567890") => "(123) 456-7890")

(future-fact "pretty-print-with-dots"
       (phone-number/pretty-print "555.867.5309") => "(555) 867-5309")

(future-fact "pretty-print-with-full-us-phone-number"
       (phone-number/pretty-print "19876543210") => "(987) 654-3210")