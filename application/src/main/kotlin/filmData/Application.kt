package filmData
import filmData.list.*
import io.vertx.core.AbstractVerticle
import io.vertx.core.Future
import io.vertx.core.Vertx
import io.vertx.ext.web.handler.*
import io.vertx.core.json.Json
import io.vertx.ext.web.Router
import io.vertx.ext.web.RoutingContext
/**
 * Created by vvempati on 3/21/2017.
 */

class Application : AbstractVerticle(){
    // get a router instance
    // configures port for application start page
    // starts application if successful
    // else logs failure
    // configures application routes

    //val router = configurePort()
    //routesHandler(router)
    override fun start(startFuture: Future<Void>) {
        //val server = vertx.createHttpServer()
       val router = Router.router(vertx)
         // call route handling method
        vertx.createHttpServer().requestHandler{router.accept(it)}
                .listen(
                        config().getInteger("http.port",8081),{ result-> if (result.succeeded())
                {
                    startFuture.complete()
                }
                else
                {
                    println(result.cause())
                } } )

        routesHandler(router)
    }
}
        //get application homepage


private fun configurePort():Router
{
    val vertx = Vertx.vertx()
    val server = vertx.createHttpServer()
    val port = 8081
    val router = Router.router(vertx)
    server.requestHandler{(router.accept(it))}
            .listen(port){if (it.succeeded())
                {
                    //startFuture.complete()
                    println("Server listening at $port")
                }
                else
                {
                    //startFuture.fail(it.cause())
                    println(it.cause())
                } }
    return router

}
//creates routes for getting films and showing film ratings
private fun routesHandler(router:Router )
{
    router.route("/").handler({routingContext->
        val response = routingContext.response()
        response
                .putHeader("content-type", "text/html")
                .end("<h1>Homepage</h1>")
    })
    //list films
    router.route("/films").handler(::listAll)
    //get film resource
    router.get("/films/:id").handler(::view)
    //post show film rating
    router.route("/rating/:id").handler(BodyHandler.create())
    router.post("/rating/:id").handler(::rate)
}
// handles film ratings
private fun rate(routingContext: RoutingContext){
    val request = routingContext.request()
    val json = routingContext.bodyAsJson
    print("body as json  ${json}")
    val id: String = request.getParam("id")
    val ratingName:String = "Rating"
    val rating:String = json.getString(ratingName)
    routingContext.response()
            .putHeader("content-type","application/json; charset=utf-8")
            .end(Json.encodePrettily(mapOf(
                    "message" to mapOf(
                            "success" to true
                    ),
                    "rating" to filmData.list.RateFilms().rate(rating,id)
            )))
}
//handles request to show a single film's metadata
private fun view(routingContext: RoutingContext){
    val request = routingContext.request()
    val id:String = request.getParam("id")
    routingContext.response()
            .putHeader("content-type","application/json; charset=utf-8")
            .end(Json.encodePrettily(mapOf(
                    "message" to mapOf(
                            "success" to true
                    ),
                    "film" to filmData.list.RetrieveFilms().view(id)
            )))

}
//handle a request to show all films' metadata
private fun listAll(routingContext: RoutingContext){
    routingContext.response()
            .putHeader("content-type","application/json; charset=utf-8")
            .end(Json.encodePrettily(mapOf(
                  "message" to mapOf(
                          "success" to true
                  ),
                    "list" to filmData.list.filmsStore().transformJSONObjectToPOJO()
                    // transformJSONObjectToPOJO is a mocking of the
            )))

}