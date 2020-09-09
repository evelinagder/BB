package com.example.chuck.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.chuck.categorieslist.CategoriesFragmentViewModel
import com.example.service.category.CategoryListRepository
import dagger.MapKey
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton
import kotlin.reflect.KClass

@Singleton
class ViewModelFactory @Inject constructor(
    private val viewModels: MutableMap<Class<out ViewModel>,
            Provider<ViewModel>>
) : ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val creator = viewModels[modelClass] ?: viewModels.entries.firstOrNull {
            modelClass.isAssignableFrom(it.key)
        }?.value ?: throw IllegalArgumentException(
            "Unknown model class $modelClass. " +
                    "Did you define your provides-functions? "
        )

        @Suppress("UNCHECKED_CAST")
        return creator.get() as T
    }
}

@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@MapKey
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)

@Module
class ViewModelModule {

    @Provides
    fun providesViewModelFactory(viewModels: MutableMap<Class<out ViewModel>, Provider<ViewModel>>): ViewModelFactory =
        ViewModelFactory(viewModels)

    @Provides
    @IntoMap
    @ViewModelKey(CategoriesFragmentViewModel::class)
    fun provideCategoriesViewModel(categoryListRepository: CategoryListRepository):
            ViewModel = CategoriesFragmentViewModel(categoryListRepository)
}