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

(defn incl [letters]
  (fn [l]
      (let [l* (inc (int l))]
        (if (< l* (+ 65 (count letters)))
            (char l*)))))

;; instead of  (iterate (incl letters) current-letter)
(defn letters-from [current-letter letters]
  (if current-letter
      (cons current-letter
            (letters-from ((incl letters) current-letter)
                          letters))))

(defn gen-card [n card cards letters current-letter]
  (filter (fn []
              )
          (letters-from current-letter letters))
  (if (zero? n)
      card
      (if-let [next-letter
               (incl current-letter letters)]
              (recur (dec n)
                     (conj card
                           )
                     cards
                     letters
                     next-letter)
              'XXX)))

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
