(ns zee3.alphaconverter-test
  (:require [clojure.test :refer :all]
            [zee3.alphaconverter :refer :all]))

(deftest test-get-place-descriptor
  (testing "place descriptor retrieval"
    (is (= "hundred" (get-place-descriptor 1000)))))

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
  (testing "converting the tens digit"
          (is (= "twenty" (convert-tens-digit 2)))
          (is (= "thirty" (convert-tens-digit 3)))
          (is (= "forty" (convert-tens-digit 4)))
          (is (= "fifty" (convert-tens-digit 5)))
          (is (= "sixty" (convert-tens-digit 6)))
          (is (= "seventy" (convert-tens-digit 7)))
          (is (= "eighty" (convert-tens-digit 8)))
          (is (= "ninety" (convert-tens-digit 9)))))

(deftest test-convert-teens
  (testing "converting the teens digit"
          (is (= "one" (convert-teens 1)))
          (is (= "two" (convert-teens 2)))
          (is (= "three" (convert-teens 3)))
          (is (= "four" (convert-teens 4)))
          (is (= "five" (convert-teens 5)))
          (is (= "six" (convert-teens 6)))
          (is (= "seven" (convert-teens 7)))
          (is (= "eight" (convert-teens 8)))
          (is (= "nine" (convert-teens 9)))
          (is (= "zero" (convert-teens 0)))
          (is (= "eleven" (convert-teens 11)))
          (is (= "twelve" (convert-teens 12)))
          (is (= "thirteen" (convert-teens 13)))
          (is (= "fourteen" (convert-teens 14)))
          (is (= "fifteen" (convert-teens 15)))
          (is (= "sixteen" (convert-teens 16)))
          (is (= "seventeen" (convert-teens 17)))
          (is (= "eighteen" (convert-teens 18)))
          (is (= "nineteen" (convert-teens 19)))
          (is (= "ten" (convert-teens 10)))))

(deftest test-convert-number
  (testing "convert number to string representation"
    (is (= "ten and 0/100" (convert-number 10)))
    (is (= "one and 0/100" (convert-number 1)))
    (is (= "eighteen and 25/100" (convert-number 18.25)))
    (is (= "fifty-six and 98/100" (convert-number 56.98)))
    (is (= "two hundred and thirty-four and 89/100" (convert-number 234.89)))))

(deftest test-convert-number-part
  (testing "convert part of number"
    (is (= "one"  (convert-number-part 1 100)))
    (is (= "eleven"  (convert-number-part 11 100)))))

(deftest test-render-text
  (testing "rendering text"
    (is (= "ten and 0/100" (render-text ["ten" "0/100"])))
    (is (= "two hundred and thirty-four and 89/100" (render-text ["two hundred" "thirty-four" "89/100"])))))
