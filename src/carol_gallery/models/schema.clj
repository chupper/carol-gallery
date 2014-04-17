(ns carol-gallery.models.schema
  (:require [carol-gallery.models.db :refer :all]
            [clojure.java.jdbc :as jdbc]))

(defn drop-all-tables []
  (jdbc/db-do-commands db
                       (jdbc/drop-table-ddl :picture)
                       (jdbc/drop-table-ddl :gallery)))

(defn create-all-tables []
  (do (create-gallery-table)
      (create-picture-table)))

(defn create-gallery-table []
  (jdbc/db-do-commands db
                       (jdbc/create-table-ddl
                         :gallery
                         [:id "varchar(32) PRIMARY KEY"]
                         [:name "varchar(100)"]
                         [:description "varchar(512)"]
                         [:pictureid "varchar(32)"]
                         )))

(defn create-picture-table []
  (jdbc/db-do-commands db
                       (jdbc/create-table-ddl 
                         :picture
                         [:id "varchar(32) PRIMARY KEY"]
                         [:filename "varchar(100)"]
                         [:blurb "varchar(512)"])))
