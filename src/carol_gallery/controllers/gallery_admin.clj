(ns carol-gallery.controllers.gallery-admin
  (:require [carol-gallery.views.gallery-admin :as view]
            [carol-gallery.models.gallery :as gallery]
            ))

(defn main
  "gallery admin main page"
  []
  (let [galleries (gallery/read-galleries)]
    (view/gallery-admin galleries)))
