package android.example.flowerschemistry.data

import android.content.Context
import android.content.SharedPreferences
import android.example.flowerschemistry.Constants

class UserPreferences(context: Context){
    private val prefs: SharedPreferences =
        context.getSharedPreferences("TestApp", Context.MODE_PRIVATE)
    private val editor = prefs.edit()

    fun delete(){
        editor.clear()
        editor.commit()
    }

    fun saveUserName(name: String?){
        if (name != null){
            editor.putString(Constants.CLIENT_NAME,name).apply()
        }
    }

    fun saveToken(token: String?) {
        editor.putString(Constants.TOKEN, token)
        editor.apply()
    }

    fun saveUserNumber(number: String?) {
        if (number != null) {
            editor.putString(Constants.CLIENT_NUMBER, number)
            editor.apply()
        }
    }

    fun fetchToken(): String? {
        return prefs.getString(Constants.TOKEN, null)
    }

    fun fetchUserName():String? {
        return prefs.getString(Constants.CLIENT_NAME, null)
    }

    fun fetchUserNumber(): String? {
        return prefs.getString(Constants.CLIENT_NUMBER, null)
    }
}

