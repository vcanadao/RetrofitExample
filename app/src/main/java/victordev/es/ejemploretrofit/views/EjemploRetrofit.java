package victordev.es.ejemploretrofit.views;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;
import victordev.es.ejemploretrofit.R;
import victordev.es.ejemploretrofit.adapters.EjemploRetrofitAdapter;
import victordev.es.ejemploretrofit.interfaces.EjemploRetrofitPresenterInterface;
import victordev.es.ejemploretrofit.interfaces.EjemploRetrofitViewInterface;
import victordev.es.ejemploretrofit.io.API.models.Posts;
import victordev.es.ejemploretrofit.presenters.EjemploRetrofitPresenter;

public class EjemploRetrofit extends AppCompatActivity implements EjemploRetrofitViewInterface{
    private EjemploRetrofitPresenterInterface mPresenter;
    private RecyclerView mRecyclerView;
    private ProgressDialog mProgressDialog;
    private EjemploRetrofitAdapter mAdapter;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejemplo_retrofit);

        mPresenter = new EjemploRetrofitPresenter(this);

        makeProgressDialog();
        configureRecyclerView();
        mButton = (Button) findViewById(R.id.bt_make_call);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.loadPosts();
            }
        });
    }

    private void makeProgressDialog() {
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mProgressDialog.setCancelable(false);
        mProgressDialog.setIndeterminate(true);
    }

    private void configureRecyclerView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

    }

    @Override
    public void loadAdapter(List<Posts> listPost) {
        mAdapter = new EjemploRetrofitAdapter(listPost, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void showLoadingWindow() {
        mProgressDialog.show();
    }

    @Override
    public void hideLoadingWindow() {
        mProgressDialog.hide();

    }

    @Override
    public void showErrorMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }
}
