(ns dojo
    )

(defn square [n]
  (* n n))


(defn num-letters [n]
     (+ (- (square n) n) 1))

(defn make-letters [n]
  (map (fn [i]
           (char (+ 65 i)))
       (range 0 (num-letters n))))

(defn incl [l letters]
  (let [l* (inc (int l))]
    (if (< l* (+ 65 (count letters)))
        (char l*))))

(defn gen-card [n card cards letters]
  (if (zero? n)
      #{}
      (conj card
            (incl letter ))))

(defn gen-cards [n cards letters current-letter]
  (gen-card n #{current-letter}))

(defn gen [n]
  (let [letters
        (make-letters n)
        
        ]
    (loop [cards
           #{}
           current-letter
           \A]
          (gen-cards current-letter
                    ))))
