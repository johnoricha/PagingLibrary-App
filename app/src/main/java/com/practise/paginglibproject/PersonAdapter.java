package com.practise.paginglibproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

public class PersonAdapter extends PagedListAdapter<Person, PersonAdapter.PersonViewHolder> {
    protected PersonAdapter(@NonNull DiffUtil.ItemCallback<Person> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public PersonAdapter.PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View itemView = LayoutInflater.from(context).inflate(R.layout.person_item, parent, false);
        return new PersonViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.PersonViewHolder holder, int position) {
        Person person = getItem(position);
        holder.personNameTextView.setText(person.getName());
    }

    public class PersonViewHolder extends RecyclerView.ViewHolder {
        private TextView personNameTextView;

        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);
            personNameTextView = itemView.findViewById(R.id.person_name);
        }
    }
}
