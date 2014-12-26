package io.tizo.flash.server

import akka.http.model.HttpMethods._
import akka.http.model._

/**
 * Created by tiiizhou on 12/24/14.
 */
class RequestHandler {

  //This is only for proof of concept, will keep track of akka http for updating with routing dsl.
  val requestHandler: HttpRequest => HttpResponse = {
    case HttpRequest(GET, Uri.Path("/"), _, _, _) => {
      HttpResponse(
        entity = HttpEntity(MediaTypes.`text/html`,
          "<html><body>Hello World</body></html>"))
    }
    case HttpRequest(GET, Uri.Path("/ping"), _, _, _) => {
      HttpResponse(entity = "pong")
    }
    case HttpRequest(GET, Uri.Path("/crash"), _, _, _) => {
      sys.error("Crashed!")
    }
    case _ => HttpResponse(404, entity = "Unknown Resources")
  }

}
