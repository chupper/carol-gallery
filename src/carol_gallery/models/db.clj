(ns carol-gallery.models.db
  (:require [clojure.java.jdc :as sql]))

(def db
  {:subprotocol "postgresql"
   :subname "//localhost/gallery"
   :user "admin"
   :password "admin"})
