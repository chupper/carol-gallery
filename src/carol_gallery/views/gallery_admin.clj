(ns carol-gallery.views.gallery-admin
  (:require [carol-gallery.views.layout :as layout]
            [hiccup.form :refer :all]
            ))

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

(defn generate-thumbnails [image]
  [:div.col-xs-6.col-md-3 
   [:a.thumbnail {:href "#"}
    [:img.placeholder {:data-src "test.jpg" :alt "hi"}]]])

(defn gallery-images-edit [images]
  (map generate-thumbnails images))

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
       ]]]))

(defn form-group [label control-type id & control-class]
  [:div.form-group
   [:label {:for id} label]
   [:input.form-control (conj {:id id :type control-type} (first control-class))]])

(defn form-group-textarea [label control-type id rows]
  [:div.form-group
   [:label {:for id} label]
   [:textarea.form-control {:id id :type control-type :rows rows}]])


(defn gallery-new
  "Creates a new gallery"
  [galleries]
  (layout/main
    (str "Create Gallery")
    [:div.content-main
     [:div.row
      [:div.col-md-2
       [:h4.page-header "Galleries"]
       (gallery-select galleries)
       [:div.list-group
        [:a.list-group-item {:href "/gallery-admin/new"} "Add New"]]]
      [:div.col-md-8 
       [:h4.page-header "Create new gallery"]
       (form-to [:post "/gallery-admin/new"]
                   (form-group "Name" "text" "name") 
                   (form-group-textarea "Description" "text-area" "description" 4)
                   [:button.btn.btn-default {:type "submit"} "Submit"]
                     )
       ]]]))
