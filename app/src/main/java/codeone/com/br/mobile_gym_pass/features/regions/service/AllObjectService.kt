package codeone.com.br.mobile_gym_pass.features.regions.service

import codeone.com.br.mobile_gym_pass.commons.constant.WebService
import codeone.com.br.mobile_gym_pass.commons.util.createRetrofitService
import codeone.com.br.mobile_gym_pass.features.company.domain.Empresa
import codeone.com.br.mobile_gym_pass.features.regions.domain.Regiao
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

class AllObjectService {

    interface RetrofitService{
        @GET("api/values")
        fun getAllRegions(): Call<MutableList<Regiao>>
        @GET("api/values")
        fun getCompanyByIdLocation(@Query("id")id:Int):Call<MutableList<Empresa>>

    }
    companion object Factory{
        @Throws
        fun getAllRegions():MutableList<Regiao>{
            val service = createRetrofitService<RetrofitService>(WebService.BASE_URL)
            val execute = service.getAllRegions().execute()
            val responseVO = execute.body()

            responseVO?.let {
                return it
            }
            throw Throwable("")
        }
        @Throws
        fun getCompanyByIdLocation(id:Int):MutableList<Empresa>{
            val service = createRetrofitService<RetrofitService>(WebService.BASE_URL)
            val execute = service.getCompanyByIdLocation(id).execute()
            val responseVo = execute.body()
            responseVo?.let {
                return it
            }
            throw Throwable("")
        }
    }
}