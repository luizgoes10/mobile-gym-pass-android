package codeone.com.br.mobile_gym_pass.commons.util

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


fun Date.toDateString(pattern: String = "dd/MM/yyyy", locale: Locale = Locale("pt","BR")): String {

    val format = SimpleDateFormat(pattern, locale)
    return try {
        format.format(this)
    } catch (e: Exception) {
        ""
    }
}

fun Date.toDate(pattern: String = "dd/MM/yyyy", locale: Locale = Locale("pt", "BR")): Date? {
    val format = SimpleDateFormat(pattern, locale)
    return try {
        val format1 = format.format(this)
        val parse = format.parse(format1)
        this.time = parse.time
        parse
    } catch (e: ParseException) {
        null
    }

}

fun Date.compareToWithPatter(date: Date, pattern: String = "yyyyMMdd"): Int? {
    val toDate = this.toDate(pattern)
    val toCompare = date.toDate(pattern)
    return toDate?.compareTo(toCompare)
}

/**
 * Retorna o valor do hor?rio minimo para a data de referencia passada. <BR>
 * <BR>
 * Por exemplo se a data for "30/01/2009 as 17h:33m:12s e 299ms" a data
 * retornada por este metodo ser? "30/01/2009 as 00h:00m:00s e 000ms".
 *
 * @return {@link Date} que representa o hor?rio minimo para dia
 * informado.
 */
fun Date.lowDateTime(): Date {
    val aux = Calendar.getInstance()
    aux.time = this
    aux.toOnlyDate() // zera os parametros de hour,min,sec,milisec
    return aux.time
}

/**
 * Retorna o valor do hor?rio maximo para a data de referencia passada. <BR></BR>
 * <BR></BR>
 * Por exemplo se a data for "30/01/2009 as 17h:33m:12s e 299ms" a data
 * retornada por este metodo ser? "30/01/2009 as 23h:59m:59s e 999ms".
 * *
 * @return [Date] que representa o hor?rio maximo para dia
 * * informado.
 */
fun Date.highDateTime(): Date {
    val aux = Calendar.getInstance()
    aux.time = this
    aux.toOnlyDate() // zera os parametros de hour,min,sec,milisec
    aux.add(Calendar.DATE, 1) // vai para o dia seguinte
    aux.add(Calendar.MILLISECOND, -1) // reduz 1 milisegundo
    return aux.time
}

fun Date.zeraTempo(): Date {
    val c = Calendar.getInstance()
    c.time = this
    c.set(Calendar.HOUR, 0)
    c.set(Calendar.MINUTE, 0)
    c.set(Calendar.SECOND, 0)
    c.set(Calendar.MILLISECOND, 0)
    return c.time
}

fun Date.getDia(): Int {

    val c = Calendar.getInstance()
    c.time = this

    val dia = c.get(Calendar.DAY_OF_MONTH)
    return dia
}

fun Date.getMes(): Int {

    val c = Calendar.getInstance()
    c.time = this

    val mes = c.get(Calendar.MONTH) + 1
    return mes
}

fun Date.getAno(): Int {

    val c = Calendar.getInstance()
    c.time = this

    val ano = c.get(Calendar.YEAR)
    return ano
}

/**
 * http://www.exampledepot.com/egs/java.util/CompDates.html
 *
 *
 * Retorna a quantidade de horas de diferen�a entre a data informada e a
 * data atual

 * @return
 */
fun Date.getDiferenceInHours(dataFinal: Date): Long {
    val c1 = Calendar.getInstance()
    c1.time = this

    val c2 = Calendar.getInstance()
    c2.time = dataFinal

    val diffMillis = c2.timeInMillis - c1.timeInMillis
    val diffHours = diffMillis / (60 * 60 * 1000)

    return diffHours
}

/**
 * http://www.exampledepot.com/egs/java.util/CompDates.html
 *
 *
 * Retorna a quantidade de horas de diferen�a entre a data informada e a
 * data atual

 * @return
 */
fun Date.getDiferenceInDays(dataFinal: Date): Long {
    val c1 = Calendar.getInstance()
    c1.time = this

    val c2 = Calendar.getInstance()
    c2.time = dataFinal

    val diffMillis = c2.timeInMillis - c1.timeInMillis
    val diffDays = diffMillis / (24 * 60 * 60 * 1000)

    return diffDays
}

