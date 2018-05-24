package me.morasquad.ideamart_subcription.API;


import me.morasquad.ideamart_subcription.Models.Request;
import me.morasquad.ideamart_subcription.Models.Result;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Sandun Isuru Niraj on 23/05/2018.
 */

public interface APIService {



    @POST("send")
    Call<Result> sendRequest(
            @Body Request request

            );


}
