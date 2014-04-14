(ns zee3.alphaconverter)

(def digits ["zero" "one" "two" "three" "four" "five" "six" "seven" "eight" "nine"])
(def tens [nil "ten" "twenty" "thirty" "forty" "fifty" "sixty" "seventy" "eighty" "ninety"])
(def teens ["ten" "eleven" "twelve" "thirteen" "fourteen" "fifteen" "sixteen" "seventeen" "eighteen" "nineteen"])
(def tens-digits ["zero" "one" "two" "three" "four" "five" "six" "seven" "eight" "nine" "ten" "eleven" "twelve" "thirteen" "fourteen" "fifteen" "sixteen" "seventeen" "eighteen" "nineteen"])

(defn get-place-descriptor
  [m]
  (cond
   (<= m 1000) "hundred"))

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
  [part m]
  (cond (< part 20) (convert-teens part)
        (< part 100) (str (convert-tens-digit (/ part 10)) "-" (convert-single-digit (mod part 10)))
        :else (str (convert-single-digit (/ part 100)) " " (get-place-descriptor  m))))

(defn is-not-single-digit
  "make sure that on the first time through a single digit is still processed"
  [k m]
  (not (and (= (count (str k)) 1) (= m 100))))

(defn render-text
  [s]
  (str (first s) " and " (reduce str (interpose " and " (rest s)))))

(defn convert-number
  ([number]
    (let [decimal (convert-decimal number)
          s (cons decimal [])]
    (convert-number number 100 (mod (int number) 100) s)))
  ([number m k s]
    (if (and (< (+ 1 (count (str k))) (count (str m)) )
             (is-not-single-digit k m))
      (render-text s)
      (recur number (* m 10) (mod (int number) (* m 10)) (cons (convert-number-part k m) s)))))


