package codeone.com.br.mobile_gym_pass.features.descricao.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Descricao(@SerializedName("IdDescricao")var idDescricao:Int,@SerializedName("nmDescricao")var nmDescricao:String,@SerializedName("IdBox")var idBox:Int):Parcelable {
}