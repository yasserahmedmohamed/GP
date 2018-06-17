package ourteam.gradproject.com.first_end_virsion_gp.GetNearestPlaces;

import retrofit2.Retrofit;

/**
 * Created by yasser ahmed on 6/14/2018.
 */

public class common {
    private static final String GOOGLE_URL_API="https://maps.googleapis.com/";
    public static IGoogleApiService getigooogleApiservice(){
        return RetrofitClient.getclient(GOOGLE_URL_API).create(IGoogleApiService.class);
    }
}
