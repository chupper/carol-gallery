(ns carol-gallery.views.gallery-admin
  (:require [carol-gallery.views.layout :as layout]))

(defn gallery-item [item]
  [:a.list-group-item {:href (str "/gallery-admin/edit/" (:id item))} (:name item)])

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
      [:div.col-md-2
       [:h4.page-header "Galleries"]
       (gallery-select galleries)
       [:div.list-group
        [:a.list-group-item {:href "/gallery-admin/new"} "Add New"]]]
      [:div.col-md-8 
       [:h4.page-header "Gallery Administration"]]]]))

(defn gallery-edit
  "Has the view with galleries pictures in the list"
  [galleries gallery images]
  (layout/main
    (str "Gallery Edit: " (gallery :name))
    [:div.content-main
     [:div.row
      [:div.col-md-2
       [:h4.page-header "Galleries"]
       (gallery-select galleries)
       [:div.list-group
        [:a.list-group-item {:href "/gallery-admin/new"} "Add New"]]]
      [:div.col-md-8 
       [:h4.page-header "Gallery Administration"]
       (gallery-images-edit images)
       ]]] 
    )
  )

(defn gallery-images-edit [images]
  (map generate-thumbnails images))

(defn generate-thumbnails [image]
  [:div.col-xs-6.col-md-3 
   [:a.thumbnail {:href "#"}
    [:img.placeholder {:data-src "test.jpg" :alt "hi"}]]])

