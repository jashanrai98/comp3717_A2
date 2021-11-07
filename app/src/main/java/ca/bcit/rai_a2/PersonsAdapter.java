package ca.bcit.rai_a2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PersonsAdapter extends RecyclerView.Adapter<PersonsAdapter.ViewHolder> {
    private List<Post> mData;

    public PersonsAdapter(List<Post> data) {
        this.mData = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.Date.setText(mData.get(position).getReported_Date());
        holder.HA.setText(mData.get(position).getHA());
        holder.Sex.setText(mData.get(position).getSex());
        holder.Age.setText(mData.get(position).getAge_Group());
        holder.Class.setText(mData.get(position).getClassification_Reported());
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView Date;
        TextView HA;
        TextView Sex;
        TextView Age;
        TextView Class;

        public ViewHolder(View itemView) {
            super(itemView);
            Date = itemView.findViewById(R.id.date);
            HA = itemView.findViewById(R.id.ha);
            Sex = itemView.findViewById(R.id.sex);
            Age = itemView.findViewById(R.id.age);
            Class = itemView.findViewById(R.id.classification);
        }
    }
}
