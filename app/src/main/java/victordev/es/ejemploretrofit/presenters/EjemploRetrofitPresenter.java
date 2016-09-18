package victordev.es.ejemploretrofit.presenters;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
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

        ApiRest.getsCommentsApiInterface().loadComments(new Callback<List<Posts>>() {
            @Override
            public void success(List<Posts> postses, Response response) {
                mView.hideLoadingWindow();
                mView.loadAdapter(postses);
            }

            @Override
            public void failure(RetrofitError error) {
                mView.hideLoadingWindow();
                mView.showErrorMessage(error.toString());
            }
        });
    }
}
