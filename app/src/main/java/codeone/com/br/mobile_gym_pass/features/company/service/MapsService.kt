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
            var aux = address.split("-|,|\\s+".toRegex())
            var aux1 = arrayListOf<String>()
            var newAddr = ""
            aux.forEach {
                if(!it.isEmpty()){
                    aux1.add(it)
                }
            }

            aux1.forEach {
                newAddr += it + "+"
            }

            val service = createRetrofitService<RetrofitMapsService>(WebService.GEOCODE_URL)
            val execute = service.getGeocodeLocation(newAddr,WebService.API_KEY).execute()
            val responseVO = execute.body()
            responseVO?.let {
                return it
            }
            throw Throwable("Houve um erro")
        }
    }
}