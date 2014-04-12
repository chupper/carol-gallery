(ns carol-gallery.controllers.home
  (:require [carol-gallery.views.home :as home]))

(defn index []
  "At the moment just renders the index"
  (home/index))
