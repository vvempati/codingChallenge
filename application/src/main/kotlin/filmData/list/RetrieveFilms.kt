package filmData.list

import io.vertx.core.json.JsonArray
import io.vertx.core.json.JsonObject
import jdk.nashorn.internal.objects.NativeArray.forEach
import java.util.*
import kotlin.collections.List

/**
 * Created by vvempati on 3/21/2017.
 */
class RetrieveFilms {
    //searches for a film POJO in the film data store and returns it
    fun view(filmID: String): filmsStore.filmObject {
        //val film:Int = 3
        val films = filmsStore().transformJSONObjectToPOJO()
        val emptyFilm: filmsStore.filmObject = filmsStore.filmObject(1, "empty", "nothing", "none", 1, 8)
        for (film in films) {
            if (film.id == filmID.toInt()) {
                return film
            }
        }
        return emptyFilm
        //return film // iterate through listOfFilmObjects and get the correct film
    }
}