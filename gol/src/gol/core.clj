(ns gol.core
  (:gen-class))

(defn count-live-cells [board]
	(reduce + (flatten board)))


(defn get-cell [board row column]
	(nth (nth board row []) column 0)
)

(defn get-neighborhood [board row column]	
	(for [y (range (- row 1)   (+ row 2))
		  x (range (- column 1) (+ column 2))
          :when (not (and (= y row) (= x column)))]
		  [y x])
)

(defn sum-neighborhood [board row column]
	(reduce +
	(map #(get-cell board (% 0) (% 1))
		(get-neighborhood board row column)))
)

(defn next-gen [board row column]
	(let [live-neighbors (sum-neighborhood board row column)]
		(nth [0 0 (get-cell board row column) 1 0 0 0 0] live-neighbors )
		)

)


