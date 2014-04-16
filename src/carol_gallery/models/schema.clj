(ns carol-gallery.models.schema
  (:require [carol-gallery.models.db :refer :all]
            [clojure.java.jdbc :as sql]))

(defn create-gallery-table []
 (sql/with-connection db
   (sql/create-table
     :gallery
     [:id "varchar(32) PRIMARY KEY"]
     [:name "varchar(100)"]
     [:description "varchar(512)"]
     [:pictureid "varchar(32)"]
     )))

(defn create-picture-table []
  (sql/with-connection db
    (sql/create-table
      :picture
      [:id "varchar(32) PRIMARY KEY"]
      [:filename "varchar(100)"]
      [:blurb "varchar(512"])))
