package com.alenbeyond.moon.base.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by allen on 2017/4/11.
 */

public abstract class MoonBaseRecyclerViewAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    protected List<T> objectList;
    protected OnItemClickListener<T> onItemClickListener;
    protected final Context mContext;
    protected final LayoutInflater mLayoutInflater;

    public MoonBaseRecyclerViewAdapter(Context context) {
        this.mContext = context;
        this.mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.objectList = new ArrayList<>();
    }

    public void setOnItemClickListener(OnItemClickListener<T> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener<T> {
        void onObjectItemClicked(T t, int position);
    }

    public List<T> getObjectList() {
        return objectList;
    }

    public void clear() {
        if (objectList != null && objectList.size() > 0) {
            objectList.clear();
            this.notifyDataSetChanged();
        }
    }

    public void setObjectList(List<T> objectList) {
        this.validateUsersCollection(objectList);
        this.objectList.clear();
        this.objectList.addAll(objectList);
    }

    public void addData(List<T> objectList) {
        this.validateUsersCollection(objectList);
        this.objectList.addAll(objectList);
    }

    public void addDataToHead(List<T> objectList) {
        this.validateUsersCollection(objectList);
        this.objectList.addAll(0, objectList);//从起始插入
    }

    private void validateUsersCollection(Collection<T> collection) {
        if (collection == null) {
            throw new RuntimeException("must set data");
        }
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return doOnCreateViewHolder(parent, viewType);
    }

    protected abstract VH doOnCreateViewHolder(ViewGroup parent, int viewType);

    protected abstract void doOnBindViewHolder(VH holder, int position);

    @Override
    public void onBindViewHolder(VH holder, final int position) {
        doOnBindViewHolder(holder, position);
        final T t = objectList.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickListener != null) {
                    onItemClickListener.onObjectItemClicked(t, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return (this.objectList != null) ? this.objectList.size() : 0;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

}
