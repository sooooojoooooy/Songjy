package com.songjy.introduction.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.songjy.introduction.App;
import com.songjy.introduction.R;
import com.songjy.introduction.entity.douban.SubjectsBean;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

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
        if (viewType == 0) {
            View v = layoutInflater.inflate(R.layout.item_movie, parent, false);
            return new ItemViewHolder(v);
        } else {
            View v = layoutInflater.inflate(R.layout.item_footer, parent, false);
            return new FootViewHolder(v);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        holder.setIsRecyclable(false);
        int itemType = holder.getItemViewType();
        switch (itemType) {
            case TYPE_ITEM:
                ((ItemViewHolder) holder).bind(list.get(position));
                break;
            case TYPE_FOOTER:
                FootViewHolder viewHolder = (FootViewHolder) holder;
                if (position == 0) {//如果第一个就是脚布局,,那就让他隐藏
                    viewHolder.llyLoading.setVisibility(View.GONE);
                    return;
                }
                viewHolder.bind(footer_state);
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
                break;
        }
    }

    @Override
    public int getItemCount() {
        return list.size() + 1;
    }

    /**
     * 改变脚布局的状态的方法,在activity根据请求数据的状态来改变这个状态
     *
     * @param state
     */
    public void changeState(int state) {
        this.footer_state = state;
    }

    static class ItemViewHolder extends BaseViewHolder<SubjectsBean> {
        @BindView(R.id.iv_movie)
        ImageView ivMovie;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_year)
        TextView tvYear;
        @BindView(R.id.tv_average)
        TextView tvAverage;
        @BindView(R.id.tv_genres)
        TextView tvGenres;
        @BindView(R.id.iv_director)
        ImageView ivDirector;
        @BindView(R.id.tv_director)
        TextView tvDirector;
        @BindView(R.id.iv_cast)
        ImageView ivCast;
        @BindView(R.id.tv_cast)
        TextView tvCast;
        @BindView(R.id.iv_cast2)
        ImageView ivCast2;
        @BindView(R.id.tv_cast2)
        TextView tvCast2;

        ItemViewHolder(View view) {
            super(view);
        }

        @Override
        protected void bind(SubjectsBean item) {
            tvTitle.setText(item.getTitle());
            tvAverage.setText(String.format("评分:%s",
                    item.getRating().getAverage()));
            tvYear.setText(String.format("年份:%s",
                    item.getYear()));
            tvDirector.setText(String.format("导演:%s",
                    item.getDirectors().get(0).getName()));
            tvCast.setText(String.format("主演:%s",
                    item.getCasts().get(0).getName()));
            tvCast2.setText(String.format("主演:%s",
                    item.getCasts().get(1).getName()));
            StringBuffer sb = new StringBuffer();
            for (String i : item.getGenres()) {
                sb.append(i);
                sb.append(" ");
            }
            tvGenres.setText(String.format("题材:%s",
                    sb.toString()));
            String id = item.getId();
            setImage(item.getImages().getLarge(), ivMovie, id);
            setImage(item.getDirectors().get(0).getAvatars()
                    .getLarge(), ivDirector, id);
            setImage(item.getCasts().get(0).getAvatars()
                    .getLarge(), ivCast, id);
            setImage(item.getCasts().get(1).getAvatars()
                    .getLarge(), ivCast2, id);
        }

        private void setImage(String url, ImageView iv, String id) {
            if (iv.getTag() == null || !iv.getTag().equals(id)) {
                ImageLoader.getInstance().displayImage(url, iv, App.getOption());
                iv.setTag(id);
            }
        }
    }

    static class FootViewHolder extends BaseViewHolder<Integer> {
        @BindView(R.id.tv_loading)
        TextView tvLoading;
        @BindView(R.id.loading)
        AVLoadingIndicatorView loading;
        @BindView(R.id.lly_loading)
        LinearLayout llyLoading;

        FootViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        @Override
        protected void bind(Integer fs) {

        }
    }
}
