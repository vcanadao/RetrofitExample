package victordev.es.ejemploretrofit.interfaces;

import java.util.List;

import victordev.es.ejemploretrofit.io.API.models.Posts;

/**
 * Created by victor on 18/9/16.
 */

public interface EjemploRetrofitViewInterface {
    void loadAdapter(List<Posts> listPost);
    void showLoadingWindow();
    void hideLoadingWindow();
    void showErrorMessage(String s);
}
