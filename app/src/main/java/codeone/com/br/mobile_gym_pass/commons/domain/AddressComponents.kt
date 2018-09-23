package codeone.com.br.mobile_gym_pass.commons.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AddressComponents(
      @SerializedName("long_name")
      var longName:String,
      @SerializedName("short_name")
      var shortName:String,
      @SerializedName("types")
      var types:MutableList<String>
):Parcelable {
}