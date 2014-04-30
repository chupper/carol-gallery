(ns carol-gallery.models.picture
  (require [clojure.java.jdbc :as jdbc]
           [carol-gallery.models.db :refer :all])
  (import [java.awt.image AffineTransformOp BufferedImage]
          [java.io FileInputStream ByteArrayOutputStream]
          java.awt.RenderingHints
          java.awt.geom.AffineTransform
          javax.imageio.ImageIO))

(defn to-byte-array
  "Converts a file input stream to a byte array." 
  [f] 
  (with-open [input  (FileInputStream. f)
              buffer  (ByteArrayOutputStream.)]
    (clojure.java.io/copy input buffer)
    (.toByteArray buffer)))

(defn scale
  "Scales the image to create a thumbnail" 
  [img ratio width height]
  (let [scale (AffineTransform/getScaleInstance (double ratio) (double ratio))
        transform-op (AffineTransformOp. scale AffineTransformOp/TYPE_BILINEAR)]
    (.filter transform-op img (BufferedImage. width height (.getType img)))))

(defn add-picture-record
  "Adds a new picture record to a gallery"
  [gallery-id picture-bytes picture-name picture-description]
  (let [picture {:name picture-name
                 :description picture-description
                 :galleryid (Integer. gallery-id)
                 :content (to-byte-array picture-bytes)
                 }]
    (jdbc/insert! db :picture picture)))

(defn read-pictures-from-galleryid
  "Reads the pictures from the gallery id"
  [gallery-id]
  (jdbc/query db ["SELECT p.id, p.name, p.description FROM picture p WHERE galleryid = ?", gallery-id]))

(defn read-picture-record-by-id [id]
  (first  (jdbc/query db ["SELECT * FROM picture WHERE id = ?", (Integer. id)])))
