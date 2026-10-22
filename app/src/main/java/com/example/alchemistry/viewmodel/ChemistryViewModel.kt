package com.example.alchemistry.viewmodel

import android.app.Application
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import com.example.alchemistry.model.ChemistryRepository
import com.example.alchemistry.model.TopicCategory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

enum class AppScreen {
    Dashboard,
    Topics,
    Resources,
    Tracker
}

data class ChemistryUiState(
    val currentScreen: AppScreen = AppScreen.Dashboard,
    val selectedCategory: String = "all",
    val searchQuery: String = "",
    val completedLessons: Set<String> = emptySet(),
    val totalLessonsCount: Int = ChemistryRepository.totalLessonsCount
) {
    val completedCount: Int get() = completedLessons.size
    val completionPercentage: Int get() = if (totalLessonsCount > 0) {
        ((completedCount.toFloat() / totalLessonsCount.toFloat()) * 100f).toInt().coerceIn(0, 100)
    } else 0
}

class ChemistryViewModel(application: Application) : AndroidViewModel(application) {

    private val prefs = application.getSharedPreferences("al_chemistry_prefs", Context.MODE_PRIVATE)
    private val PREF_COMPLETED_KEY = "completed_lessons_set"

    private val _uiState = MutableStateFlow(ChemistryUiState())
    val uiState: StateFlow<ChemistryUiState> = _uiState.asStateFlow()

    init {
        val saved = prefs.getStringSet(PREF_COMPLETED_KEY, emptySet()) ?: emptySet()
        _uiState.update { it.copy(completedLessons = saved) }
    }

    fun selectScreen(screen: AppScreen) {
        _uiState.update { it.copy(currentScreen = screen) }
    }

    fun setCategoryFilter(categoryId: String) {
        _uiState.update { it.copy(selectedCategory = categoryId) }
    }

    fun filterAndNavigateToTopics(categoryId: String) {
        _uiState.update {
            it.copy(
                selectedCategory = categoryId,
                currentScreen = AppScreen.Topics
            )
        }
    }

    fun setSearchQuery(query: String) {
        _uiState.update { it.copy(searchQuery = query) }
    }

    fun toggleLesson(lessonId: String) {
        _uiState.update { state ->
            val updated = if (state.completedLessons.contains(lessonId)) {
                state.completedLessons - lessonId
            } else {
                state.completedLessons + lessonId
            }
            prefs.edit().putStringSet(PREF_COMPLETED_KEY, updated).apply()
            state.copy(completedLessons = updated)
        }
    }

    fun resetProgress() {
        prefs.edit().remove(PREF_COMPLETED_KEY).apply()
        _uiState.update { it.copy(completedLessons = emptySet()) }
    }

    fun openUrl(context: Context, url: String) {
        try {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            context.startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(context, "Could not open link: ${e.localizedMessage}", Toast.LENGTH_SHORT).show()
        }
    }
}
