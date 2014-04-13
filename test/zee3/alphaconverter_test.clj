(ns zee3.alphaconverter-test
  (:require [clojure.test :refer :all]
            [zee3.alphaconverter :refer :all]))

(deftest test-convert-decimal
  (testing "decimal conversion"
    (is (= "23/100" (convert-decimal 0.23)))))

(deftest test-get-decimal
  (testing "decimal retrieval"
    (is (= 23 (get-decimal 1000.23)))
    (is (= 48 (get-decimal 2.48)))
    (is (= 0 (get-decimal 1000)))
    (is (= 0 (get-decimal 1000.0)))
    (is (= 90 (get-decimal 1000.9)))))

(deftest test-convert-single-digit
  (testing "converting a single digit"
          (is (= "one" (convert-single-digit 1)))
          (is (= "two" (convert-single-digit 2)))
          (is (= "three" (convert-single-digit 3)))
          (is (= "four" (convert-single-digit 4)))
          (is (= "five" (convert-single-digit 5)))
          (is (= "six" (convert-single-digit 6)))
          (is (= "seven" (convert-single-digit 7)))
          (is (= "eight" (convert-single-digit 8)))
          (is (= "nine" (convert-single-digit 9)))
          (is (= "zero" (convert-single-digit 0)))))

(deftest test-convert-tens-digit
  (testing "converting the tends digit"
          (is (= "twenty" (convert-tens-digit 2)))
          (is (= "thirty" (convert-tens-digit 3)))
          (is (= "forty" (convert-tens-digit 4)))
          (is (= "fifthy" (convert-tens-digit 5)))
          (is (= "sixty" (convert-tens-digit 6)))
          (is (= "seventy" (convert-tens-digit 7)))
          (is (= "eighty" (convert-tens-digit 8)))
          (is (= "ninety" (convert-tens-digit 9)))))
