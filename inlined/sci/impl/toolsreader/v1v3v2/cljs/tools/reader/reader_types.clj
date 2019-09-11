(ns ^{:no-doc true} sci.impl.toolsreader.v1v3v2.cljs.tools.reader.reader-types)

(defmacro log-source
  "If reader is a SourceLoggingPushbackReader, execute body in a source
  logging context. Otherwise, execute body, returning the result."
  [reader & body]
  `(if (and (source-logging-reader? ~reader)
            (not (sci.impl.toolsreader.v1v3v2.cljs.tools.reader.impl.utils/whitespace? (peek-char ~reader))))
     (log-source* ~reader (^:once fn* [] ~@body))
     (do ~@body)))