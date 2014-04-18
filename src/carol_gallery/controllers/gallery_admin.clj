(ns carol-gallery.controllers.gallery-admin
  (:require [carol-gallery.views.gallery-admin :as view]))

(defn main
  "gallery admin main page"
  []
  (view/gallery-admin))
