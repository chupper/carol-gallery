(ns carol-gallery.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [carol-gallery.controllers.home :as home]
            [carol-gallery.controllers.gallery-admin :as g-admin]
            ))

(defroutes app-routes
  (GET "/" [] (home/index))
  (GET "/gallery-admin" [_] (g-admin/main))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
