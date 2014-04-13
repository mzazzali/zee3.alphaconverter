(ns zee3.alphaconverter)

(def digits ["zero" "one" "two" "three" "four" "five" "six" "seven" "eight" "nine"])
(def tens [nil "ten" "twenty" "thirty" "forty" "fifthy" "sixty" "seventy" "eighty" "ninety"])

(defn get-decimal
  [decimal]
  (mod (int (* decimal 100)) 100))

(defn convert-decimal
  "I don't do a whole lot."
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
