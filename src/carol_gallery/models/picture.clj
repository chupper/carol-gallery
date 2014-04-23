(ns carol-gallery.models.picture
   (:require [clojure.java.jdbc :as jdbc]
             [carol-gallery.models.db :refer :all]))

(defn add-picture
  [picture-bytes picture-name gallery-id]
  (jdbc/insert! db :picture {:content picture-bytes})
  )
