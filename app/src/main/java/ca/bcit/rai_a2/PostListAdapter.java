package ca.bcit.rai_a2;

import android.app.Activity;
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PostListAdapter extends ArrayAdapter<Post> {
    private Activity context;
    private List<Post> postList;

    public PostListAdapter(Activity context, List<Post> postList) {
        super(context, R.layout.list_layout, postList);
        this.context = context;
        this.postList = postList;
    }

    public PostListAdapter(Context context, int resource, List<Post> objects, Activity context1, List<Post> postList) {
        super(context, resource, objects);
        this.context = context1;
        this.postList = postList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.activity_gender, null, true);


        TextView tvSexM = listViewItem.findViewById(R.id.maleCountValue);
        TextView tvSexF = listViewItem.findViewById(R.id.femaleCountValue);
        TextView tvSexU = listViewItem.findViewById(R.id.unknownCountValue);


        Post post = postList.get(position);
        int femaleCount = 0;
        int maleCount = 0;
        int unknownCount = 0;
        if (post.getSex().equals("M")){
            maleCount++;
        } else if (post.getSex().equals("F")){
            femaleCount++;
        } else {
            unknownCount++;
        }

            tvSexM.setText(Integer.toString(maleCount));
            tvSexF.setText(Integer.toString(femaleCount));
            tvSexU.setText(Integer.toString(unknownCount));



        return listViewItem;
    }

}

