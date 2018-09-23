package codeone.com.br.mobile_gym_pass.features.company.service

import codeone.com.br.mobile_gym_pass.commons.constant.WebService
import codeone.com.br.mobile_gym_pass.commons.domain.Geocode
import codeone.com.br.mobile_gym_pass.commons.util.checkForErros
import codeone.com.br.mobile_gym_pass.commons.util.createRetrofitService
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
import java.lang.Exception

class MapsService {
    interface RetrofitMapsService{
        @GET("json")
        fun getGeocodeLocation(
                @Query("address")
                address:String,
                @Query("key")
                key:String): Call<Geocode>
    }
    companion object Factory {
        @Throws
        fun getGeocodeLocation(address: String, key: String? = null):Geocode{
            val service = createRetrofitService<RetrofitMapsService>(WebService.BASE_URL)
            val execute = service.getGeocodeLocation(address,WebService.API_KEY).execute()
            val responseVO = execute.body()
            responseVO?.let {
                return it
            }
            throw Exception("Houve um erro")
        }
    }
}