(ns carol-gallery.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [hiccup.page :as page]))

(defn index []
  "Home page"
  (page/html5
    [:head
     [:title "Carol Wu"]]
    [:body
     [:div {:id "content"} "Hi Carol's Empty Homepage"]])) 

(defroutes app-routes
  (GET "/" [] (index))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
