(ns carol-gallery.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [carol-gallery.controllers.home :as home]
            ))

(defroutes app-routes
  (GET "/" [] (home/index))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
