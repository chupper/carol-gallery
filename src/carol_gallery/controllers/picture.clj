(ns carol-gallery.controllers.picture
  (require [carol-gallery.models.picture :as picture]
           [ring.util.response :as response]
           ))

(defn get-picture-response
  [id]
  (let [record (picture/read-picture-record-by-id id)]
    (-> (response/response (new java.io.ByteArrayInputStream (:content record)))
        (response/content-type "image/jpeg")
        (response/header "Content-Length" (alength (:content record))))))
