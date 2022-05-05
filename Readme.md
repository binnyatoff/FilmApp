# FilmApp
Приложение для просмотра списка фильмов в виде ленты
## Стек
* Dagger 2
* Coroutines
* Glide
* Retrofit
* ViewBinding
* Paging

## Cтруктура приложения
* Data - содержит в себе работу с сетью
* Data/network/models - модели ретрофита
* Data/FilmService - интерфейс ретрофита
* Data/Films и Data/Mapper -  преобразование моделей ретрофита во внутренние модели
* di - внедрение зависимостей Dagger 2
* Screens - содержит две Активити (Сплэш и Главну со списком)
* Screen/RecyclerView - используется для списка

Для RecyclerView использовался PagingDataAdapter(реализация пагинации) и LoadStateAdapter(реализация 3 стейтов: Загрузка, Нечего загружать, Ошибка)

SplashScreen - реализован при помощи темы и background