package victordev.es.ejemploretrofit.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import victordev.es.ejemploretrofit.R;
import victordev.es.ejemploretrofit.io.API.models.Posts;

/**
 * Created by victor on 18/9/16.
 */

public class EjemploRetrofitAdapter extends RecyclerView.Adapter<EjemploRetrofitAdapter.ViewHolder> {
    private List<Posts> mPostList;
    private Context mContext;


    public EjemploRetrofitAdapter(List<Posts> mPostList, Context mContext) {
        this.mPostList = mPostList;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Posts currentPost = mPostList.get(position);

        holder.mID.setText(String.valueOf(currentPost.getId()));
        holder.mName.setText(currentPost.getName().length() == 0 ? "EMPTY" : currentPost.getName());
        holder.mBody.setText(currentPost.getBody());
        holder.mEmail.setText(currentPost.getEmail());
    }

    @Override
    public int getItemCount() {
        return mPostList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView mID;
        public TextView mName;
        public TextView mEmail;
        public TextView mBody;

        public ViewHolder(View itemView) {
            super(itemView);
            mID = (TextView) itemView.findViewById(R.id.post_id);
            mName = (TextView) itemView.findViewById(R.id.post_name);
            mEmail = (TextView) itemView.findViewById(R.id.post_email);
            mBody = (TextView) itemView.findViewById(R.id.post_body);

            mBody.setVerticalScrollBarEnabled(true);

            mBody.setMovementMethod(new ScrollingMovementMethod());
            mBody.setOnTouchListener(new View.OnTouchListener() {

                public boolean onTouch(View v, MotionEvent event) {
                    // Disallow the touch request for parent scroll on touch of child view
                    v.getParent().requestDisallowInterceptTouchEvent(true);
                    return false;
                }
            });
        }
    }
}
