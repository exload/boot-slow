(set-env!
  :source-paths #{"src" "test"}
  :resource-paths #{"src" "test"}
  :wagons '[[s3-wagon-private "1.1.2"]]
  :repositories [["clojars" "http://clojars.org/repo/"]
                 ["maven-central" "http://repo1.maven.org/maven2/"]]
  :dependencies '[[adzerk/boot-cljs "0.0-3308-0" :scope "test"]
                  [adzerk/boot-cljs-repl "0.1.9" :scope "test"]
                  [adzerk/boot-reload "0.3.1" :scope "test"]
                  [pandeiro/boot-http "0.6.2" :scope "test"]
                  [cljsjs/boot-cljsjs "0.5.0" :scope "test"]
                  [allgress/boot-tasks "0.2.2" :scope "test"]])

(require
  '[adzerk.boot-cljs :refer :all]
  '[adzerk.boot-cljs-repl :refer :all]
  '[adzerk.boot-reload :refer :all]
  '[allgress.boot-tasks :refer :all]
  '[pandeiro.boot-http :refer :all]
  '[cljsjs.boot-cljsjs :refer :all])

(set-project-deps!)

(default-task-options!)

(task-options!)

(deftask web-dev
         "Developer workflow for web-component UX."
         []
         (comp
           (asset-paths :asset-paths #{"html" "styles" "bower_components"})
           (serve :dir "target/")
           (watch)
           (speak)
           (reload)
           (cljs :compiler-options {:compiler-stats true})))