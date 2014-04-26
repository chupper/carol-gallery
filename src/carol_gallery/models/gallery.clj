(ns carol-gallery.models.gallery
  (:require [clojure.java.jdbc :as jdbc]
            [carol-gallery.models.db :refer :all]))

(defn add-gallery-record 
  [gallery]
  (jdbc/insert! db :gallery
                gallery))

(defn read-galleries []
  (jdbc/query db ["SELECT * from gallery"]))  

(defn read-gallery-from-id [id]
  (let [gallery (jdbc/query db ["SELECT * from gallery WHERE id = ?" id])]
    (first gallery)))

(defn get-galleryid-from-name
  [gallery-name]
  (jdbc/query db ["SELECT id FROM gallery WHERE name = ?" gallery-name]))
