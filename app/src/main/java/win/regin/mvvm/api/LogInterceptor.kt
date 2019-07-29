package win.regin.mvvm.api

import com.orhanobut.logger.Logger
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody

/**
 * @author :Reginer in  19-6-19 下午1:13.
 * 联系方式:QQ:282921012
 * 功能描述:http拦截器
 */
class LogInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        Logger.i("request  is::$request")
        val response = chain.proceed(chain.request())
        val mediaType = response.body?.contentType()
        val content = response.body?.string() ?: ""
        Logger.i("response  is::$content")
        return response.newBuilder().body(content.toResponseBody(mediaType)).build()
    }
}
