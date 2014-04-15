(ns carol-gallery.models.schema
  (:require [carol-gallery.models.db :refer :all]
            [clojure.java.jdc :as sql]))

(defn create-gallery-table []
 (sql/with-connection db
   (sql/create-table
     :gallery
     [:id "varchar(32) PRIMARY KEY"]
     [:name "varchar(100)"]
     [:description "varchar(512)"])))
