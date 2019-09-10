(ns spotit
    )

;; library

(defn square [n]
  (* n n))

;; A variant of iterate that stops when f returns nil
(defn iterate*
  "Returns a lazy sequence of x, (f x), (f (f x)) etc., which ends when f returns nil. f must be free of side-effects"
  [f x] ((fn rec [x]
             (lazy-seq
              (if x
                  (cons x (rec (f x))))))
         x))

;; /library


(defn num-letters [n]
     (+ (- (square n) n) 1))

(defn make-letters [n]
  (->> (range 0 (num-letters n))
       (map #(char (+ 65 %)))))

(defn incl [letters]
  (fn [l]
      (let [l* (inc (int l))]
        (if (< l* (+ 65 (count letters)))
            (char l*)))))


(defn gen-card [n card cards letters current-letter]
  (filter (fn []
              )
          (iterate* (incl letters) current-letter))
  ;; (if (zero? n)
  ;;     card
  ;;     (if-let [next-letter
  ;;              (incl current-letter letters)]
  ;;             (recur (dec n)
  ;;                    (conj card
  ;;                          )
  ;;                    cards
  ;;                    letters
  ;;                    next-letter)
  ;;             'XXX))
  )

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