/**
 * Faz a soma de 1 dia na data especificada, corrigindo o problema com
 * hor�rio de ver�o.<br></br>
 *
 *
 * Se por acaso o calendar do Java (ao somar 1 dia), continuar no mesmo dia
 * se for hor�rio de ver�o (ex: horario de ver�o perde 1 hora, e volta
 * para as 23h) O algoritmo for�a a troca de dia

 * @return
 * *
 * @author Ricardo R. Lecheta
 * *
 * @since v2.0, 14/1/2009
 */
fun Date.addDiaHorarioVerao(dias: Int = 1): Date {
    val c = Calendar.getInstance()
    c.time = this

    val dia1 = c.get(Calendar.DAY_OF_MONTH)
    c.add(Calendar.DATE, dias)
    val dia2 = c.get(Calendar.DAY_OF_MONTH)
    if (dia1 == dia2) {
        c.add(Calendar.DATE, dias)
    }

    c.set(Calendar.HOUR_OF_DAY, 0)
    c.set(Calendar.MINUTE, 0)
    c.set(Calendar.SECOND, 0)
    c.set(Calendar.MILLISECOND, 0)
    c.set(Calendar.HOUR_OF_DAY, 0)

    val data = c.time
    return data
}

fun Date.getMesDesc(locale: Locale = Locale("pt","BR")): String {
    return toDateString("MMMMM", locale)
}

fun Date.getMesDescAbrev(locale: Locale = Locale("pt","BR")): String {
    return toDateString("MMM", locale)
}

infix fun Date.isMaiorQue(dateB: Date): Boolean {
    return this > dateB
}

infix fun Date.isIgualA(dateB: Date): Boolean {
    return this === dateB
}

infix fun Date.isMenorQue(dateB: Date): Boolean {
    return this < dateB
}

fun Date.isMesmoDia(date2: Date): Boolean {
    val cal1 = Calendar.getInstance()
    cal1.time = this
    val cal2 = Calendar.getInstance()
    cal2.time = date2
    return cal1.isMesmoDia(cal2)
}

/**
 *
 * Checks if a date is today.
 * *
 * @return true if the date is today.
 * *
 * @throws IllegalArgumentException if the date is `null`
 */
fun Date.isHoje(): Boolean {
    return isMesmoDia(Calendar.getInstance().time)
}

fun Date.isOntem(): Boolean {
    val c1 = Calendar.getInstance() // today
    c1.add(Calendar.DAY_OF_YEAR, -1) // yesterday

    val c2 = Calendar.getInstance()
    c2.time = this

    if (c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR) && c1.get(Calendar.DAY_OF_YEAR) == c2.get(Calendar.DAY_OF_YEAR)) {
        return true
    }
    return false
}

/**
 * Retorna o numero de dias uteis no mes que ocorreram antes desta Data
 *
 *
 * Jan = 1

 * @return
 */
fun Date.getDiasUteisAteDia(): Int {
    val diaFim = getDia()
    val mes = getMes()

    val c = Calendar.getInstance()
    c.set(Calendar.MONTH, mes - 1)
    var dias = 0
    for (i in 1 until diaFim) {
        c.set(Calendar.DAY_OF_MONTH, i)
        if (c.time.isDiaSemana()) {
            dias++
        }

    }
    return dias
}

/**
 * Retorna o numero de dias uteis no mes que ainda tem depois desta Data
 * *
 * @return
 */
