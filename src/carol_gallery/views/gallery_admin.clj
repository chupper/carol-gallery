(ns carol-gallery.views.gallery-admin
  (:require [carol-gallery.views.layout :as layout]))

(defn gallery-item [item]
  [:a.list-group-item
   [:span (:name item)]])

(defn gallery-select
  "creates the gallery menus from the seq given"
  [galleries]
  [:div.list-group
   (map gallery-item galleries)]) 

(defn gallery-admin
  "has a view with the list of galleries that need to be updated"
  [galleries]
  (layout/main 
    "Gallery Admin"
    [:div.content-main
     [:div.row
      [:div.col-md-4
      [:h3 "Galleries"] (gallery-select galleries)]
      [:div.col-md-8 
       [:h3 "This is the admin page"]]]]))

