(ns carol-gallery.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [carol-gallery.controllers.home :as home]
            [carol-gallery.controllers.gallery-admin :as g-admin]
            [carol-gallery.controllers.picture-admin :as p-admin]
            [carol-gallery.controllers.picture :as picture]
            ))

(defroutes app-routes
  (GET "/" [] (home/index))
  (GET "/picture/:id" [id] (picture/get-picture-response id))
  (GET "/gallery-admin" [_] (g-admin/main))
  (GET "/gallery-admin/edit/:id" [id] (g-admin/edit-gallery id))
  (POST "/gallery-admin/edit/:id" [id name description] (g-admin/post-edit-gallery id name description))
  (GET "/gallery-admin/new" [] (g-admin/new-gallery))
  (POST "/gallery-admin/new" [name description] (g-admin/post-new-gallery name description))
  (POST "/gallery-admin/:id/picture/new" [id name description file] (p-admin/post-new-picture id name description file))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
