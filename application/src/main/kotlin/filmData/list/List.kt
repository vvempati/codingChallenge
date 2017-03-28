package filmData.list

import io.vertx.core.json.JsonArray
import io.vertx.core.json.JsonObject
import jdk.nashorn.internal.objects.NativeArray.forEach
import java.util.*
import kotlin.collections.List

/**
 * Created by vvempati on 3/21/2017.
 */
data class filmObject(var id: Int,val title:String, val description:String,
                      val url_slug:String, val year:Int, val related_film_ids:Any){
    var averageRating:Int ? = null
}
data class ratings(var id: Int, val description: String)
var ratingsStore:MutableList<ratings> = mutableListOf()
fun transformJSONObjectToPOJO( json: String ):List<filmObject>{
    val jsonObject:JsonObject = JsonObject(json)
    val JSONArray:JsonArray = jsonObject.getJsonArray("films")
    var listOfFilmObjects:List<filmObject> = emptyList()
    for(i in 0..(JSONArray.size() -1)) {// it's a JSONArray, might be able to use iterator, try to use java functions
        val film:JsonObject = JSONArray.getJsonObject(i)
        val ids = film.getValue("related_film_ids")
        val filmFromList:filmObject = filmObject(film.getInteger("id"),film.getString("title"),film.getString("description"),film.getString("url_slug"),
                film.getInteger("year"),ids)
        with(filmFromList){
            this.averageRating = film.getInteger("averageRating")
        }
        listOfFilmObjects += filmFromList
    }
    return listOfFilmObjects
}
fun view( filmID: String):String{
    val film:String = "A film Title"
    return film
}
fun rate(rating:JsonObject){
    val filmID = rating.getInteger("id")
    val review = rating.getString("rating")
    val rating:ratings = ratings(filmID,review)
    ratingsStore.add(rating)

}