val ULTIMA_DIA_MES = intArrayOf(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
fun Date.getDiasUteisDepoisDia(): Int {
    val diaInicio = getDia()
    val mes = getMes()

    val c = Calendar.getInstance()
    c.set(Calendar.MONTH, mes - 1)
    var dias = 0
    val diasMes = ULTIMA_DIA_MES[mes - 1]
    for (i in diaInicio + 1..diasMes) {
        c.set(Calendar.DAY_OF_MONTH, i)
        if (c.time.isDiaSemana()) {
            dias++
        }

    }
    return dias
}

/**
 * � domingo?
 * *
 * @return
 */
fun Date.isDomingo(): Boolean {
    val c = Calendar.getInstance()
    c.time = this
    val dia = c.get(Calendar.DAY_OF_WEEK)

    val b = dia == Calendar.SUNDAY

    return b
}

/**
 * � s�bado?
 * *
 * @return
 */
fun Date.isSabado(): Boolean {
    val c = Calendar.getInstance()
    c.time = this
    val dia = c.get(Calendar.DAY_OF_WEEK)

    val b = dia == Calendar.SATURDAY

    return b
}

/**
 * Verifica se a data � de 2�-feira a 6�-feira
 * *
 * @return
 */
fun Date.isDiaSemana(): Boolean {
    val c = Calendar.getInstance()
    c.time = this
    val dia = c.get(Calendar.DAY_OF_WEEK)

    return when (dia) {
        Calendar.MONDAY, Calendar.TUESDAY, Calendar.WEDNESDAY, Calendar.THURSDAY, Calendar.FRIDAY -> true
        else -> false
    }
}

// Data Feriado Motiva??o
// 1? de janeiro Confraterniza??o Universal social
// 21 de abril Tiradentes c?vica
// 1 de maio Dia do Trabalho social
// 7 de setembro Independ?ncia do Brasil c?vica
// 12 de outubro Nossa Senhora Aparecida religiosa (cat?lica)
// 2 de novembro Finados religiosa (cat?lica)
// 15 de novembro Proclama??o da Rep?blica c?vica
// 25 de dezembro Natal religiosa (crist?)
// from http://pt.wikipedia.org/wiki/Feriados_no_Brasil


//region Add utils
private fun Date.add(typeCalendar: Int, value: Int): Date {
    val c = Calendar.getInstance()
    c.time = this
    c.add(typeCalendar, value)
    time = c.timeInMillis
    return this
}

private fun Date.remove(typeCalendar: Int, value: Int): Date {
    val c = Calendar.getInstance()
    c.time = this
    c.add(typeCalendar, (- value))
    time = c.timeInMillis
    return this
}

fun Date.addDay(dias: Int = 1): Date {
    return add(Calendar.DATE, dias)
}

fun Date.removeDay(dias: Int = 1): Date {
    return remove(Calendar.DATE, dias)
}

fun Date.addMonth(months: Int = 1): Date {
    return add(Calendar.MONTH, months)
}

fun Date.removeMonth(months: Int = 1): Date {
    return remove(Calendar.MONTH, months)
}

fun Date.addYear(years: Int = 1): Date {
    return add(Calendar.YEAR, years)
}

fun Date.removeYear(years: Int = 1): Date {
    return remove(Calendar.YEAR, years)
}

fun Date.addHour(hour: Int = 1): Date {
    return add(Calendar.HOUR, hour)
}

fun Date.removeHour(hour: Int = 1): Date {
    return remove(Calendar.HOUR, hour)
}

fun Date.addMinute(minute: Int = 1): Date {
    return add(Calendar.MINUTE, minute)
}

fun Date.removeMinute(minute: Int = 1): Date {
    return remove(Calendar.MINUTE, minute)
}

fun Date.addSeconds(minute: Int = 1): Date {
    return add(Calendar.SECOND, minute)
}

fun Date.removeSecond(minute: Int = 1): Date {
    return remove(Calendar.SECOND, minute)
}
//endregion

fun Calendar.toOnlyDate () {
    this.set(Calendar.HOUR_OF_DAY, 0)
    this.set(Calendar.MINUTE, 0)
    this.set(Calendar.SECOND, 0)
    this.set(Calendar.MILLISECOND, 0)
}

/**
 *
 * Checks if two calendars represent the same day ignoring time.
 * *
 * @param cal2 the second calendar, not altered, not null
 * *
 * @return true if they represent the same day
 * *
 * @throws IllegalArgumentException if either calendar is `null`
 */
fun Calendar.isMesmoDia(cal2: Calendar): Boolean {
    return this.get(Calendar.ERA) == cal2.get(Calendar.ERA) &&
            this.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
            this.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR)
}

/**
 *
 * Checks if a calendar date is today.
 * *
 * @return true if cal date is today
 * *
 * @throws IllegalArgumentException if the calendar is `null`
 */
fun Calendar.isHoje(): Boolean {
    return isMesmoDia(Calendar.getInstance())
}