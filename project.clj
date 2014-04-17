(defproject carol-gallery "0.1.0-SNAPSHOT"
  :description "Carol's new gallery"
  :url "carolwu.net"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.6"]
                 [hiccup "1.0.5"]
                 [org.clojure/java.jdbc "0.3.3"]
                 [java-jdbc/dsl "0.1.0"]
                 [postgresql/postgresql "8.4-702.jdbc4"]
                 ]
  :plugins [[lein-ring "0.8.10"]]
  :ring {:handler carol-gallery.handler/app
         :nrepl {:start? true :port 3001}}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        ]}})
