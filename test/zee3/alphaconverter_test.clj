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
