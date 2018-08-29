package codeone.com.br.mobile_gym_pass.commons.util

@Throws
inline fun <reified T : Exception> checkForErros(message:String){
    val newInstance = T::class.java.getConstructor(String::class.java).newInstance(message)
    throw newInstance
}