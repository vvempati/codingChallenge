package filmData
import filmData.list.*
import io.vertx.core.AbstractVerticle
import io.vertx.core.Future
import io.vertx.core.eventbus.EventBus
import io.vertx.core.json.Json
import io.vertx.ext.web.Router
import io.vertx.ext.web.RoutingContext
/**
 * Created by vvempati on 3/21/2017.
 */
class Application : AbstractVerticle(){
    val eventBus: EventBus by lazy { vertx.eventBus() }
    override fun start(startFuture: Future<Void>) {
        val router:Router = Router.router(vertx)
        router.route("/").handler({routingContext->
            val response = routingContext.response()
            response
                    .putHeader("content-type", "text/html")
                    .end("<h1>Hello from my first Vert.x 3 application</h1>")
        })
        vertx.createHttpServer().requestHandler{router.accept(it)}
                .listen(
                        config().getInteger("http.port",8081),{ result-> if (result.succeeded())
                {
                    startFuture.complete()
                }
                else
                {
                    startFuture.fail(result.cause())
                } }
                )

        router.route("/listAllFilms").handler(::listAll)
        router.route("/view/:id").handler(::view)
        router.route("/rate/:id").handler(::rate)
    }

}
private fun rate(routingContext: RoutingContext){
    val request = routingContext.request()
    val id:String = request.getParam("id")
    val json = routingContext.bodyAsJson
    val rating = json.getJsonObject("Rating")
    routingContext.response()
            .putHeader("content-type","application/json; charset=utf-8")
            .end(Json.encodePrettily(mapOf(
                    "message" to mapOf(
                            "success" to true
                    ),
                    "rating" to filmData.list.rate(rating)
            )))
}
private fun view(routingContext: RoutingContext){
    val request = routingContext.request()
    val id:String = request.getParam("id")
    routingContext.response()
            .putHeader("content-type","application/json; charset=utf-8")
            .end(Json.encodePrettily(mapOf(
                    "message" to mapOf(
                            "success" to true
                    ),
                    "film" to filmData.list.view(id)
            )))

}
private fun listAll(routingContext: RoutingContext){
    val json = """
{
  "films": [
    {
      "id": 1,
      "title": "A Wonderful Film",
      "description": "A cute film about lots of wonderful stuff.",
      "url_slug": "a_wonderful_film",
      "year": 1973,
      "related_film_ids": [2, 4, 7]
    },
    {
      "id": 2,
      "title": "All About Fandor",
      "description": "Documentary telling the tail of Fandor.",
      "url_slug": "all_about_fandor",
      "year": 2001,
      "related_film_ids": [1, 4, 7]
    },
    {
      "id": 3,
      "title": "Dancing with Elephants",
      "description": "The classic tale of Dancing with Wolves, but with elephants!",
      "url_slug": "dancing_with_elephants",
      "year": 2016,
      "related_film_ids": []
    },
    {
      "id": 4,
      "title": "The Story of George",
      "description": "A true story outlining the adventures of George",
      "url_slug": "the_story_of_george",
      "year": 1974,
      "related_film_ids": [1, 2, 7]
    },
    {
      "id": 5,
      "title": "Zee and Bee Go Skiiing",
      "description": "The tragic story of Zee and Bee on their snowy adventures.",
      "url_slug": "zee_and_bee_go_skiing",
      "year": 1991,
      "related_film_ids": [6, 8, 9, 10]
    },
    {
      "id": 6,
      "title": "Ahead of Its Time",
      "description": "A story about the future.",
      "url_slug": "ahead_of_its_time",
      "year": 2088,
      "related_film_ids": [8, 9, 10]
    },
    {
      "id": 7,
      "title": "My Name is Jerry",
      "description": "The life of the cat named Jerry.",
      "url_slug": "my_name_is_jerry",
      "year": 1989,
      "related_film_ids": [1, 2, 4]
    },
    {
      "id": 8,
      "title": "Gems and Trestle",
      "description": "Is it about web development? Mining history? You'll never know.",
      "url_slug": "gems_and_trestle",
      "year": 2011,
      "related_film_ids": [9, 10]
    },
    {
      "id": 9,
      "title": "How To React Natively",
      "description": "A step by step journey through developing a React Native application.",
      "url_slug": "how_to_react_natively",
      "year": 2000,
      "related_film_ids": [10]
    },
    {
      "id": 10,
      "title": "Perry Hotter: A Lizard's Tale",
      "description": "It's a story all about a lizard named Perry.",
      "url_slug": "perry_hotter_a_lizards_tale",
      "year": 2017,
      "related_film_ids": []
    }
  ]
}
    """
    routingContext.response()
            .putHeader("content-type","application/json; charset=utf-8")
            .end(Json.encodePrettily(mapOf(
                  "message" to mapOf(
                          "success" to true
                  ),
                    "list" to transformJSONObjectToPOJO(json)
                    // transformJSONObjectToPOJO is a mocking of the
            )))

}