package com.example.forbesandroid.adapter;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.forbesandroid.R;
import com.example.forbesandroid.model.Person;

import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<Person> people;
    private final LayoutInflater inflater;

    public PersonAdapter(List<Person> people, LayoutInflater inflater) {
        this.people = people;
        this.inflater = inflater;
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView iv_flag;
        private TextView tv_name;
        private TextView tv_netWorth;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String name = tv_name.getText().toString();
                    String url = "https://www.google.ru/search?q=" + name.replace(" ", "+");
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    v.getContext().startActivity(intent);
                }
            });
            iv_flag = itemView.findViewById(R.id.iv_flag);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_netWorth = itemView.findViewById(R.id.tv_net_worth);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.person_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Person person = people.get(position);
        ((MyViewHolder)holder).iv_flag.setImageResource(person.getFlag());
        ((MyViewHolder)holder).tv_name.setText(person.getName());
        ((MyViewHolder)holder).tv_netWorth.setText(person.getNetWorth());
    }

    @Override
    public int getItemCount() {
        return people.size();
    }
}
