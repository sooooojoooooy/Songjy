package com.songjy.introduction.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.songjy.introduction.R;
import com.songjy.introduction.common.WeatherTypeEnum;
import com.songjy.introduction.common.utils.LoaderUtil;
import com.songjy.introduction.common.utils.TimeUitl;
import com.songjy.introduction.common.utils.Util;
import com.songjy.introduction.entity.weather.HeWeather5Bean;
import com.songjy.introduction.entity.weather.WeatherEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WeatherAdapter extends AnimRecyclerViewAdapter<RecyclerView.ViewHolder> {
    private static String TAG = WeatherAdapter.class.getSimpleName();

    private Context mContext;

    private static final int TYPE_ONE = 0;
    private static final int TYPE_TWO = 1;
    private static final int TYPE_THREE = 2;
    private static final int TYPE_FORE = 3;

    private HeWeather5Bean mWeatherData;

    public WeatherAdapter(List<HeWeather5Bean> heWeather5Bean) {
        this.mWeatherData = heWeather5Bean.get(0);
    }

    @Override
    public int getItemViewType(int position) {
        if (position == WeatherAdapter.TYPE_ONE) {
            return WeatherAdapter.TYPE_ONE;
        }
        if (position == WeatherAdapter.TYPE_TWO) {
            return WeatherAdapter.TYPE_TWO;
        }
        if (position == WeatherAdapter.TYPE_THREE) {
            return WeatherAdapter.TYPE_THREE;
        }
        if (position == WeatherAdapter.TYPE_FORE) {
            return WeatherAdapter.TYPE_FORE;
        }
        return super.getItemViewType(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        switch (viewType) {
            case TYPE_ONE:
                return new NowWeatherViewHolder(
                        LayoutInflater.from(mContext).inflate(R.layout.item_temperature, parent, false));
            case TYPE_TWO:
                return new HoursWeatherViewHolder(
                        LayoutInflater.from(mContext).inflate(R.layout.item_hour_info, parent, false));
            case TYPE_THREE:
                return new SuggestionViewHolder(
                        LayoutInflater.from(mContext).inflate(R.layout.item_suggestion, parent, false));
            case TYPE_FORE:
                return new ForecastViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_forecast, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int itemType = getItemViewType(position);
        switch (itemType) {
            case TYPE_ONE:
                ((NowWeatherViewHolder) holder).bind(mWeatherData);
                break;
            case TYPE_TWO:
                ((HoursWeatherViewHolder) holder).bind(mWeatherData);
                break;
            case TYPE_THREE:
                ((SuggestionViewHolder) holder).bind(mWeatherData);
                break;
            case TYPE_FORE:
                ((ForecastViewHolder) holder).bind(mWeatherData);
                break;
            default:
                break;
        }
        showItemAnim(holder.itemView, position);
    }

    @Override
    public int getItemCount() {
        return mWeatherData.getStatus() != null ? 4 : 0;
    }

    /**
     * 当前天气情况
     */
    class NowWeatherViewHolder extends BaseViewHolder<HeWeather5Bean> {

        @BindView(R.id.weather_icon)
        ImageView weatherIcon;
        @BindView(R.id.temp_flu)
        TextView tempFlu;
        @BindView(R.id.temp_max)
        TextView tempMax;
        @BindView(R.id.temp_min)
        TextView tempMin;
        @BindView(R.id.temp_pm)
        TextView tempPm;
        @BindView(R.id.temp_quality)
        TextView tempQuality;

        NowWeatherViewHolder(View itemView) {
            super(itemView);
        }

        protected void bind(HeWeather5Bean weather) {
            try {
                tempFlu.setText(String.format("%s℃", weather.getNow().getTmp()));
                tempMax.setText(
                        String.format("↑ %s ℃", weather.getDaily_forecast().get(0).getTmp().getMax()));
                tempMin.setText(
                        String.format("↓ %s ℃", weather.getDaily_forecast().get(0).getTmp().getMin()));
                if (weather.getAqi() != null) {
                    tempPm.setText(String.format("PM2.5: %s μg/m³",
                            Util.safeText(weather.getAqi().getCity().getPm25())));
                    tempQuality.setText(String.format("AQI：%s",
                            Util.safeText(weather.getAqi().getCity().getQlty())));
                }
                LoaderUtil.load(itemView.getContext(),
                        WeatherTypeEnum.getResId(weather.getNow().getCond().getCode()),
                        weatherIcon);
            } catch (Exception e) {
                Log.e(TAG, e.toString());
            }
        }
    }

    /**
     * 当日小时预告
     */
    private class HoursWeatherViewHolder extends BaseViewHolder<HeWeather5Bean> {
        private LinearLayout itemHourInfoLayout;
        private TextView[] mClock = new TextView[mWeatherData.getHourly_forecast().size()];
        private TextView[] mTemp = new TextView[mWeatherData.getHourly_forecast().size()];
        private TextView[] mHumidity = new TextView[mWeatherData.getHourly_forecast().size()];
        private TextView[] mWind = new TextView[mWeatherData.getHourly_forecast().size()];

        HoursWeatherViewHolder(View itemView) {
            super(itemView);
            itemHourInfoLayout = itemView.findViewById(R.id.item_hour_info_linearlayout);

            for (int i = 0; i < mWeatherData.getHourly_forecast().size(); i++) {
                View view = View.inflate(mContext, R.layout.item_hour_info_line, null);
                mClock[i] = view.findViewById(R.id.one_clock);
                mTemp[i] = view.findViewById(R.id.one_temp);
                mHumidity[i] = view.findViewById(R.id.one_humidity);
                mWind[i] = view.findViewById(R.id.one_wind);
                itemHourInfoLayout.addView(view);
            }
        }

        protected void bind(HeWeather5Bean weather) {

            try {
                for (int i = 0; i < weather.getHourly_forecast().size(); i++) {
                    //s.subString(s.length-3,s.length);
                    //第一个参数是开始截取的位置，第二个是结束位置。
                    String mDate = weather.getHourly_forecast().get(i).getDate();
                    mClock[i].setText(
                            mDate.substring(mDate.length() - 5, mDate.length()));
                    mTemp[i].setText(
                            String.format("%s℃", weather.getHourly_forecast().get(i).getTmp()));
                    mHumidity[i].setText(
                            String.format("%s%%", weather.getHourly_forecast().get(i).getHum())
                    );
                    mWind[i].setText(
                            String.format("%s km/h", weather.getHourly_forecast().get(i).getWind().getSpd())
                    );
                }
            } catch (Exception e) {
                Log.e(TAG, e.toString());
            }
        }
    }

    /**
     * 当日建议
     */
    class SuggestionViewHolder extends BaseViewHolder<HeWeather5Bean> {
        @BindView(R.id.cloth_brief)
        TextView clothBrief;
        @BindView(R.id.cloth_txt)
        TextView clothTxt;
        @BindView(R.id.sport_brief)
        TextView sportBrief;
        @BindView(R.id.sport_txt)
        TextView sportTxt;
        @BindView(R.id.travel_brief)
        TextView travelBrief;
        @BindView(R.id.travel_txt)
        TextView travelTxt;
        @BindView(R.id.flu_brief)
        TextView fluBrief;
        @BindView(R.id.flu_txt)
        TextView fluTxt;

        SuggestionViewHolder(View itemView) {
            super(itemView);
        }

        protected void bind(HeWeather5Bean weather) {
            try {
                clothBrief.setText(String.format("穿衣指数---%s", weather.getSuggestion().getDrsg().getBrf()));
                clothTxt.setText(weather.getSuggestion().getDrsg().getTxt());

                sportBrief.setText(String.format("运动指数---%s", weather.getSuggestion().getSport().getBrf()));
                sportTxt.setText(weather.getSuggestion().getSport().getTxt());

                travelBrief.setText(String.format("旅游指数---%s", weather.getSuggestion().getTrav().getBrf()));
                travelTxt.setText(weather.getSuggestion().getTrav().getTxt());

                fluBrief.setText(String.format("感冒指数---%s", weather.getSuggestion().getFlu().getBrf()));
                fluTxt.setText(weather.getSuggestion().getFlu().getTxt());
            } catch (Exception e) {
                Log.e(TAG, e.toString());
            }
        }
    }

    /**
     * 未来天气
     */
    class ForecastViewHolder extends BaseViewHolder<HeWeather5Bean> {
        private LinearLayout forecastLinear;
        private TextView[] forecastDate = new TextView[mWeatherData.getDaily_forecast().size()];
        private TextView[] forecastTemp = new TextView[mWeatherData.getDaily_forecast().size()];
        private TextView[] forecastTxt = new TextView[mWeatherData.getDaily_forecast().size()];
        private ImageView[] forecastIcon = new ImageView[mWeatherData.getDaily_forecast().size()];

        ForecastViewHolder(View itemView) {
            super(itemView);
            forecastLinear = itemView.findViewById(R.id.forecast_linear);
            for (int i = 0; i < mWeatherData.getDaily_forecast().size(); i++) {
                View view = View.inflate(mContext, R.layout.item_forecast_line, null);
                forecastDate[i] = view.findViewById(R.id.forecast_date);
                forecastTemp[i] = view.findViewById(R.id.forecast_temp);
                forecastTxt[i] = view.findViewById(R.id.forecast_txt);
                forecastIcon[i] = view.findViewById(R.id.forecast_icon);
                forecastLinear.addView(view);
            }
        }

        protected void bind(HeWeather5Bean weather) {
            try {
                forecastDate[0].setText(mContext.getString(R.string.weather_today));
                forecastDate[1].setText(mContext.getString(R.string.weather_tomorrow));
                for (int i = 0; i < weather.getDaily_forecast().size(); i++) {
                    if (i > 1) {
                        try {
                            forecastDate[i].setText(
                                    TimeUitl.dayForWeek(weather.getDaily_forecast().get(i).getDate(), mContext));
                        } catch (Exception e) {
                            Log.e(TAG, e.toString());
                        }
                    }
                    LoaderUtil.load(mContext,
                            WeatherTypeEnum.getResId(weather.getDaily_forecast().get(i).getCond().getCode_d()),
                            forecastIcon[i]);
                    forecastTemp[i].setText(
                            String.format("%s℃ - %s℃",
                                    weather.getDaily_forecast().get(i).getTmp().getMin(),
                                    weather.getDaily_forecast().get(i).getTmp().getMax()));
                    forecastTxt[i].setText(
                            String.format("%s。 %s  %s  %s km/h。 降雨率 %s%%",
                                    weather.getDaily_forecast().get(i).getCond().getTxt_d(),
                                    weather.getDaily_forecast().get(i).getWind().getSc(),
                                    weather.getDaily_forecast().get(i).getWind().getDir(),
                                    weather.getDaily_forecast().get(i).getWind().getSpd(),
                                    weather.getDaily_forecast().get(i).getPop()));
                }
            } catch (Exception e) {
                Log.e(TAG, e.toString());
            }
        }
    }
}
