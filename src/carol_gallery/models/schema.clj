(ns carol-gallery.models.schema
  (:require [carol-gallery.models.db :refer :all]
            [clojure.java.jdbc :as jdbc]))

(defn drop-all-tables []
  (jdbc/db-do-commands db
                       (jdbc/drop-table-ddl :picture)
                       (jdbc/drop-table-ddl :gallery)))

(defn create-gallery-table []
  (jdbc/db-do-commands db
                       (jdbc/create-table-ddl
                         :gallery
                         [:id "serial PRIMARY KEY"]
                         [:name "varchar(100)"]
                         [:description "varchar(2000)"]
                         [:pictureid "varchar(32)"]
                         )))

(defn create-picture-table []
  (jdbc/db-do-commands db
                       (jdbc/create-table-ddl 
                         :picture
                         [:id "serial PRIMARY KEY"]
                         [:galleryid "varchar(32)"]
                         [:filename "varchar(100)"]
                         [:thumbnail "bytea"]
                         [:content "bytea"]
                         [:blurb "varchar(512)"])))

(defn create-all-tables []
  (do  
    (create-gallery-table) 
    (create-picture-table)))
