(ns zee3.alphaconverter)

(defn get-decimal
  [decimal]
  (mod (int (* decimal 100)) 100))

(defn convert-decimal
  "I don't do a whole lot."
  [number]
  (let [decimal (get-decimal number)])
    (str (get-decimal number) "/100"))




