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
  [gallery-id picture-bytes picture-name picture-description]
  (let [picture {:name picture-name
                 :description picture-description
                 :galleryid (Integer. gallery-id)
                 :content (to-byte-array picture-bytes)
                 }]
    (jdbc/insert! db :picture picture)))

(defn read-picture-record-by-id [id]
  (first  (jdbc/query db ["SELECT * FROM picture WHERE id = ?", (Integer. id)])))
