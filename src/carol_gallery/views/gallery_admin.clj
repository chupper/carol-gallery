(ns carol-gallery.views.gallery-admin
 (:require [carol-gallery.views.layout :as layout]))

(defn gallery-admin
  "has a view with the list of galleries that need to be updated"
  []
  (layout/main 
    "Gallery Admin"
    [:div.content-main
     [:h1 "This is the admin page"]]))
