/**
 * Created by tiiizhou on 12/24/14.
 */
package io.tizo.flash.server

import akka.actor.ActorSystem
import akka.http.Http
import akka.stream.FlowMaterializer

class HttpServer(host: String, port: Int) {

  implicit val system = ActorSystem()
  implicit val materializer = FlowMaterializer()

  val serverBinding = Http(system).bind(interface = host, port = port)
  val requestHandler = new RequestHandler().requestHandler

  serverBinding.connections.foreach { connection =>
    println(s"Accepted new connection from ${connection.remoteAddress}")

    connection.handleWithSyncHandler(requestHandler)
  }

}
