(ns carol-gallery.models.picture
  (require [clojure.java.jdbc :as jdbc]
           [carol-gallery.models.db :refer :all]))

(defn to-byte-array  [f] 
  (with-open  [input  (new java.io.FileInputStream f)
               buffer  (new java.io.ByteArrayOutputStream)]
    (clojure.java.io/copy input buffer)
    (.toByteArray buffer)))

(defn add-picture-record
  [gallery-id picture-bytes picture-name picture-description]
  (let [picture {:name picture-name
                 :description picture-description
                 :galleryid (Integer. gallery-id)
                 :content (to-byte-array picture-bytes)
                 }]
  (jdbc/insert! db :picture picture)))

(defn read-picture-record-by-id [id]
  (first  (jdbc/query db ["SELECT * FROM picture WHERE id = ?", (Integer. id)])))
