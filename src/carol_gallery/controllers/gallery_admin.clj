(ns carol-gallery.controllers.gallery-admin
  (:require [carol-gallery.views.gallery-admin :as view]
            [carol-gallery.models.gallery :as gallery]))

(defn main
  "gallery admin main page"
  []
  (let [galleries (gallery/read-galleries)]
    (view/gallery-admin galleries)))

(defn edit-gallery
  "gallery admin edit page"
  [id]
  (let [galleries (gallery/read-galleries)]
    (view/gallery-edit galleries {:name "test"} '({:id 1} {:id 2} {:id 3} {:id 4}))))

(defn new-gallery
  "Create gallery"
  []
  (let [galleries (gallery/read-galleries)]
    (view/gallery-new galleries)))

(defn post-new-gallery
  "Creates the new gallery and redirects to the new page"
  [name description]
  (str "test" name description )
  )
