(ns carol-gallery.views.layout
  (:require [hiccup.page :as page]))

(defn main [title body]
  "layout page"
  (page/html5
    [:head 
     [:title title]
     [:link {:rel "stylesheet" :href "//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css"}]
     [:link {:rel "stylesheet" :href "style.css"}]
     [:script {:src "//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"}]]
    [:body
     [:div {:class "navbar navbar-inverse navbar-fixed-top" :role "navigation"}]
     [:div {:class "container"} body]]))
