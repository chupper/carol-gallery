(ns carol-gallery.models.gallery
  (:require [clojure.java.jdbc :as jdbc]
            [carol-gallery.models.db :refer :all]))

(defn add-gallery-record 
  [gallery]
  (jdbc/insert! db :gallery
                gallery))

(defn read-galleries []
  (jdbc/query db ["SELECT * from gallery"]))  
