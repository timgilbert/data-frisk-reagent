(ns datafrisk.ui-card
  (:require [devcards.core]
            [reagent.core :as r]
            [datafrisk.core :refer [Root]])
  (:require-macros [devcards.core :as dc :refer [defcard-rg]]))

(defcard-rg modifiable-data
  "When the data you are watching is swappable, you can edit it."
  [Root
   (r/atom 3)
   "root"
   (r/atom {})])

(defcard-rg modifiable-nested-data
  "When the data you are watching is nested in a swappable, you can edit the values."
  [Root
   (r/atom {:foo 2
            3 "bar"})
   "root"
   (r/atom {})])

(defcard-rg data-types
  [Root
   {:a "I'm a string"
    :b :imakeyword
    :c [1 2 3]
    :d '(1 2 3)
    :e #{1 2 3}
    :f (clj->js {:i-am "an-object"})
    "g" "String key"
    0 nil}
   "root"
   (r/atom {})])

(defcard-rg first-level-expanded
  [Root
   {:a "a"
    :b [1 2 3]
    :c :d}
   "root"
   (r/atom {:data-frisk {"root" {:expanded-paths #{[]}}}})])

(defcard-rg second-level-expanded
  [Root {:a "a"
         :b [1 2 3]
         :c :d}
   "root"
   (r/atom {:data-frisk {"root" {:expanded-paths #{[] [:b]}}}})])

(defcard-rg empty-collections
  [Root {:set #{}
         :vec []
         :list '()}
   "root"
   (r/atom {:data-frisk {"root" {:expanded-paths #{[]}}}})])