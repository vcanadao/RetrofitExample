package victordev.es.ejemploretrofit.io.API;

import retrofit.RestAdapter;
import victordev.es.ejemploretrofit.io.API.interfaces.CommentsApiInterface;

/**
 * Created by victor on 18/9/16.
 */

public class ApiRest {
    public static String BASE_URL = "https://jsonplaceholder.typicode.com";
    private static CommentsApiInterface sCommentsApiInterface;

    /**
     * Singleton para crear la petición en base a nuestra interfaz CommentsApiInterface
     * @return
     */
    public static CommentsApiInterface getsCommentsApiInterface() {
        if (sCommentsApiInterface == null) {
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(BASE_URL)
                    .build();

            sCommentsApiInterface = restAdapter.create(CommentsApiInterface.class);
        }
        return sCommentsApiInterface;
    }
}
