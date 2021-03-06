(ns carol-gallery.controllers.gallery-admin
  (:require [carol-gallery.views.gallery-admin :as view]
            [carol-gallery.models.gallery :as gallery]
            [carol-gallery.models.picture :as picture]
            [ring.util.response :as resp])) 
(defn main
  "gallery admin main page"
  []
  (let [galleries (gallery/read-galleries)]
    (view/gallery-admin galleries)))

(defn edit-gallery
  "gallery admin edit page"
  [id]
  (let [galleries (gallery/read-galleries)
        gallery (gallery/read-gallery-from-id (Integer. id))
        pictures (picture/read-pictures-from-galleryid (Integer. id))]
    (view/gallery-edit galleries gallery pictures)))

(defn post-edit-gallery
  "Updates the gallery"
  [id name description]
  (do (gallery/update-gallery-from-id {:name name :description description} id)
      (resp/redirect (str "/gallery-admin/edit/" id))))

(defn new-gallery
  "Create gallery"
  []
  (let [galleries (gallery/read-galleries)]
    (view/gallery-new galleries)))

(defn post-new-gallery
  "Creates the new gallery and redirects to the gallery edit page, checks for duplicate names"
  [name description]
  (let [new-gallery (first (gallery/add-gallery-record {:name name :description description}))]
    (resp/redirect (str "/gallery-admin/edit/" (new-gallery :id)))))
