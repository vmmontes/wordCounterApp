package com.vmmontes.wordcounterapp.kernel.coroutines
import android.util.Log
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext

var mainContext = Dispatchers.Main + UncaughtCoRoutineExceptionHandler()
var backgroundContext = Dispatchers.IO + UncaughtCoRoutineExceptionHandler()

class UncaughtCoRoutineExceptionHandler :
    CoroutineExceptionHandler, AbstractCoroutineContextElement(CoroutineExceptionHandler.Key) {
    override fun handleException(context: CoroutineContext, exception: Throwable) {
        Log.e("Coroutines Error", exception.localizedMessage)
    }
}