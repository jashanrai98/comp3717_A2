package ca.bcit.rai_a2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private List<Post> mData;

    public Adapter(List<Post> data) {
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
        holder.Gender.setText(mData.get(position).getSex());
        holder.Age.setText(mData.get(position).getAge_Group());
        holder.HA.setText(mData.get(position).getHA());
        holder.Class.setText(mData.get(position).getClassification_Reported());
        holder.Date.setText(mData.get(position).getReported_Date());
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView Age;
        TextView Gender;
        TextView HA;
        TextView Class;
        TextView Date;

        public ViewHolder(View itemView) {
            super(itemView);
            Age = itemView.findViewById(R.id.age);
            Gender = itemView.findViewById(R.id.sex);
            HA = itemView.findViewById(R.id.ha);
            Class = itemView.findViewById(R.id.classification);
            Date = itemView.findViewById(R.id.date);
        }
    }
}
