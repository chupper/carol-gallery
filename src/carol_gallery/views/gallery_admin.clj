(ns carol-gallery.views.gallery-admin
  (:require [carol-gallery.views.layout :as layout]
            [hiccup.form :refer :all]
            ))

(defn form-group [label control-type id value & control-class]
  [:div.form-group
   [:label {:for id} label]
   [:input.form-control (conj {:id id :name id :type control-type :value value} (first control-class))]])

(defn form-group-textarea [label control-type id value rows]
  [:div.form-group
   [:label {:for id} label]
   [:textarea.form-control {:name id :id id :type control-type :rows rows } value]])
 
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
       [:h4.page-header "Gallery Edit"]
       [:p  (str "This is the edit page for gallery: " (gallery :name))]
       (form-to [:post "/gallery-admin/edit"]
                (form-group "Name" "text" "name" (gallery :name)) 
                (form-group-textarea "Description" "text-area" "description" (gallery :description) 4)
                [:button.btn.btn-default {:type "submit"} "Edit"]) 
       (gallery-images-edit images)
       ]]]))

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
                   (form-group "Name" "text" "name" "") 
                   (form-group-textarea "Description" "text-area" "description" "" 4)
                   [:button.btn.btn-default {:type "submit"} "Create"])]]]))
