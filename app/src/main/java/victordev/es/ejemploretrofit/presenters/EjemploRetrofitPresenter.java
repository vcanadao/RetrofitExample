package victordev.es.ejemploretrofit.presenters;

import java.io.IOException;
import java.util.List;

import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import victordev.es.ejemploretrofit.interfaces.EjemploRetrofitPresenterInterface;
import victordev.es.ejemploretrofit.interfaces.EjemploRetrofitViewInterface;
import victordev.es.ejemploretrofit.io.API.ApiRest;
import victordev.es.ejemploretrofit.io.API.models.Posts;

/**
 * Created by victor on 18/9/16.
 */

public class EjemploRetrofitPresenter implements EjemploRetrofitPresenterInterface{
    EjemploRetrofitViewInterface mView;

    public EjemploRetrofitPresenter(EjemploRetrofitViewInterface mView) {
        this.mView = mView;
    }

    @Override
    public void loadPosts() {
        mView.showLoadingWindow();



        //Hacemos el objeto tipo llamada
        final Call<List<Posts>> responseCall = ApiRest.getsCommentsApiInterface().loadComments();

        //Hacemos la llamada asíncrona. En este caso declaré el callback dentro
        //del mismo método. Podríamos haber creado una clase aparte
        //o implementar la interfaz en esta misma clase.

        responseCall.enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                mView.hideLoadingWindow();
                mView.loadAdapter(response.body());
            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {
                mView.hideLoadingWindow();
                mView.showErrorMessage(t.getMessage());
            }
        });
    }
}
