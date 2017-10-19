package com.songjy.introduction.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.songjy.introduction.R;
import com.songjy.introduction.entity.douban.SubjectsBean;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.List;

/**
 * Created by songjiyuan
 * on 17/10/18 # 下午5:26.
 */

public class MovieMsgAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<SubjectsBean> list;
    private Context context;
    private LayoutInflater layoutInflater;
    private final int TYPE_ITEM = 0;
    private final int TYPE_FOOTER = 1;
    //正在加载更多
    static final int LOADING_MORE = 1;
    //没有更多
    static final int NO_MORE = 2;
    //脚布局当前的状态,默认为没有更多
    int footer_state = 1;

    public MovieMsgAdapter(Context context, List<SubjectsBean> list) {
        this.list = list;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemViewType(int position) {
        // 最后一个item设置为footerView
        if (position + 1 == getItemCount()) {
            return TYPE_FOOTER;
        } else {
            return TYPE_ITEM;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = null;
        RecyclerView.ViewHolder viewHolder;
        if (viewType == 0) {
            v = layoutInflater.inflate(R.layout.item_movie, parent, false);
            viewHolder = new ItemViewHolder(v);
            return viewHolder;
        } else if (viewType == 1) {
            v = layoutInflater.inflate(R.layout.item_footer, parent, false);
            viewHolder = new FootViewHolder(v);
            return viewHolder;
        } else {
            return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder viewHolder = (ItemViewHolder) holder;
            viewHolder.mTv.setText(list.get(position).getTitle());
        } else if (holder instanceof FootViewHolder) {
            FootViewHolder viewHolder = (FootViewHolder) holder;
            if (position == 0) {//如果第一个就是脚布局,,那就让他隐藏
                viewHolder.llyLoading.setVisibility(View.GONE);
                return;
            }
            switch (footer_state) {
                case LOADING_MORE:
                    viewHolder.llyLoading.setVisibility(View.VISIBLE);
                    viewHolder.loading.setVisibility(View.VISIBLE);
                    viewHolder.tvLoading.setText(context.getString(R.string.list_loading));
                    break;
                case NO_MORE:
                    viewHolder.llyLoading.setVisibility(View.VISIBLE);
                    viewHolder.loading.setVisibility(View.GONE);
                    viewHolder.tvLoading.setText(context.getString(R.string.list_no_more));
                    break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return list.size() + 1;
    }

    /**
     * 改变脚布局的状态的方法,在activity根据请求数据的状态来改变这个状态
     * @param state
     */
    public void changeState(int state) {
        this.footer_state = state;
    }

    private static class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView mTv;

        ItemViewHolder(View itemView) {
            super(itemView);
            mTv = itemView.findViewById(R.id.tv);
        }
    }

    private static class FootViewHolder extends RecyclerView.ViewHolder {

        TextView tvLoading;
        AVLoadingIndicatorView loading;
        LinearLayout llyLoading;

        FootViewHolder(View itemView) {
            super(itemView);
            tvLoading = itemView.findViewById(R.id.tv_loading);
            loading = itemView.findViewById(R.id.loading);
            llyLoading = itemView.findViewById(R.id.lly_loading);
        }
    }

}
