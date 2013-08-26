(ns gol.core-test
  (:require [clojure.test :refer :all]
            [gol.core :refer :all]))
(def board
	[[0 1 1 1]
	 [1 0 1 0]
	 [0 1 0 1]
	 [1 1 1 0]])


(deftest can-count-live-cells
	(is (= 
		(count-live-cells board)
		10))
)

(deftest can-get-neighborhood
	(is (= (get-neighborhood board 1 1) [[0 0] [0 1] [0 2] [1 0] [1 2] [2 0] [2 1] [2 2]]))
)

(deftest can-get-cell
	(is (= (get-cell board 0 1) 1 ))
	(is (= (get-cell board 2 3) 1 ))
	(is (= (get-cell board 0 2) 1 ))
	(is (= (get-cell board 2 0) 0 ))
	(is (= (get-cell board 0 0) 0 ))
	(is (= (get-cell board -1 0) 0 ))
	(is (= (get-cell board 0 -1) 0 ))
	(is (= (get-cell board 5 0) 0 ))
	(is (= (get-cell board 0 5) 0 ))
)

(deftest can-sum-neighborhood
	(is (= (sum-neighborhood board 1 1) 5)))

(deftest test-next-gen
	(is (= 0 (next-gen board 1 1)))
	(is (= 0 (next-gen board 3 3)))
	(is (= 1 (next-gen board 3 1)))
	(is (= 1 (next-gen board 3 0)))
	(is (= 1 (next-gen board 0 2)))
)