(ns carol-gallery.views.home
  (:require [carol-gallery.views.layout :as layout]))

(defn index []
  "Home page"
  (layout/main 
    "Carol Wu Homepage" 
    [:h1 "This is the homepage"]))
