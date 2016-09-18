package victordev.es.ejemploretrofit.io.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import victordev.es.ejemploretrofit.io.API.interfaces.CommentsApiInterface;
import victordev.es.ejemploretrofit.io.API.models.Posts;

/**
 * Created by victor on 18/9/16.
 */

public class ApiRest {
    //EN RETROFIT 2.0 LA URL DEBE ACABAR CON /
    public static String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private static CommentsApiInterface sCommentsApiInterface;

    /**
     * Singleton para crear la petición en base a nuestra interfaz CommentsApiInterface
     * @return
     */
    public static CommentsApiInterface getsCommentsApiInterface() {

        if (sCommentsApiInterface == null) {
            //Declaramos nuestro objeto Retrofit y le indicamos el endpoint
            //y con que vamos a hacer el parse de la información finalizamos con build

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            //Declaramos la interfaz y dejamos que retrofit la instancie
            CommentsApiInterface commentsApiInterface = retrofit.create(CommentsApiInterface.class);

            sCommentsApiInterface = commentsApiInterface;
        }
        return sCommentsApiInterface;
    }
}
