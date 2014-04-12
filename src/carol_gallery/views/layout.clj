(ns carol-gallery.views.layout
  (:require [hiccup.page :as page]))

(defn main [title body]
  "layout page"
  (page/html5
    [:head 
     [:title title]]
    [:body
     [:div {:id "content"} body]]))
