package victordev.es.ejemploretrofit.io.API.interfaces;


import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import victordev.es.ejemploretrofit.io.API.models.Posts;

/**
 * Created by victor on 18/9/16.
 */
public interface CommentsApiInterface {
    public static String COMMENTS_RQUEST = "/comments";

    //TODO Etiqueta @Headers si hicieran falta parámetros en la cabecera de la petición.

    @GET(COMMENTS_RQUEST)
    void loadComments(Callback<List<Posts>> callback);


}
