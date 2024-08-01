import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class RegisterUserViewModel(private val userDao: UserDao) : ViewModel() {

    fun registerUser(name: String, email: String, password: String) {
        viewModelScope.launch {
            val user = User(name = name, email = email)
            userDao.insert(user)
        }
    }
}
