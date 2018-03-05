package filmData.list

/**
 * Created by vasavivempati on 3/4/18.
 */
class RateFilms {
    //stores rating of a film given id
    fun rate(rating:String, id:String):filmsStore.filmObject{
        //val filmID = rating.getInteger("id")
        //val review = rating.getString("rating")
        //val rating:ratings = ratings(filmID,review)
        val films = filmsStore().transformJSONObjectToPOJO()
        val emptyFilm:filmsStore.filmObject = filmsStore.filmObject(1,"empty","nothing","none",1,8)
        for(film in films)
        {
            if(film.id == id.toInt())
            {
                //print("this is the id: ${film.id}")
                if(film.averageRating != null)
                {
                    val intialRating = film.averageRating
                    film.averageRating =  intialRating?.plus(rating.toInt())
                }
                else
                {
                    film.averageRating = rating.toInt()
                }
                return film

            }
        }

        return emptyFilm
    }
}