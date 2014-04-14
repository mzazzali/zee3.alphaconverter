(ns zee3.alphaconverter)

(def digits ["zero" "one" "two" "three" "four" "five" "six" "seven" "eight" "nine"])
(def tens [nil "ten" "twenty" "thirty" "forty" "fifthy" "sixty" "seventy" "eighty" "ninety"])
(def teens ["ten" "eleven" "twelve" "thirteen" "fourteen" "fifteen" "sixteen" "seventeen" "eighteen" "nineteen"])
(def tens-digits ["zero" "one" "two" "three" "four" "five" "six" "seven" "eight" "nine" "ten" "eleven" "twelve" "thirteen" "fourteen" "fifteen" "sixteen" "seventeen" "eighteen" "nineteen"])

(defn get-decimal
  [decimal]
  (mod (int (* decimal 100)) 100))

(defn convert-decimal
  [number]
  (let [decimal (get-decimal number)])
    (str (get-decimal number) "/100"))

(defn convert-single-digit
  "convert a digit to a text representation"
  [d]
  (nth digits d))

(defn convert-tens-digit
  "convert the tens digit to a text representation"
  [d]
  (nth tens d))

(defn convert-teens
  "convert the teens digit to a text representation"
  [d]
  (nth tens-digits d))

(defn convert-number-part
  [part]
  (cond (< part 20) (convert-teens part)))

(defn convert-number
  ([number]
    (let [decimal (convert-decimal number)
          s (cons decimal [])]
    (convert-number number 100 (mod (int number) 100) s)))
  ([number m k s]
    (println number)
    (println m)
    (println k)
    (println s)
    (if (and (< (+ 1 (count (str k))) (count (str m)) )
             (not (and (= (count (str k)) 1) (= m 100))))
      (str (first s) (reduce str " and " (rest s)))
      (recur number (* m 10) (mod (int number) (* m 10)) (cons (convert-number-part k) s)))))

