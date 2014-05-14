(ns carol-gallery.controllers.picture-admin
  (:require [carol-gallery.models.picture :as picture]
            [ring.util.response :as resp]))

(defn post-new-picture
  "Adds a new picture to the database and returns to the gallery main page"
  [gallery-id picture-name description {:keys [filename tempfile] :as file}]
  (picture/add-picture-record gallery-id tempfile picture-name description)
  (resp/redirect (str "/gallery-admin/edit/" gallery-id)))
