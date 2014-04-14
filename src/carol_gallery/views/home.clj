(ns carol-gallery.views.home
  (:require [carol-gallery.views.layout :as layout]))

(defn index []
  "Home page"
  (layout/main 
    "Carol Wu Homepage" 
    [:div {:style "padding-top: 40px 15px; text-align: center;"} 
     [:h1 "This is the homepage"]] ))
